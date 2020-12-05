import model.bicycle.Bicycle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

public class DrawPanel extends JPanel implements KeyListener, MouseWheelListener {
    private Timer timer = new Timer();
    private Bicycle bicycle = new Bicycle();
    private double targetSpeed = bicycle.getSpeed();

    public DrawPanel() {
        super();

        getTimer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (targetSpeed > bicycle.getSpeed()) {
                    bicycle.setSpeed(bicycle.getSpeed() + 1);
                } else if (targetSpeed < bicycle.getSpeed()) {
                    bicycle.setSpeed(Math.max(1, (bicycle.getSpeed() - targetSpeed) * 0.5));
                }
                repaint();
            }
        }, 0, 10);
    }

    @Override
    public void paint(Graphics graphics) {
        BufferedImage bufferedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        bicycle.process(graphics);
        graphics.drawImage(bufferedImage, 0, 0, null);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public Bicycle getBicycle() {
        return bicycle;
    }

    public void setBicycle(Bicycle bicycle) {
        this.bicycle = bicycle;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent) {
        targetSpeed = Math.max(0, targetSpeed - mouseWheelEvent.getWheelRotation());
    }
}
