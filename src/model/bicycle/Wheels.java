package model.bicycle;

import util.GlobalVar;

import java.awt.*;

public class Wheels {
    private double prevState = 0;
    private double state = 0;
    private Bicycle bicycle;
    private final int radius = 50;
    private final int firstCenterX = 350;
    private final int firstCenterY = 400;
    private final int secondCenterX = 550;
    private final int secondCenterY = getFirstCenterY();
    private final int shift = -50;

    public Wheels(Bicycle bicycle) {
        setBicycle(bicycle);
    }

    public void process(Graphics graphics) {
        updateState();

        graphics.setColor(Color.BLACK);
        graphics.drawOval(getFirstCenterX() + getShift(), getFirstCenterY() + getShift(), getRadius() * 2, getRadius() * 2);
        graphics.drawOval(getSecondCenterX() + getShift(), getSecondCenterY() + getShift(), getRadius() * 2, getRadius() * 2);
        double stateInRadians = state * 2 * Math.PI;
        // спицы для 1 колеса
        for (double i = 0; i < GlobalVar.DOUBLE_PI; i += GlobalVar.PI_DIV_8) {
            graphics.drawLine(
                    getFirstCenterX(),
                    getFirstCenterY(),
                    (int) Math.round(getFirstCenterX() + Math.cos(i - stateInRadians) * getRadius()),
                    (int) Math.round(getFirstCenterY() + Math.sin(i - stateInRadians) * getRadius())
            );
        }
        // спицы для 2 колеса
        for (double i = 0; i < GlobalVar.DOUBLE_PI; i += GlobalVar.PI_DIV_8) {
            graphics.drawLine(
                    getSecondCenterX(),
                    getSecondCenterY(),
                    (int) Math.round(getSecondCenterX() + Math.cos(i - stateInRadians) * getRadius()),
                    (int) Math.round(getSecondCenterY() + Math.sin(i - stateInRadians) * getRadius())
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

    public int getRadius() {
        return radius;
    }

    public int getFirstCenterX() {
        return firstCenterX;
    }

    public int getFirstCenterY() {
        return firstCenterY;
    }

    public int getSecondCenterX() {
        return secondCenterX;
    }

    public int getSecondCenterY() {
        return secondCenterY;
    }

    public int getShift() {
        return shift;
    }
}
