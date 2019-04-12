package packageGui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static jdk.nashorn.internal.objects.Global.println;

class LoginWindow extends JFrame {

    /* Для того, чтобы впоследствии обращаться к содержимому текстовых полей, рекомендуется сделать их членами класса окна */
    JTextField nameStationField;
    JTextField markUpField;
    // у автомата
    JTextField maxLenQueueField;
    JTextField countPetrolStField;
    JTextField timeRangeField;
    JTextField markRangeField;
    JTextField volumeRangeField;

    LoginWindow(){
        super("Вход в систему");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(150,200,100,40);

        Box box1 = Box.createHorizontalBox();
        JLabel nameStLabel = new JLabel("Название cтанции:");
        nameStationField = new JTextField(15);
        box1.add(nameStLabel);
        box1.add(Box.createHorizontalStrut(6));
        box1.add(nameStationField);

        box1.addKeyListener(new KeyL());

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
        countPetrolStField = new JTextField(15);
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


// Настраиваем третью горизонтальную панель (с кнопками)
        Box box8 = Box.createHorizontalBox();
        JButton ok = new JButton("OK");
        ok.addMouseListener(new MouseL());

        JButton cancel = new JButton("Отмена");
        box8.add(Box.createHorizontalGlue());
        box8.add(ok);
        box8.add(Box.createHorizontalStrut(12));
        box8.add(cancel);
// Уточняем размеры компонентов
//        nameStLabel.setPreferredSize(markUpFieldLabel.getPreferredSize());

        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(20,20,20,20));
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
        pack();
        setResizable(false);


//       настраиваем выпадающий ползуннок

    }
}
class KeyL implements KeyListener{
    public void keyTyped(KeyEvent event){
        if (event.getKeyChar() != KeyEvent.CHAR_UNDEFINED){
            println(event.getKeyChar());
        }
    }
    public void keyPressed(KeyEvent event){
        println("mouse pressed");
    }
    public void keyReleased(KeyEvent event){
        println("key free");
    }
}
class MouseL implements MouseListener{
    public void mouseClicked(MouseEvent event) {
        println("here");
        }
    public void mouseEntered(MouseEvent event) {}

    public void mouseExited(MouseEvent event) {}

    public void mousePressed(MouseEvent event) {}

    public void mouseReleased(MouseEvent event) {}

        }


public class gui {
    public JPanel pan;

    public gui(){
        pan.setBackground(Color.darkGray);
    }
    public static void main(String[] args) {
//        JFrame f = new JFrame("hello");
//        JButton b = new JButton("click me");
//        b.setBounds(150,200,100,40);
//        b.setBackground(Color.LIGHT_GRAY);
//        b.setVisible(true);
//
//        f.setContentPane(new packageGui.gui().pan);
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.setSize(400, 400);
//        f.setLocationRelativeTo(null);
//        f.setVisible(true);
//        f.add(b);

        JFrame myWindow = new LoginWindow();
        myWindow.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

