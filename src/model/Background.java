package model;

import model.bicycle.Bicycle;
import util.GlobalVar;

import java.awt.*;

public class Background {
    private Bicycle bicycle;
    private double prevState = 0;
    private double state = 0;
    private final double STEP = 550;

    public Background(Bicycle bicycle) {
        setBicycle(bicycle);
    }

    /**
     * Рисуется сама дорога без полос, небо и трава на заднем плане
     */
    public void onInit(Graphics graphics) {
        graphics.setColor(new Color(60, 140, 200));
        graphics.fillRect(0, 0, GlobalVar.WINDOW_WIDTH, 100);
        graphics.setColor(new Color(25, 150, 25));
        graphics.fillRect(0, 100, GlobalVar.WINDOW_WIDTH, 200);
        graphics.setColor(new Color(50, 50, 50));
        graphics.fillRect(0, 300, GlobalVar.WINDOW_WIDTH, 300);
    }

    public void process(Graphics graphics) {
        updateState();

        graphics.setColor(new Color(240, 220, 220));
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
}
