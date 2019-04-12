package packageGui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JTextField stationField7;
    private JTextField stationField8;
    private JTextField priceField1;
    private JTextField priceField2;
    private JTextField priceField3;
    private JTextField priceField4;
    private JTextField priceField5;
    private JTextField priceField6;
    private JTextField priceField7;
    private JTextField priceField8;

    void DialogPanel(){
        JDialog dialog = createDialog("Настройка автоматов с бензином", true);

        Box box11 = Box.createHorizontalBox();
        JLabel stationLabel1 = new JLabel("A80:");
        stationField1 = new JTextField(15);
        box11.add(stationLabel1);
        box11.add(Box.createHorizontalStrut(6));
//        box11.add(Box.createRigidArea(new Dimension(0,5)));
        box11.add(stationField1);

        Box box12 = Box.createHorizontalBox();
        JLabel stationLabel2 = new JLabel("A90:");
        stationField2 = new JTextField(15);
        box12.add(stationLabel2);
        box12.add(Box.createHorizontalStrut(6));
        box12.add(stationField2);

        Box box13 = Box.createHorizontalBox();
        JLabel stationLabel3 = new JLabel("A92:");
        stationField3 = new JTextField(15);
        box13.add(stationLabel3);
        box13.add(Box.createHorizontalStrut(6));
        box13.add(stationField3);

        Box box14 = Box.createHorizontalBox();
        JLabel stationLabel4 = new JLabel("A95:");
        stationField4 = new JTextField(15);
        box14.add(stationLabel4);
        box14.add(Box.createHorizontalStrut(6));
        box14.add(stationField4);

        Box box15 = Box.createHorizontalBox();
        JLabel stationLabel5 = new JLabel("A98:");
        stationField5 = new JTextField(15);
        box15.add(stationLabel5);
        box15.add(Box.createHorizontalStrut(6));
        box15.add(stationField5);

        Box box16 = Box.createHorizontalBox();
        JLabel stationLabel6 = new JLabel("A100:");
        stationField6 = new JTextField(15);
        box16.add(stationLabel6);
        box16.add(Box.createHorizontalStrut(6));
        box16.add(stationField6);

        Box box17 = Box.createHorizontalBox();
        JLabel stationLabel7 = new JLabel("A101:");
        stationField7 = new JTextField(15);
        box17.add(stationLabel7);
        box17.add(Box.createHorizontalStrut(6));
        box17.add(stationField7);


        Box box18 = Box.createHorizontalBox();
        JLabel stationLabel8 = new JLabel("A102:");
        stationField8 = new JTextField(15);
        box18.add(stationLabel8);
        box18.add(Box.createHorizontalStrut(6));
        box18.add(stationField8);



        Box box21 = Box.createHorizontalBox();
        JLabel priceLabel1 = new JLabel("Цена A80:");
        priceField1 = new JTextField(18);
        box21.add(priceLabel1);
        box21.add(Box.createHorizontalStrut(6));
        box21.add(priceField1);

        Box box22 = Box.createHorizontalBox();
        JLabel priceLabel2 = new JLabel("Цена A90:");
        priceField2 = new JTextField(18);
        box22.add(priceLabel2);
        box22.add(Box.createHorizontalStrut(6));
        box22.add(priceField2);

        Box box23 = Box.createHorizontalBox();
        JLabel priceLabel3 = new JLabel("Цена A92:");
        priceField3 = new JTextField(18);
        box23.add(priceLabel3);
        box23.add(Box.createHorizontalStrut(6));
        box23.add(priceField3);

        Box box24 = Box.createHorizontalBox();
        JLabel priceLabel4 = new JLabel("Цена A95:");
        priceField4 = new JTextField(18);
        box24.add(priceLabel4);
        box24.add(Box.createHorizontalStrut(6));
        box24.add(priceField4);

        Box box25 = Box.createHorizontalBox();
        JLabel priceLabel5 = new JLabel("Цена A98:");
        priceField5 = new JTextField(18);
        box25.add(priceLabel5);
        box25.add(Box.createHorizontalStrut(6));
        box25.add(priceField5);

        Box box26 = Box.createHorizontalBox();
        JLabel priceLabel6 = new JLabel("Цена A100:");
        priceField6 = new JTextField(18);
        box26.add(priceLabel6);
        box26.add(Box.createHorizontalStrut(6));
        box26.add(priceField6);

        Box box27 = Box.createHorizontalBox();
        JLabel priceLabel7 = new JLabel("Цена A101:");
        priceField7 = new JTextField(18);
        box27.add(priceLabel7);
        box27.add(Box.createHorizontalStrut(6));
        box27.add(priceField7);
//
        Box box28 = Box.createHorizontalBox();
        JLabel priceLabel8 = new JLabel("Цена A102:");
        priceField8 = new JTextField(18);
        box28.add(priceLabel8);
        box28.add(Box.createHorizontalStrut(6));
        box28.add(priceField8);

        Box mBox  = Box.createVerticalBox();

        mBox.setBorder(new EmptyBorder(40,40,60,60));
        mBox.add(box11);
        mBox.add(Box.createVerticalStrut(12));
        mBox.add(box21);

        mBox.add(Box.createVerticalStrut(17));
        mBox.add(box12);
        mBox.add(Box.createVerticalStrut(17));
        mBox.add(box22);

        mBox.add(Box.createVerticalStrut(22));
        mBox.add(box13);
        mBox.add(Box.createVerticalStrut(22));
        mBox.add(box23);

        mBox.add(Box.createVerticalStrut(27));
        mBox.add(box14);
        mBox.add(Box.createVerticalStrut(27));
        mBox.add(box24);

        mBox.add(Box.createVerticalStrut(32));
        mBox.add(box15);
        mBox.add(Box.createVerticalStrut(32));
        mBox.add(box25);

        mBox.add(Box.createVerticalStrut(37));
        mBox.add(box16);
        mBox.add(Box.createVerticalStrut(37));
        mBox.add(box26);

        mBox.add(Box.createVerticalStrut(42));
        mBox.add(box17);
        mBox.add(Box.createVerticalStrut(42));
        mBox.add(box27);

        mBox.add(Box.createVerticalStrut(47));
        mBox.add(box18);
        mBox.add(Box.createVerticalStrut(47));
        mBox.add(box28);

        JDialogTest.TestKeyListener keyL = new JDialogTest.TestKeyListener();
        stationField1.addKeyListener(keyL);
        stationField2.addKeyListener(keyL);
        stationField3.addKeyListener(keyL);
        stationField4.addKeyListener(keyL);
        stationField5.addKeyListener(keyL);
        stationField6.addKeyListener(keyL);
        stationField7.addKeyListener(keyL);
        stationField8.addKeyListener(keyL);

        priceField1.addKeyListener(keyL);
        priceField2.addKeyListener(keyL);
        priceField3.addKeyListener(keyL);
        priceField4.addKeyListener(keyL);
        priceField5.addKeyListener(keyL);
        priceField6.addKeyListener(keyL);
        priceField7.addKeyListener(keyL);
        priceField8.addKeyListener(keyL);

        JButton ok = new JButton("OK");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setMapMarksCount();
                setMapMarksPrices();
            }
        });
        ok.setVisible(true);
        ok.setBounds(dialog.getWidth()/2 - 50,920,100,35);
        dialog.add(ok);
        dialog.add(mBox);
        dialog.setResizable(false);
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
        mapMarksCount.put("A101",stationField7.getText());
        mapMarksCount.put("A102",stationField8.getText());
        System.out.println(mapMarksCount);
    }
    public void setMapMarksPrices(){
        mapMarksPrices = new HashMap<>();
        mapMarksPrices.put("A80",priceField1.getText());
        mapMarksPrices.put("A90",priceField2.getText());
        mapMarksPrices.put("A92",priceField3.getText());
        mapMarksPrices.put("A95",priceField4.getText());
        mapMarksPrices.put("A98",priceField5.getText());
        mapMarksPrices.put("A100",priceField6.getText());
        mapMarksPrices.put("A101",priceField7.getText());
        mapMarksPrices.put("A102",priceField8.getText());
        System.out.println(mapMarksPrices);
    }
    private JDialog createDialog(String title, boolean modal) {
        JDialog dialog = new JDialog(this, title, modal);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setSize(350, 1000);
//        dialog.setSize(200, 130);
        return dialog;
    }
}
