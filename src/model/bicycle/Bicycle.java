package model.bicycle;

import model.Background;

import java.awt.*;

public class Bicycle {
    // задний фон относительно велосипеда
    private Background background = new Background(this);
    // педали и человек. Пришлось соединит ьвместе для синхронизации ног с педалями
    private PedalAndHuman pedalAndHuman = new PedalAndHuman(this);
    // колеса велосипеда
    private Wheels wheels = new Wheels(this);
    // на последний process() скорость велосипеда в у.е. была...
    private double speed = 0;

    public void process(Graphics graphics) {
        if (getSpeed() == 0) {
            return;
        }

        getPedalAndHuman().process();
        getWheels().process();
        getBackground().process();
        updateSpeed();
    }

    public void updateSpeed() {

    }

    public PedalAndHuman getPedalAndHuman() {
        return pedalAndHuman;
    }

    public void setPedalAndHuman(PedalAndHuman pedalAndHuman) {
        this.pedalAndHuman = pedalAndHuman;
    }

    public Wheels getWheels() {
        return wheels;
    }

    public void setWheels(Wheels wheels) {
        this.wheels = wheels;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Background getBackground() {
        return background;
    }

    public void setBackground(Background background) {
        this.background = background;
    }
}
