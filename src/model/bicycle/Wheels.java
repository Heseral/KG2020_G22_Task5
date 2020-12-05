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
    private final int secondCenterY = firstCenterY;
    private final int shift = -50;

    public Wheels(Bicycle bicycle) {
        setBicycle(bicycle);
    }

    public void process(Graphics graphics) {
        updateState();

        graphics.setColor(Color.BLACK);
        graphics.drawOval(firstCenterX + shift, firstCenterY + shift, radius * 2, radius * 2);
        graphics.drawOval(secondCenterX + shift, secondCenterY + shift, radius * 2, radius * 2);
        double stateInRadians = state * 2 * Math.PI;
        // спицы для 1 колеса
        for (double i = 0; i < GlobalVar.DOUBLE_PI; i += GlobalVar.PI_DIV_8) {
            graphics.drawLine(
                    firstCenterX,
                    firstCenterY,
                    (int) Math.round(firstCenterX + Math.cos(i - stateInRadians) * radius),
                    (int) Math.round(firstCenterY + Math.sin(i - stateInRadians) * radius)
            );
        }
        // спицы для 2 колеса
        for (double i = 0; i < GlobalVar.DOUBLE_PI; i += GlobalVar.PI_DIV_8) {
            graphics.drawLine(
                    secondCenterX,
                    secondCenterY,
                    (int) Math.round(secondCenterX + Math.cos(i - stateInRadians) * radius),
                    (int) Math.round(secondCenterY + Math.sin(i - stateInRadians) * radius)
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
}
