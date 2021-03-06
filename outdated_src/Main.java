/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Alexey
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        DrawPanel panel = new DrawPanel();
        frame.add(panel);
        frame.setVisible(true);
    }
}

/*
Написать программу-мультфильм «Едущий велосипед по асфальтной дороге». Пользователь смотрит сбоку.
Пользователь должен уметь управлять частотой педалирования, а также силой торможения.
a. (25) Требуется создать эффект движения велосипеда по дороге.
Для этого потребуется не только вращать колёса (будет видно по спицам), но и педали, а также ноги велосипедиста.
Кроме того, чтобы создавался эффект движения, потребуется "сдвигать" дорогу и фон в сторону противоположенную
направлению движения. На дороге нанесена пунктирная разметка (см. ПДД горизонтальная дорожная разметка 1.5).
Конечно же, вращение колёс должно совпадать со скоростью движения (чтобы не было пробуксовок и скольжения).
b. (+10) Можно добавить другие опорные объекты: деревья, столбики, периодически появляющиеся отбойники,
меняющаяся разметка и перекрёстки (вид всё тот же - сбоку от основной дороги), километровые столбы и др.
c. (+5) Можно сделать велосипед скоростным, а также добавить эффекты неровной дороги и более реалистично
смоделировать резкое торможение.
d. (+10) Можно добавить управление частотой педалирования не с помощью ползунка или зажатой кнопки,
а при помощи поочерёдного нажатия на две соседние клавиши. При этом будет создан эффект нажатия на каждую из педалей.
Стоит предусмотреть обратный эффект, когда клавиши нажимают не в то время (педаль ещё не поднялась вверх, а её уже нажимают).
 */
