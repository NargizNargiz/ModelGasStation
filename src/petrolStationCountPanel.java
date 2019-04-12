import javax.swing.*;
import java.awt.*;

public class petrolStationCountPanel extends JFrame {
    private JButton    button1;
    private JButton    button2;
    public petrolStationCountPanel() {
        super("ResultPanel frame");
        createPetrolStGUI();
    }
    public void createPetrolStGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        button1 = new JButton("Настроить количество автоматов");
        button1.setActionCommand("Button 1 was pressed!");
        panel.add(button1);
        button2 = new JButton("Установка цен на бензин");
        button2.setActionCommand("Button 2 was pressed!");
        panel.add(button2);
        setContentPane(panel);
        setPreferredSize(new Dimension(320, 100));
        setVisible(true);
    }
}
