package frame;

import javax.swing.*;
import java.awt.*;

public class Hangman extends JPanel {

    private int state;
    public Hangman(){
        state = 0;
    }

    public void step() {
        state++;
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (state > 0) g.drawLine(200, 199, 300, 199);
        if (state > 1) g.drawLine(200, 199, 200, 0);
        if (state > 2) g.drawLine(200, 0, 280, 0);
        if (state > 3) g.drawLine(200, 40, 240, 0);
        if (state > 4) g.drawLine(280, 0, 280, 40);//kötél
        if (state > 5) g.drawOval(260,40,40,40);
        if (state > 6) g.drawLine(280, 80, 280, 120);//törzs
        if (state > 7) g.drawLine(280, 95, 260, 80);//balkéz
        if (state > 8) g.drawLine(280, 95, 300, 80); //jobbkéz
        if (state > 9) g.drawLine(280, 120, 260, 160); //balláb
        if (state > 10) g.drawLine(280, 120, 300, 160); //jobbláb
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 200);
    }
}