package packageGui;

import javax.swing.*;
import java.awt.*;

public class ResultPanel extends JFrame {
    public void paint(Graphics g)
    {
        super.paint(g);
        Font font = new Font("URW Chancery L", Font.BOLD, 14);
        g.setFont(font);

        g.drawOval(40,50,30,30);
        g.setColor(Color.darkGray);
        g.fillOval(40, 50, 30, 30);
        g.drawString("A80", 80, 70);

        g.drawOval(40,80,30,30);
        g.setColor(Color.BLACK);
        g.fillOval(40, 80, 30, 30);
        g.drawString("A92", 80, 100);

        g.drawOval(40,110,30,30);
        g.setColor(Color.RED);
        g.fillOval(40, 110, 30, 30);
        g.drawString("A95", 80, 130);

        g.drawOval(40,140,30,30);
        g.setColor(Color.BLUE);
        g.fillOval(40, 140, 30, 30);
        g.drawString("A98", 80, 160);

        g.drawOval(40,170,30,30);
        g.setColor(Color.CYAN);
        g.fillOval(40, 170, 30, 30);
        g.drawString("A100", 80, 190);

        g.drawOval(40,200,30,30);
        g.setColor(Color.GREEN);
        g.fillOval(40, 200, 30, 30);
        g.drawString("A101", 80, 220);
    }

    public ResultPanel()
    {
        super("ResultPanel");
        JFrame.setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(800, 600);
        setVisible(true);
    }
    public static void main(String[] args) {
        new ResultPanel();
    }

}
