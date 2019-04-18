package packageGui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.ArrayList;


public class MyGui extends JFrame{
    private JButton ok = new JButton("ok");
    private JTable tab1;
    private JTable tab2;
    private JTable tab3;
    private JTable tab4;
    private JTable tab5;
    private JTable tab6;

    public MyGui(){
//        super("ViewModeling");
        JDialog dialog1 = createDialog("Настройка автоматов",true);
        setBounds(900,100,250,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        tab1 = new JTable(5,9);
        tab1.setRowHeight(20);
        tab2 = new JTable(5,9);
        tab2.setRowHeight(20);
        tab3 = new JTable(5,9);
        tab3.setRowHeight(20);
        tab4 = new JTable(5,9);
        tab4.setRowHeight(20);
        tab5 = new JTable(5,9);
        tab5.setRowHeight(20);
        tab6 = new JTable(5,9);
        tab6.setRowHeight(20);

        for (int i =0; i< tab1.getColumnCount(); i++){
            TableColumn column = tab1.getColumnModel().getColumn(i);
            column.setPreferredWidth(40);
            column = tab2.getColumnModel().getColumn(i);
            column.setPreferredWidth(40);
            column = tab3.getColumnModel().getColumn(i);
            column.setPreferredWidth(40);
            column = tab4.getColumnModel().getColumn(i);
            column.setPreferredWidth(40);
            column = tab5.getColumnModel().getColumn(i);
            column.setPreferredWidth(40);
            column = tab6.getColumnModel().getColumn(i);
            column.setPreferredWidth(40);
        }

        tab1.setIntercellSpacing(new Dimension(10, 5));
        tab1.setGridColor(Color.BLACK);
        tab1.setShowVerticalLines(true);
        tab1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);


        tab2.setIntercellSpacing(new Dimension(10, 5));
        tab2.setGridColor(Color.BLACK);
        tab2.setShowVerticalLines(true);
        tab2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        tab3.setIntercellSpacing(new Dimension(10, 5));
        tab3.setGridColor(Color.BLACK);
        tab3.setShowVerticalLines(true);
        tab3.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        tab4.setIntercellSpacing(new Dimension(10, 5));
        tab4.setGridColor(Color.BLACK);
        tab4.setShowVerticalLines(true);
        tab4.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        tab5.setIntercellSpacing(new Dimension(10, 5));
        tab5.setGridColor(Color.BLACK);
        tab5.setShowVerticalLines(true);
        tab5.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        tab6.setIntercellSpacing(new Dimension(10, 5));
        tab6.setGridColor(Color.BLACK);
        tab6.setShowVerticalLines(true);
        tab6.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        Container container1 = getContentPane();
        container1.setLayout(new FlowLayout(FlowLayout.LEFT,200,10));

        Box box1 = Box.createVerticalBox();
        box1.add(new JButton("A80"));
        Border centerBorder = BorderFactory.createEmptyBorder(30,50,30,20);
        box1.add(Box.createVerticalStrut(10));
        box1.setBorder(centerBorder);
        box1.add(tab1);

//        JScrollPane scroll = new JScrollPane(tab1);
//        scroll.setBorder(BorderFactory.createEmptyBorder(50,100,50,100));
//        box1.add(scroll);
//        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        Box box2 = Box.createVerticalBox();
        box2.add(new JButton("A90"));
        box2.add(Box.createVerticalStrut(10));
        box2.add(tab2);
        Box box3 = Box.createVerticalBox();
        box3.add(new JButton("A92"));
        box3.add(Box.createVerticalStrut(10));
        box3.add(tab3);
        Box box4 = Box.createVerticalBox();
        box4.add(new JButton("A95"));
        box4.add(Box.createVerticalStrut(10));
        box4.add(tab4);
        Box box5 = Box.createVerticalBox();
        box5.add(new JButton("A98"));
        box5.add(Box.createVerticalStrut(10));
        box5.add(tab5);

        Box box6 = Box.createVerticalBox();
        box6.add(new JButton("A100"));
        box6.add(Box.createVerticalStrut(10));
        box6.add(tab6);
        container1.add(box1);
        container1.add(box2);
        container1.add(box3);
        container1.add(box4);
        container1.add(box5);
        container1.add(box6);
        container1.setLayout(new FlowLayout(FlowLayout.RIGHT,200,10));
        container1.add(new JButton("Next step"));
        pack();
        dialog1.add(new JScrollPane(container1));
        setSize(300,500);
        dialog1.setResizable(true);
        dialog1.setVisible(true);
    }
    private static void createAndShowGUI() {
        System.out.println("Created GUI on EDT? "+
                SwingUtilities.isEventDispatchThread());
        new MyGui();
    }

    public  void putDataInTable(ArrayList<Integer> arr){
        synchronized (tab1){
        for (int i =0; i< arr.size(); i++){
//            tab1.setValueAt(1,i, arr.get(i));
            tab1.setValueAt(arr.get(i),1,i);
        }
        tab1.getModel();}
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    private JDialog createDialog(String title, boolean modal) {
        JDialog dialog = new JDialog(this, title, modal);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setSize(600, 600);
//        dialog.setSize(200, 130);
        return dialog;
    }
}

