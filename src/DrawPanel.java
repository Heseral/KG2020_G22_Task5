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

public class DrawPanel extends JPanel implements KeyListener {
    private Timer timer = new Timer();
    private Bicycle bicycle = new Bicycle();
    private double targetSpeed = bicycle.getSpeed();
    private Integer pressedKeyCode = null;

    public DrawPanel() {
        super();
        setFocusable(true);
        requestFocus();
        addKeyListener(this);

        getTimer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (targetSpeed > bicycle.getSpeed()) {
                    bicycle.setSpeed(targetSpeed);
                } else if (targetSpeed < bicycle.getSpeed()) {
                    bicycle.setSpeed(Math.max(0, bicycle.getSpeed() - 0.2));
                }
                repaint();

                if (pressedKeyCode == null) {
                    targetSpeed = Math.max(0, targetSpeed - 0.025);
                    return;
                }

                double rightPedalState = bicycle.getPedalAndHuman().getState();
                if (rightPedalState >= GlobalVar.RIGHT_ON_TOP && rightPedalState <= GlobalVar.RIGHT_ON_BOTTOM) {
                    targetSpeed = Math.max(
                            0, pressedKeyCode == KeyEvent.VK_RIGHT
                                    ? (targetSpeed - 0.125 * Math.cos(rightPedalState * 2 * Math.PI))
                                    : (targetSpeed + (Math.cos(rightPedalState * 2 * Math.PI)))
                    );
                } else {
                    targetSpeed = Math.max(
                            0, pressedKeyCode == KeyEvent.VK_LEFT
                                    ? (targetSpeed + 0.125 * Math.cos(rightPedalState * 2 * Math.PI))
                                    : (targetSpeed - Math.cos(rightPedalState * 2 * Math.PI))
                    );
                }
            }
        }, 0, 10);
    }

    @Override
    public void paint(Graphics graphics) {
        BufferedImage bufferedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        bufferedImage.getGraphics().setColor(Color.WHITE);
        bufferedImage.getGraphics().fillRect(0, 0, GlobalVar.WINDOW_WIDTH, GlobalVar.WINDOW_HEIGHT);
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
        pressedKeyCode = e.getKeyCode();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressedKeyCode = null;
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
}
