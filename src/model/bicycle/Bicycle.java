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

    /**
     * На данный момент просто рисует каркас велосипеда
     *
     * @param graphics
     */
    public void onInit(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        // верхняя палка. На ней сиденье, и она смежна с двумя палками, соединяющими 2 разных колеса. Чертится слева направо
        graphics.drawLine(
                wheels.getFirstCenterX() + wheels.getRadius() - 20,
                wheels.getFirstCenterY() - wheels.getRadius() - 20,
                wheels.getSecondCenterX() - wheels.getRadius(),
                wheels.getSecondCenterY() - wheels.getRadius() - 10
        );
        // руля до переднего колеса. Чертится от колеса к рулю
        graphics.drawLine(
                wheels.getFirstCenterX(),
                wheels.getFirstCenterY(),
                wheels.getFirstCenterX() + wheels.getRadius() - 16,
                wheels.getFirstCenterY() - wheels.getRadius() - 30
        );
        // палка от верхней палки к центру правого колеса. Чертится от колеса к палке
        graphics.drawLine(
                wheels.getSecondCenterX(),
                wheels.getSecondCenterY(),
                wheels.getSecondCenterX() - wheels.getRadius(),
                wheels.getSecondCenterY() - wheels.getRadius() - 10
        );
        // палка, соединяющая заднее колесо с педалями (от колеса к педалям)
        graphics.drawLine(
                wheels.getSecondCenterX(),
                wheels.getSecondCenterY(),
                wheels.getSecondCenterX() - wheels.getRadius() - 25,
                wheels.getSecondCenterY()
        );
        // палка, соединяющая сиденье с педалями (от педалей к сиденью)
        graphics.drawLine(
                wheels.getSecondCenterX() - wheels.getRadius() - 25,
                wheels.getSecondCenterY(),
                wheels.getSecondCenterX() - wheels.getRadius() + 7,
                wheels.getSecondCenterY() - wheels.getRadius() - 20
        );
        // палка, соединяющая руль с педалями (от педалей к рулю)
        graphics.drawLine(
                wheels.getSecondCenterX() - wheels.getRadius() - 25,
                wheels.getSecondCenterY(),
                wheels.getFirstCenterX() + wheels.getRadius() - 20,
                wheels.getFirstCenterY() - wheels.getRadius() - 20
        );
        // руль (сверху вниз)
        graphics.drawLine(
                wheels.getFirstCenterX() + wheels.getRadius() - 15,
                wheels.getFirstCenterY() - wheels.getRadius() - 50,
                wheels.getFirstCenterX() + wheels.getRadius() - 15,
                wheels.getFirstCenterY() - wheels.getRadius() - 10
        );
        // сиденье
        graphics.fillOval(
                wheels.getSecondCenterX() - wheels.getRadius() - 20,
                wheels.getSecondCenterY() - wheels.getRadius() - 30,
                50,
                20
        );
    }

    public void process(Graphics graphics) {
        getPedalAndHuman().process(graphics);
        getWheels().process(graphics);
        getBackground().process(graphics);
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
