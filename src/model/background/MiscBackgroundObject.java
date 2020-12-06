package model.background;

import util.GlobalVar;

import java.awt.*;

public abstract class MiscBackgroundObject {
    private double currentPosX;
    private double currentPosY;
    private final double SHIFT_COEFFICIENT;
    private Background background;

    public MiscBackgroundObject(double currentPosX, double currentPosY, Background background) {
        setCurrentPosX(currentPosX);
        setCurrentPosY(currentPosY);
        setBackground(background);
        SHIFT_COEFFICIENT = getCurrentPosY() / (GlobalVar.GLADE_HEIGHT + GlobalVar.SKIES_HEIGHT) * 0.66;
    }

    public void process(Graphics graphics) {
        setCurrentPosX(getCurrentPosX() + getBackground().getBicycle().getSpeed() * SHIFT_COEFFICIENT);
        redraw(graphics);
    }

    public abstract void redraw(Graphics graphics);

    public boolean isStillRelevant() {
        return getCurrentPosX() < GlobalVar.WINDOW_WIDTH;
    }

    public double getCurrentPosX() {
        return currentPosX;
    }

    public void setCurrentPosX(double currentPosX) {
        this.currentPosX = currentPosX;
    }

    public double getCurrentPosY() {
        return currentPosY;
    }

    public void setCurrentPosY(double currentPosY) {
        this.currentPosY = currentPosY;
    }

    public Background getBackground() {
        return background;
    }

    public void setBackground(Background background) {
        this.background = background;
    }
}
