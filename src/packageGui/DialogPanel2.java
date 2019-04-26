package packageGui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;


public class DialogPanel2 extends JFrame {
    private HashMap<String, String> mapMarksCount;
    private HashMap<String, String> mapMarksPrices;
    private JTextField stationField1;
    private JTextField stationField2;
    private JTextField stationField3;
    private JTextField stationField4;
    private JTextField stationField5;
    private JTextField stationField6;

    private JTextField priceField1;
    private JTextField priceField2;
    private JTextField priceField3;
    private JTextField priceField4;
    private JTextField priceField5;
    private JTextField priceField6;
;

    void DialogPanel(){
        JDialog dialog = createDialog("Настройка автоматов с бензином", true);

        Box box11 = Box.createVerticalBox();
        JLabel stationLabel1 = new JLabel("A80:");
        stationField1 = new JTextField(2);
        box11.add(stationLabel1);
        box11.add(Box.createVerticalStrut(6));
        box11.add(stationField1);

        Box box12 = Box.createVerticalBox();
        JLabel stationLabel2 = new JLabel("A90:");
        stationField2 = new JTextField(2);
        box12.add(stationLabel2);
        box12.add(Box.createVerticalStrut(6));
        box12.add(stationField2);

        Box box13 = Box.createVerticalBox();
        JLabel stationLabel3 = new JLabel("A92:");
        stationField3 = new JTextField(2);
        box13.add(stationLabel3);
        box13.add(Box.createVerticalStrut(6));
        box13.add(stationField3);

        Box box14 = Box.createVerticalBox();
        JLabel stationLabel4 = new JLabel("A95:");
        stationField4 = new JTextField(2);
        box14.add(stationLabel4);
        box14.add(Box.createVerticalStrut(6));
        box14.add(stationField4);

        Box box15 = Box.createVerticalBox();
        JLabel stationLabel5 = new JLabel("A98:");
        stationField5 = new JTextField(2);
        box15.add(stationLabel5);
        box15.add(Box.createVerticalStrut(6));
        box15.add(stationField5);

        Box box16 = Box.createVerticalBox();
        JLabel stationLabel6 = new JLabel("A100:");
        stationField6 = new JTextField(2);
        box16.add(stationLabel6);
        box16.add(Box.createVerticalStrut(6));
        box16.add(stationField6);



        Box box21 = Box.createVerticalBox();
        JLabel priceLabel1 = new JLabel("Цена A80:");
        priceField1 = new JTextField(5);
        box21.add(priceLabel1);
        box21.add(Box.createVerticalStrut(6));
        box21.add(priceField1);

        Box box22 = Box.createVerticalBox();
        JLabel priceLabel2 = new JLabel("Цена A90:");
        priceField2 = new JTextField(5);
        box22.add(priceLabel2);
        box22.add(Box.createVerticalStrut(6));
        box22.add(priceField2);

        Box box23 = Box.createVerticalBox();
        JLabel priceLabel3 = new JLabel("Цена A92:");
        priceField3 = new JTextField(5);
        box23.add(priceLabel3);
        box23.add(Box.createVerticalStrut(6));
        box23.add(priceField3);

        Box box24 = Box.createVerticalBox();
        JLabel priceLabel4 = new JLabel("Цена A95:");
        priceField4 = new JTextField(5);
        box24.add(priceLabel4);
        box24.add(Box.createVerticalStrut(6));
        box24.add(priceField4);

        Box box25 = Box.createVerticalBox();
        JLabel priceLabel5 = new JLabel("Цена A98:");
        priceField5 = new JTextField(5);
        box25.add(priceLabel5);
        box25.add(Box.createVerticalStrut(6));
        box25.add(priceField5);

        Box box26 = Box.createVerticalBox();
        JLabel priceLabel6 = new JLabel("Цена A100:");
        priceField6 = new JTextField(5);
        box26.add(priceLabel6);
        box26.add(Box.createVerticalStrut(6));
        box26.add(priceField6);

        Box h1Box  = Box.createHorizontalBox();
        Box h2Box  = Box.createHorizontalBox();
        Box h3Box  = Box.createHorizontalBox();
        Box h4Box  = Box.createHorizontalBox();
        Box h5Box  = Box.createHorizontalBox();
        Box h6Box  = Box.createHorizontalBox();

        h1Box.setBorder(new EmptyBorder(10,10,10,10));
        h2Box.setBorder(new EmptyBorder(10,10,10,10));
        h3Box.setBorder(new EmptyBorder(10,10,10,10));
        h4Box.setBorder(new EmptyBorder(10,10,10,10));
        h5Box.setBorder(new EmptyBorder(10,10,10,10));
        h6Box.setBorder(new EmptyBorder(10,10,10,10));

        h1Box.add(box11);
        h1Box.add(Box.createHorizontalStrut(10));
        h1Box.add(box21);

        h2Box.add(box12);
        h2Box.add(Box.createHorizontalStrut(10));
        h2Box.add(box22);

        h3Box.add(box13);
        h3Box.add(Box.createHorizontalStrut(10));
        h3Box.add(box23);

        h4Box.add(box14);
        h4Box.add(Box.createHorizontalStrut(10));
        h4Box.add(box24);

        h5Box.add(box15);
        h5Box.add(Box.createHorizontalStrut(10));
        h5Box.add(box25);

        h6Box.add(box16);
        h6Box.add(Box.createHorizontalStrut(10));
        h6Box.add(box26);


        Box vBox = Box.createVerticalBox();
        vBox.setBorder(new EmptyBorder(40,40,40,40));
        vBox.add(h1Box);
        vBox.add(Box.createVerticalStrut(10));
        vBox.add(h2Box);
        vBox.add(Box.createVerticalStrut(10));
        vBox.add(h3Box);
        vBox.add(Box.createVerticalStrut(10));
        vBox.add(h4Box);
        vBox.add(Box.createVerticalStrut(10));
        vBox.add(h5Box);
        vBox.add(Box.createVerticalStrut(10));
        vBox.add(h6Box);
        vBox.add(Box.createVerticalStrut(10));

        TestKeyListener keyL = new TestKeyListener();
        stationField1.addKeyListener(keyL);
        stationField2.addKeyListener(keyL);
        stationField3.addKeyListener(keyL);
        stationField4.addKeyListener(keyL);
        stationField5.addKeyListener(keyL);
        stationField6.addKeyListener(keyL);

        priceField1.addKeyListener(keyL);
        priceField2.addKeyListener(keyL);
        priceField3.addKeyListener(keyL);
        priceField4.addKeyListener(keyL);
        priceField5.addKeyListener(keyL);
        priceField6.addKeyListener(keyL);

        JButton ok = new JButton("OK");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setMapMarksCount();
                setMapMarksPrices();
            }
        });
