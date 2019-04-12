
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class exampleGui extends JFrame
{
    private static final long serialVersionUID = 1L;

    private JTextField textField;
    private JButton    button1;
    private JButton    button2;
    private JButton    button3;
    JTextField nameStationField;
    JTextField markUpField;
    // у автомата
    JTextField maxLenQueueField;
    JTextField countPetrolStField;
    JTextField timeRangeField;
    JTextField markRangeField;
    JTextField volumeRangeField;
    String name;

    public exampleGui() {
        super("ResultPanel frame");
        createGUI();
    }
    public String getName(){
        return name;
    }
    public void createGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        Box box1 = Box.createHorizontalBox();
        JLabel nameStLabel = new JLabel("Название cтанции:");
        nameStationField = new JTextField(15);
        box1.add(nameStLabel);
        box1.add(Box.createHorizontalStrut(6));
        box1.add(nameStationField);

        Box box2 = Box.createHorizontalBox();
        JLabel markUpFieldLabel = new JLabel("Наценка:");
        markUpField = new JTextField(15);
        box2.add(markUpFieldLabel);
        box2.add(Box.createHorizontalStrut(6));
        box2.add(markUpField);

        Box box3 = Box.createHorizontalBox();
        JLabel maxLenQLabel = new JLabel("Максимальная длина очереди у автомата:");
        maxLenQueueField = new JTextField(15);
        box3.add(maxLenQLabel);
        box3.add(Box.createHorizontalStrut(6));
        box3.add(maxLenQueueField);

        Box box4 = Box.createHorizontalBox();
        JLabel countPetrolLabel = new JLabel("Количество автоматов на станции:");
        countPetrolStField = new JTextField(17);
        box4.add(countPetrolLabel);
        box4.add(Box.createHorizontalStrut(6));
        box4.add(countPetrolStField);

        Box box5 = Box.createHorizontalBox();
        JLabel timeRangeLabel = new JLabel("Диапазон изменения отрезков времени между запросами");
        timeRangeField = new JTextField(15);
        box5.add(timeRangeLabel);
        box5.add(Box.createHorizontalStrut(6));
        box5.add(timeRangeField);

        Box box6 = Box.createHorizontalBox();
        JLabel markRangeLabel = new JLabel("Диапазон изменения марки");
        markRangeField = new JTextField(15);
        box6.add(markRangeLabel);
        box6.add(Box.createHorizontalStrut(6));
        box6.add(markRangeField);

        Box box7 = Box.createHorizontalBox();
        JLabel volumeRangeLabel = new JLabel("Диапазон изменения объема");
        volumeRangeField = new JTextField(15);
        box7.add(volumeRangeLabel);
        box7.add(Box.createHorizontalStrut(6));
        box7.add(volumeRangeField);

        Box box8 = Box.createHorizontalBox();
        JButton ok = new JButton("OK");

        JButton cancel = new JButton("Отмена");
        box8.add(Box.createHorizontalGlue());
        box8.add(ok);
        box8.add(Box.createHorizontalStrut(12));
        box8.add(cancel);

        Box mainBox = Box.createVerticalBox();

        mainBox.setBorder(new EmptyBorder(40,40,60,60));
        mainBox.add(box1);

        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box2);

        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(box3);

        mainBox.add(Box.createVerticalStrut(22));
        mainBox.add(box4);

        mainBox.add(Box.createVerticalStrut(27));
        mainBox.add(box5);

        mainBox.add(Box.createVerticalStrut(32));
        mainBox.add(box6);

        mainBox.add(Box.createVerticalStrut(37));
        mainBox.add(box7);

        mainBox.add(Box.createVerticalStrut(42));
        mainBox.add(box8);


        setContentPane(mainBox);

        button1 = new JButton("Настроить количество автоматов");
        button1.setActionCommand("Button 1 was pressed!");
        panel.add(button1);

        button2 = new JButton("Установка цен на бензин");
        button2.setActionCommand("Button 2 was pressed!");
        panel.add(button2);

        button3 = new JButton("Button 3");
        button3.setActionCommand("Button 3 was pressed!");
        panel.add(button3);

        textField = new JTextField();
        textField.setColumns(23);
        panel.add(textField);

        ActionListener actionListener = new TestActionListener();
        KeyListener keyListener = new TestKeyListener();
        ActionListener clickButtonPetrol = new Test1ActionListener();

        button1.addActionListener(actionListener);
        button1.addActionListener(clickButtonPetrol);
        button2.addActionListener(actionListener);
        button3.addActionListener(actionListener);
        ok.addActionListener(actionListener);
        nameStationField.addActionListener(actionListener);
        nameStationField.addKeyListener(keyListener);
        nameStationField.addKeyListener(keyListener);
        markUpField.addKeyListener(keyListener);
        // у автомата
        maxLenQueueField.addKeyListener(keyListener);
        countPetrolStField.addKeyListener(keyListener);
        timeRangeField.addKeyListener(keyListener);
        markRangeField.addKeyListener(keyListener);
        volumeRangeField.addActionListener(actionListener);

//        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
//        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        getContentPane().add(panel);

        setPreferredSize(new Dimension(320, 100));
    }

    public class TestActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            name = e.getActionCommand();
//          org.ProgramMainKt.programRun(name);
//          System.out.println(name);
            textField.setText(e.getActionCommand());

        }
    }
    public class Test1ActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            petrolStationCountPanel petrolPanel = new petrolStationCountPanel();
            JFrame.setDefaultLookAndFeelDecorated(true);
            petrolPanel.pack();
            petrolPanel.setLocationRelativeTo(null);
            petrolPanel.setVisible(true);
            setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            setVisible(false);
//            JOptionPane.setRootFrame(petrolPanel);
            //showMessageDialog(button1, "Не надо было нажимать на эту кнопку", "Информация", JOptionPane.WARNING_MESSAGE);
        }
    }

    public class TestKeyListener implements KeyListener{
        public void keyTyped(KeyEvent k){}
        public void keyPressed(KeyEvent event){
            if(event.getKeyCode() == KeyEvent.VK_ENTER){
                event.getComponent().transferFocus();
            };
        }
        public void keyReleased(KeyEvent event){
//            println("key free");
        }
    }

    public static void main(String[] args){
         javax.swing.SwingUtilities.invokeLater(new Runnable() {
             exampleGui frame = new exampleGui();
             public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

             }
        });
    }
}