/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils2d;

/**
 *
 * Описывает координаты экранной точки (пикселя)
 * @author Alexey
 */
public class ScreenPoint {
    /**
     * x - номер пикселя по горизонтальной оси
     * y - номер пикселя по вертикальной оси
     */
    private int x;
    private int y;

    /**
     * Создаёт экранную точку.
     * @param x Номер пикселя по горизонтальной оси (X)
     * @param y Номер пикселя по вертикальной оси (Y)
     */
    public ScreenPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
}