//        ok.setVisible(true);
        ok.setBounds(dialog.getWidth()/2 - 50,500,100,35);
        dialog.add(ok);
//        dialog.add(mBox);
        JPanel panel = new JPanel();
        panel.add(vBox);
//        dialog.add(vBox);
        dialog.add(panel);
        dialog.setResizable(true);
        dialog.setVisible(true);

    }

    public void setMapMarksCount(){
        mapMarksCount = new HashMap<>();
        mapMarksCount.put("A80",stationField1.getText());
        mapMarksCount.put("A90",stationField2.getText());
        mapMarksCount.put("A92",stationField3.getText());
        mapMarksCount.put("A95",stationField4.getText());
        mapMarksCount.put("A98",stationField5.getText());
        mapMarksCount.put("A100",stationField6.getText());
//        saveData("counts",mapMarksCount);
//       System.out.println(mapMarksCount);

    }
    public void setMapMarksPrices(){
        mapMarksPrices = new HashMap<>();
        mapMarksPrices.put("A80",priceField1.getText());
        mapMarksPrices.put("A90",priceField2.getText());
        mapMarksPrices.put("A92",priceField3.getText());
        mapMarksPrices.put("A95",priceField4.getText());
        mapMarksPrices.put("A98",priceField5.getText());
        mapMarksPrices.put("A100",priceField6.getText());
//        saveData("price",mapMarksPrices);
//        System.out.println(mapMarksPrices);
    }
    private JDialog createDialog(String title, boolean modal) {
        JDialog dialog = new JDialog(this, title, modal);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setSize(400, 600);
//        dialog.setSize(200, 130);
        return dialog;
    }
    public static class TestKeyListener implements KeyListener {
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
}
