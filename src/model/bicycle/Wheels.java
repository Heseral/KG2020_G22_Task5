package model.bicycle;

import util.GlobalVar;

import java.awt.*;

public class Wheels {
    private double prevState = 0;
    private double state = 0;
    private Bicycle bicycle;
    private final int RADIUS = 50;
    private final int FIRST_CENTER_X = 350;
    private final int FIRST_CENTER_Y = 400;
    private final int SECOND_CENTER_X = 550;
    private final int SECOND_CENTER_Y = getFIRST_CENTER_Y();
    private final int SHIFT = -50;

    public Wheels(Bicycle bicycle) {
        setBicycle(bicycle);
    }

    public void process(Graphics graphics) {
        updateState();

        graphics.setColor(Color.BLACK);
        graphics.drawOval(getFIRST_CENTER_X() + getSHIFT(), getFIRST_CENTER_Y() + getSHIFT(), getRADIUS() * 2, getRADIUS() * 2);
        graphics.drawOval(getSECOND_CENTER_X() + getSHIFT(), getSECOND_CENTER_Y() + getSHIFT(), getRADIUS() * 2, getRADIUS() * 2);
        double stateInRadians = state * 2 * Math.PI;
        // спицы для 1 колеса
        for (double i = 0; i < GlobalVar.DOUBLE_PI; i += GlobalVar.PI_DIV_8) {
            graphics.drawLine(
                    getFIRST_CENTER_X(),
                    getFIRST_CENTER_Y(),
                    (int) Math.round(getFIRST_CENTER_X() + Math.cos(i - stateInRadians) * getRADIUS()),
                    (int) Math.round(getFIRST_CENTER_Y() + Math.sin(i - stateInRadians) * getRADIUS())
            );
        }
        // спицы для 2 колеса
        for (double i = 0; i < GlobalVar.DOUBLE_PI; i += GlobalVar.PI_DIV_8) {
            graphics.drawLine(
                    getSECOND_CENTER_X(),
                    getSECOND_CENTER_Y(),
                    (int) Math.round(getSECOND_CENTER_X() + Math.cos(i - stateInRadians) * getRADIUS()),
                    (int) Math.round(getSECOND_CENTER_Y() + Math.sin(i - stateInRadians) * getRADIUS())
            );
        }
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

    public int getRADIUS() {
        return RADIUS;
    }

    public int getFIRST_CENTER_X() {
        return FIRST_CENTER_X;
    }

    public int getFIRST_CENTER_Y() {
        return FIRST_CENTER_Y;
    }

    public int getSECOND_CENTER_X() {
        return SECOND_CENTER_X;
    }

    public int getSECOND_CENTER_Y() {
        return SECOND_CENTER_Y;
    }

    public int getSHIFT() {
        return SHIFT;
    }
}
