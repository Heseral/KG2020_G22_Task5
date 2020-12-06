package model.background;

import java.awt.*;

public class Tree extends MiscBackgroundObject {
    private final Color WOOD_COLOR = new Color(60, 20, 20);
    private final double LEAF_DIAMETER;
    private final double LEAF_DIAMETER_80_PERCENT;
    private final double WOOD_WIDTH;

    public Tree(double currentPosX, double currentPosY, Background background) {
        super(currentPosX, currentPosY, background);
        LEAF_DIAMETER = 50 * getCurrentPosY() * 0.01;
        WOOD_WIDTH = LEAF_DIAMETER * 0.25;
        LEAF_DIAMETER_80_PERCENT = LEAF_DIAMETER * 0.8;
    }

    @Override
    public void redraw(Graphics graphics) {
        graphics.setColor(WOOD_COLOR);
        graphics.fillRect((int) (getCurrentPosX() + (LEAF_DIAMETER - WOOD_WIDTH) * 0.5), (int) getCurrentPosY(), (int) WOOD_WIDTH, (int) LEAF_DIAMETER_80_PERCENT);
        graphics.setColor(Color.GREEN);
        graphics.fillOval((int) getCurrentPosX(), (int) getCurrentPosY() - (int) LEAF_DIAMETER_80_PERCENT, (int) LEAF_DIAMETER, (int) LEAF_DIAMETER);
    }
}
