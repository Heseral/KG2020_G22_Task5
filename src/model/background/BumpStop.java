package model.background;

import util.GlobalVar;

import java.awt.*;

public class BumpStop extends MiscBackgroundObject {
    private final Color BAR_COLOR = new Color(80, 100, 120);
    private final Color STEEL_STRIP_COLOR = new Color(150, 180, 200);
    private int length;

    public BumpStop(double currentPosX, double currentPosY, Background background) {
        super(currentPosX, currentPosY, background);
    }

    public BumpStop(int length, Background background) {
        this(-length, GlobalVar.SKIES_HEIGHT + GlobalVar.GLADE_HEIGHT - 75, background);
        this.length = length;
    }

    @Override
    public void redraw(Graphics graphics) {
        graphics.setColor(BAR_COLOR);
        int drawTo = (int) getCurrentPosX() + length;
        for (int i = (int) getCurrentPosX() + 20; i < drawTo; i += 75) {
            graphics.fillRect(i, (int) getCurrentPosY(), 20, 66);
        }
        graphics.setColor(STEEL_STRIP_COLOR);
        graphics.fillRect((int) getCurrentPosX(), (int) getCurrentPosY(), length, 25);
    }

    @Override
    public boolean isStillRelevant() {
        boolean result = super.isStillRelevant();
        if (!result) {
            getBackground().setAlreadyContentsBumpStop(false);
        }
        return result;
    }
}
