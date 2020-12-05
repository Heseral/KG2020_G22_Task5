package model.bicycle;

public class Wheels {
    private double prevState = 0;
    private double state = 0;
    private Bicycle bicycle;

    public Wheels(Bicycle bicycle) {
        setBicycle(bicycle);
    }

    public void process() {

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
