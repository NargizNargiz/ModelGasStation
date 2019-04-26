package packageGui;

import javax.swing.*;
import java.awt.*;

public class Graph extends JFrame {
    Graph() {
        setPreferredSize(new Dimension(500, 100));
    }
    public void paint(java.awt.Graphics g)
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

    public void createGui()
    {
        final JFrame frame = new JFrame();
        JPanel panel = new JPanel();
//        Graph g = new Graphics();
//        panel.add(g);
//        frame.paint(g);
//        frame.add(panel);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        super("ResultPanel");
//        setDefaultLookAndFeelDecorated(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        JPanel pan = new JPanel();
//        pan.add();
//        setSize(800, 600);
//        setVisible(true);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                Graph GUI = new Graph();
                GUI.createGui();
            }
        });
    }

}
