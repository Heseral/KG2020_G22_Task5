package model.bicycle;

import model.background.Background;

import java.awt.*;

public class Bicycle {
    // задний фон относительно велосипеда
    private Background background = new Background(this);
    // колеса велосипеда
    private Wheels wheels = new Wheels(this);
    // педали и человек. Пришлось соединит ьвместе для синхронизации ног с педалями
    private PedalAndHuman pedalAndHuman = new PedalAndHuman(this);
    // на последний process() скорость велосипеда в у.е. была...
    private double speed = 0;

    /**
     * На данный момент просто рисует каркас велосипеда
     *
     * @param graphics
     */
    public void onInit(Graphics graphics) {
        background.onInit(graphics);

        graphics.setColor(Color.BLACK);
        // верхняя палка. На ней сиденье, и она смежна с двумя палками, соединяющими 2 разных колеса. Чертится слева направо
        graphics.drawLine(
                wheels.getFIRST_CENTER_X() + wheels.getRADIUS() - 20,
                wheels.getFIRST_CENTER_Y() - wheels.getRADIUS() - 20,
                wheels.getSECOND_CENTER_X() - wheels.getRADIUS(),
                wheels.getSECOND_CENTER_Y() - wheels.getRADIUS() - 10
        );
        // руля до переднего колеса. Чертится от колеса к рулю
        graphics.drawLine(
                wheels.getFIRST_CENTER_X(),
                wheels.getFIRST_CENTER_Y(),
                wheels.getFIRST_CENTER_X() + wheels.getRADIUS() - 16,
                wheels.getFIRST_CENTER_Y() - wheels.getRADIUS() - 30
        );
        // палка от верхней палки к центру правого колеса. Чертится от колеса к палке
        graphics.drawLine(
                wheels.getSECOND_CENTER_X(),
                wheels.getSECOND_CENTER_Y(),
                wheels.getSECOND_CENTER_X() - wheels.getRADIUS(),
                wheels.getSECOND_CENTER_Y() - wheels.getRADIUS() - 10
        );
        // палка, соединяющая заднее колесо с педалями (от колеса к педалям)
        graphics.drawLine(
                wheels.getSECOND_CENTER_X(),
                wheels.getSECOND_CENTER_Y(),
                wheels.getSECOND_CENTER_X() - wheels.getRADIUS() - 25,
                wheels.getSECOND_CENTER_Y()
        );
        // палка, соединяющая сиденье с педалями (от педалей к сиденью)
        graphics.drawLine(
                wheels.getSECOND_CENTER_X() - wheels.getRADIUS() - 25,
                wheels.getSECOND_CENTER_Y(),
                wheels.getSECOND_CENTER_X() - wheels.getRADIUS() + 7,
                wheels.getSECOND_CENTER_Y() - wheels.getRADIUS() - 20
        );
        // палка, соединяющая руль с педалями (от педалей к рулю)
        graphics.drawLine(
                wheels.getSECOND_CENTER_X() - wheels.getRADIUS() - 25,
                wheels.getSECOND_CENTER_Y(),
                wheels.getFIRST_CENTER_X() + wheels.getRADIUS() - 20,
                wheels.getFIRST_CENTER_Y() - wheels.getRADIUS() - 20
        );
        // руль (сверху вниз)
        graphics.drawLine(
                wheels.getFIRST_CENTER_X() + wheels.getRADIUS() - 15,
                wheels.getFIRST_CENTER_Y() - wheels.getRADIUS() - 50,
                wheels.getFIRST_CENTER_X() + wheels.getRADIUS() - 15,
                wheels.getFIRST_CENTER_Y() - wheels.getRADIUS() - 10
        );
        // сиденье
        graphics.setColor(new Color(0, 0, 50));
        graphics.fillOval(
                wheels.getSECOND_CENTER_X() - wheels.getRADIUS() - 20,
                wheels.getSECOND_CENTER_Y() - wheels.getRADIUS() - 30,
                50,
                20
        );
    }

    public void process(Graphics graphics) {
        getBackground().process(graphics);
        getPedalAndHuman().process(graphics);
        getWheels().process(graphics);
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
