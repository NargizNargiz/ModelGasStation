package packageGui;
import jdk.nashorn.internal.codegen.MapCreator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class JDialogTest extends JFrame
{
    private JTextField nameStationField;
    private JTextField markUpField;
    private JTextField maxLenQueueField;
    private JTextField countPetrolStField;
    HashMap<String, String> mapDataFromFields;
    private static final long serialVersionUID = 1L;

    public JDialogTest() {
        super("DialogWindows");
        // Выход из программы при закрытии
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Кнопки для создания диалоговых окон
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
        countPetrolStField = new JTextField(15);
        box4.add(countPetrolLabel);
        box4.add(Box.createHorizontalStrut(6));
        box4.add(countPetrolStField);

        JButton ok = new JButton("OK");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setValuesMap();
            }
        });

        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(20,20,20,20));
        mainBox.add(box1);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box2);
        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(box3);
        mainBox.add(Box.createVerticalStrut(22));
        mainBox.add(box4);

        TestKeyListener testKeyL = new TestKeyListener();
        nameStationField.addKeyListener(testKeyL);
        markUpField.addKeyListener(testKeyL);
        maxLenQueueField.addKeyListener(testKeyL);
        countPetrolStField.addKeyListener(testKeyL);

        JButton button2 = new JButton("Настройка параметров автоматов");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DialogPanel2 dialog2 = new DialogPanel2();
//                DialogPanel(dialog1);
                dialog2.DialogPanel();
            }
        });

        // Создание панели содержимого с размещением кнопок
        JPanel contents = new JPanel();
        contents.add(mainBox);
        contents.add(ok);

        contents.add(button2);
        setContentPane(contents);

        // Определение размера и открытие окна
        setSize(500, 300);
        setVisible(true);
    }

    public static class TestKeyListener implements KeyListener{
        @Override
        public void keyTyped(KeyEvent e) {
        }
        public void keyPressed(KeyEvent event){
            if(event.getKeyCode() == KeyEvent.VK_ENTER){
                event.getComponent().transferFocus();
            }
        }
        @Override
        public void keyReleased(KeyEvent e) {
        }
    }

    public void setValuesMap(){
        mapDataFromFields = new HashMap<>();
        mapDataFromFields.put("StationName",nameStationField.getText());
        mapDataFromFields.put("MarkUp",markUpField.getText());
        mapDataFromFields.put("MaxLenQueue",maxLenQueueField.getText());
        mapDataFromFields.put("CountAutomate",countPetrolStField.getText());
        System.out.println(mapDataFromFields);
    }


    /** Функция создания диалогового окна.
     * @param title - заголовок окна
     * @param modal - флаг модальности
     */
    public JDialog createDialog(String title, boolean modal)
    {
        JDialog dialog = new JDialog(this, title, modal);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        dialog.setSize(200, 130);
        return dialog;
    }

    public static void main(String[] args)
    {
        new JDialogTest();
    }
}
