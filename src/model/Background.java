package model;

import model.bicycle.Bicycle;

public class Background {
    private Bicycle bicycle;

    public Background(Bicycle bicycle) {
        setBicycle(bicycle);
    }

    public void process() {

    }


    public Bicycle getBicycle() {
        return bicycle;
    }

    public void setBicycle(Bicycle bicycle) {
        this.bicycle = bicycle;
    }
}
