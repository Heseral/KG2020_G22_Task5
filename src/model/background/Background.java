package model.background;

import model.bicycle.Bicycle;
import util.GlobalVar;
import util.Misc;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Background {
    private Bicycle bicycle;
    private double prevState = 0;
    private double state = 0;
    private final double STEP = 550;
    private final Color roadMarkingsColor = new Color(240, 220, 220);
    private List<MiscBackgroundObject> miscBackgroundObjects = new ArrayList<>();
    // чтобы 120 раз в секунду не проходиться по списку объектов...
    private boolean alreadyContentsBumpStop = false;

    public Background(Bicycle bicycle) {
        setBicycle(bicycle);
    }

    /**
     * Рисуется сама дорога без полос, небо и трава на заднем плане
     */
    public void onInit(Graphics graphics) {
        graphics.setColor(new Color(60, 140, 200));
        graphics.fillRect(0, 0, GlobalVar.WINDOW_WIDTH, GlobalVar.SKIES_HEIGHT);
        graphics.setColor(new Color(25, 150, 25));
        graphics.fillRect(0, 100, GlobalVar.WINDOW_WIDTH, GlobalVar.GLADE_HEIGHT);
        graphics.setColor(new Color(50, 50, 50));
        graphics.fillRect(0, 300, GlobalVar.WINDOW_WIDTH, GlobalVar.ROAD_HEIGHT);
    }

    public void process(Graphics graphics) {
        updateState();

        if (Misc.prob(getBicycle().getSpeed() / 25)) {
            miscBackgroundObjects.add(new Tree(
                    -200,
                    Misc.random(GlobalVar.SKIES_HEIGHT, GlobalVar.GLADE_HEIGHT),
                    this
            ));
        }
        if (!isAlreadyContentsBumpStop() && Misc.prob(getBicycle().getSpeed() / 200)) {
            setAlreadyContentsBumpStop(true);
            int length = Misc.random(200, 10000);
            miscBackgroundObjects.add(new BumpStop(length, this));
        }

        for (int i = miscBackgroundObjects.size() - 1; i >= 0; i--) {
            miscBackgroundObjects.get(i).process(graphics);
            if (!miscBackgroundObjects.get(i).isStillRelevant()) {
                miscBackgroundObjects.remove(i);
            }
        }

        graphics.setColor(roadMarkingsColor);
        for (int i = (int) Math.round(-getState() * STEP); i < GlobalVar.WINDOW_WIDTH; i += STEP) {
            graphics.fillRect((int) Math.round(STEP - i), 500, 200, 20);
        }
    }

    public void updateState() {
        setPrevState(getState());
        double temp = getState() + getBicycle().getSpeed() / 1000;
        setState(temp - (int) temp);
    }

    public Bicycle getBicycle() {
        return bicycle;
    }

    public void setBicycle(Bicycle bicycle) {
        this.bicycle = bicycle;
    }

    public double getState() {
        return state;
    }

    public void setState(double state) {
        this.state = state;
    }

    public double getPrevState() {
        return prevState;
    }

    public void setPrevState(double prevState) {
        this.prevState = prevState;
    }

    public boolean isAlreadyContentsBumpStop() {
        return alreadyContentsBumpStop;
    }

    public void setAlreadyContentsBumpStop(boolean alreadyContentsBumpStop) {
        this.alreadyContentsBumpStop = alreadyContentsBumpStop;
    }
}
