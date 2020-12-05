package model;

import model.bicycle.Bicycle;

import java.awt.*;

public class Background {
    private Bicycle bicycle;

    public Background(Bicycle bicycle) {
        setBicycle(bicycle);
    }

    public void process(Graphics graphics) {

    }


    public Bicycle getBicycle() {
        return bicycle;
    }

    public void setBicycle(Bicycle bicycle) {
        this.bicycle = bicycle;
    }
}
