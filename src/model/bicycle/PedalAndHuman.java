package model.bicycle;

import util.GlobalVar;

import java.awt.*;

public class PedalAndHuman {
    private double prevState = 0;
    private double state = 0;
    private Bicycle bicycle;

    public PedalAndHuman(Bicycle bicycle) {
        setBicycle(bicycle);
    }

    public void process(Graphics graphics) {
        updateState();

        graphics.setColor(Color.BLACK);
        double stateInRadians = getState() * GlobalVar.DOUBLE_PI;
        int firstPedalXPos = getBicycle().getWheels().getSECOND_CENTER_X()
                        - getBicycle().getWheels().getRADIUS()
                        - 33
                        + (int) Math.round(Math.cos(-stateInRadians) * 20);
        int firstPedalYPos = getBicycle().getWheels().getSECOND_CENTER_Y()
                + (int) Math.round(Math.sin(-stateInRadians) * 20);
        int secondPedalXPos = 0;
        int secondPedalYPos = 0;
        graphics.fillRect(
                firstPedalXPos,
                firstPedalYPos,
                20,
                6
        );
        graphics.drawLine(
                getBicycle().getWheels().getSECOND_CENTER_X() - getBicycle().getWheels().getRADIUS() - 25,
                getBicycle().getWheels().getSECOND_CENTER_Y(),
                firstPedalXPos + 10,
                firstPedalYPos + 3
                );
    }

    public void updateState() {
        setPrevState(getState());
        double temp = getState() + getBicycle().getSpeed() / 1000;
        setState(temp - (int) temp);
    }

    public double getState() {
        return state;
    }

    public void setState(double state) {
        this.setPrevState(this.state);
        this.state = state;
    }

    public Bicycle getBicycle() {
        return bicycle;
    }

    public void setBicycle(Bicycle bicycle) {
        this.bicycle = bicycle;
    }

    public double getPrevState() {
        return prevState;
    }

    public void setPrevState(double prevState) {
        this.prevState = prevState;
    }
}
