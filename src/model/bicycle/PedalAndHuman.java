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

        double stateInRadians = getState() * GlobalVar.DOUBLE_PI;
        int firstPedalXPos = getBicycle().getWheels().getSECOND_CENTER_X()
                - getBicycle().getWheels().getRADIUS()
                - 33
                + (int) Math.round(Math.cos(-stateInRadians) * 20);
        int firstPedalYPos = getBicycle().getWheels().getSECOND_CENTER_Y()
                + (int) Math.round(Math.sin(-stateInRadians) * 20);
        int secondPedalXPos = getBicycle().getWheels().getSECOND_CENTER_X()
                - getBicycle().getWheels().getRADIUS()
                - 33
                + (int) Math.round(Math.cos(-stateInRadians + Math.PI) * 20);
        ;
        int secondPedalYPos = getBicycle().getWheels().getSECOND_CENTER_Y()
                + (int) Math.round(Math.sin(-stateInRadians + Math.PI) * 20);

        /* педали */

        // педаль №1
        graphics.setColor(new Color(33, 0, 0));
        graphics.fillRect(
                firstPedalXPos,
                firstPedalYPos,
                20,
                6
        );
        // педаль №2
        graphics.setColor(new Color(0, 33, 0));
        graphics.fillRect(
                secondPedalXPos,
                secondPedalYPos,
                20,
                6
        );
        graphics.setColor(Color.BLACK);
        // палка до середины педали №1
        graphics.drawLine(
                getBicycle().getWheels().getSECOND_CENTER_X() - getBicycle().getWheels().getRADIUS() - 25,
                getBicycle().getWheels().getSECOND_CENTER_Y(),
                firstPedalXPos + 10,
                firstPedalYPos + 3
        );
        // палка до середины педали №2
        graphics.drawLine(
                getBicycle().getWheels().getSECOND_CENTER_X() - getBicycle().getWheels().getRADIUS() - 25,
                getBicycle().getWheels().getSECOND_CENTER_Y(),
                secondPedalXPos + 10,
                secondPedalYPos + 3
        );

        /* человек */

        // голень человека на педали №1 (от педали до колена)
        graphics.drawLine(
                firstPedalXPos + 10,
                firstPedalYPos + 3,
                getBicycle().getWheels().getSECOND_CENTER_X() - getBicycle().getWheels().getRADIUS() - 55,
                getBicycle().getWheels().getSECOND_CENTER_Y() - getBicycle().getWheels().getRADIUS() - 30 - (getBicycle().getWheels().getSECOND_CENTER_Y() - firstPedalYPos)
        );
        // голень человека на педали №2 (от педали до колена)
        graphics.drawLine(
                secondPedalXPos + 10,
                secondPedalYPos + 3,
                getBicycle().getWheels().getSECOND_CENTER_X() - getBicycle().getWheels().getRADIUS() - 55,
                getBicycle().getWheels().getSECOND_CENTER_Y() - getBicycle().getWheels().getRADIUS() - 30 - (getBicycle().getWheels().getSECOND_CENTER_Y() - secondPedalYPos)
        );
        // бедро человека на педали №1 (от бедра к голени)
        graphics.drawLine(
                getBicycle().getWheels().getSECOND_CENTER_X() - getBicycle().getWheels().getRADIUS() + 20,
                getBicycle().getWheels().getSECOND_CENTER_Y() - getBicycle().getWheels().getRADIUS() - 20,
                getBicycle().getWheels().getSECOND_CENTER_X() - getBicycle().getWheels().getRADIUS() - 55,
                getBicycle().getWheels().getSECOND_CENTER_Y() - getBicycle().getWheels().getRADIUS() - 30 - (getBicycle().getWheels().getFIRST_CENTER_Y() - firstPedalYPos)
        );
        // бедро человека на педали №2 (от бедра к голени)
        graphics.drawLine(
                getBicycle().getWheels().getSECOND_CENTER_X() - getBicycle().getWheels().getRADIUS() + 20,
                getBicycle().getWheels().getSECOND_CENTER_Y() - getBicycle().getWheels().getRADIUS() - 20,
                getBicycle().getWheels().getSECOND_CENTER_X() - getBicycle().getWheels().getRADIUS() - 55,
                getBicycle().getWheels().getSECOND_CENTER_Y() - getBicycle().getWheels().getRADIUS() - 30 - (getBicycle().getWheels().getSECOND_CENTER_Y() - secondPedalYPos)
        );
        // туловище (от бедер к шее)
        graphics.drawLine(
                getBicycle().getWheels().getSECOND_CENTER_X() - getBicycle().getWheels().getRADIUS() + 20,
                getBicycle().getWheels().getSECOND_CENTER_Y() - getBicycle().getWheels().getRADIUS() - 20,
                getBicycle().getWheels().getSECOND_CENTER_X() - getBicycle().getWheels().getRADIUS() - 50,
                getBicycle().getWheels().getSECOND_CENTER_Y() - 150
        );
        // рука №1 (правая, от плеч до руля)
        graphics.drawLine(
                getBicycle().getWheels().getSECOND_CENTER_X() - getBicycle().getWheels().getRADIUS() - 50,
                getBicycle().getWheels().getSECOND_CENTER_Y() - 150,
                getBicycle().getWheels().getFIRST_CENTER_X() + getBicycle().getWheels().getRADIUS() - 15,
                getBicycle().getWheels().getFIRST_CENTER_Y() - getBicycle().getWheels().getRADIUS() - 40
        );
        // рука №2 (левая, от плеч до руля)
        graphics.drawLine(
                getBicycle().getWheels().getSECOND_CENTER_X() - getBicycle().getWheels().getRADIUS() - 50,
                getBicycle().getWheels().getSECOND_CENTER_Y() - 150,
                getBicycle().getWheels().getFIRST_CENTER_X() + getBicycle().getWheels().getRADIUS() - 15,
                getBicycle().getWheels().getFIRST_CENTER_Y() - getBicycle().getWheels().getRADIUS() - 20
        );
        // голова
        graphics.fillOval(
                getBicycle().getWheels().getSECOND_CENTER_X() - getBicycle().getWheels().getRADIUS() - 90,
                getBicycle().getWheels().getSECOND_CENTER_Y() - 190,
                50,50
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
