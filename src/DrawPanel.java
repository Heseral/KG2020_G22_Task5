import model.bicycle.Bicycle;
import util.GlobalVar;

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
        addMouseWheelListener(this);

        getTimer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (targetSpeed > bicycle.getSpeed()) {
                    bicycle.setSpeed(bicycle.getSpeed() + 0.025);
                } else if (targetSpeed < bicycle.getSpeed()) {
                    bicycle.setSpeed(Math.max(0, bicycle.getSpeed() - 0.2));
                }
                repaint();
            }
        }, 0, 10);
    }

    @Override
    public void paint(Graphics graphics) {
        BufferedImage bufferedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        bufferedImage.getGraphics().setColor(Color.WHITE);
        bufferedImage.getGraphics().fillRect(0,0, GlobalVar.WINDOW_WIDTH, GlobalVar.WINDOW_HEIGHT);
        bufferedImage.getGraphics().setColor(Color.BLACK);
        bicycle.onInit(bufferedImage.getGraphics());
        bicycle.process(bufferedImage.getGraphics());
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
