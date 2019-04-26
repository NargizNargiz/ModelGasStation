package kotlinGui

import javax.swing.*
import java.awt.*
import java.util.ArrayList


class ViewModeling : JFrame() {
    private val ok = JButton("ok")
    private val tab1: JTable
    private val tab2: JTable
    private val tab3: JTable
    private val tab4: JTable
    private val tab5: JTable
    private val tab6: JTable

    init {
        //        super("ViewModeling");
        val dialog1 = createDialog("Настройка автоматов", true)
        dialog1.setBounds(300, 100, 1500, 900)
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE


        tab1 = JTable(5, 9)
        tab1.rowHeight = 20
        tab2 = JTable(5, 9)
        tab2.rowHeight = 20
        tab3 = JTable(5, 9)
        tab3.rowHeight = 20
        tab4 = JTable(5, 9)
        tab4.rowHeight = 20
        tab5 = JTable(5, 9)
        tab5.rowHeight = 20
        tab6 = JTable(5, 9)
        tab6.rowHeight = 20

        for (i in 0 until tab1.columnCount) {
            var column = tab1.columnModel.getColumn(i)
            column.preferredWidth = 40
            column = tab2.columnModel.getColumn(i)
            column.preferredWidth = 40
            column = tab3.columnModel.getColumn(i)
            column.preferredWidth = 40
            column = tab4.columnModel.getColumn(i)
            column.preferredWidth = 40
            column = tab5.columnModel.getColumn(i)
            column.preferredWidth = 40
            column = tab6.columnModel.getColumn(i)
            column.preferredWidth = 40
        }

        tab1.intercellSpacing = Dimension(10, 5)
        tab1.gridColor = Color.BLACK
        tab1.showVerticalLines = true
        tab1.autoResizeMode = JTable.AUTO_RESIZE_OFF


        tab2.intercellSpacing = Dimension(10, 5)
        tab2.gridColor = Color.BLACK
        tab2.showVerticalLines = true
        tab2.autoResizeMode = JTable.AUTO_RESIZE_OFF

        tab3.intercellSpacing = Dimension(10, 5)
        tab3.gridColor = Color.BLACK
        tab3.showVerticalLines = true
        tab3.autoResizeMode = JTable.AUTO_RESIZE_OFF

        tab4.intercellSpacing = Dimension(10, 5)
        tab4.gridColor = Color.BLACK
        tab4.showVerticalLines = true
        tab4.autoResizeMode = JTable.AUTO_RESIZE_OFF

        tab5.intercellSpacing = Dimension(10, 5)
        tab5.gridColor = Color.BLACK
        tab5.showVerticalLines = true
        tab5.autoResizeMode = JTable.AUTO_RESIZE_OFF

        tab6.intercellSpacing = Dimension(10, 5)
        tab6.gridColor = Color.BLACK
        tab6.showVerticalLines = true
        tab6.autoResizeMode = JTable.AUTO_RESIZE_OFF

        val container1 = contentPane
        container1.layout = FlowLayout(FlowLayout.LEFT, 200, 100)

        val box1 = Box.createVerticalBox()
        box1.add(JButton("A80"))
        box1.add(Box.createVerticalStrut(10))
        box1.add(tab1)
        //        JScrollPane scroll = new JScrollPane(tab1);
        //        scroll.setBorder(BorderFactory.createEmptyBorder(50,100,50,100));
        //        box1.add(scroll);
        //        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        val box2 = Box.createVerticalBox()
        box2.add(JButton("A90"))
        box2.add(Box.createVerticalStrut(10))
        box2.add(tab2)
        val box3 = Box.createVerticalBox()
        box3.add(JButton("A92"))
        box3.add(Box.createVerticalStrut(10))
        box3.add(tab3)
        val box4 = Box.createVerticalBox()
        box4.add(JButton("A95"))
        box4.add(Box.createVerticalStrut(10))
        box4.add(tab4)
        val box5 = Box.createVerticalBox()
        box5.add(JButton("A98"))
        box5.add(Box.createVerticalStrut(10))
        box5.add(tab5)

        val box6 = Box.createVerticalBox()
        box6.add(JButton("A100"))
        box6.add(Box.createVerticalStrut(10))
        box6.add(tab6)

        val butStep1 = JButton("Шаг 10 минут")
        val butStep2 = JButton("Шаг 30 минут")
        val butStep3 = JButton("Шаг 60 минут")
        val box7 = Box.createVerticalBox()

        box7.add(butStep1)
        box7.add(Box.createVerticalStrut(10))
        box7.add(butStep2)
        box7.add(Box.createVerticalStrut(10))
        box7.add(butStep3)

        val boxH1 = Box.createHorizontalBox()
        boxH1.add(box1)
        boxH1.add(Box.createHorizontalStrut(30))
        boxH1.add(box2)
        boxH1.add(Box.createHorizontalStrut(30))
        boxH1.add(box3)

        val boxH2 = Box.createHorizontalBox()
        boxH2.add(box4)
        boxH2.add(Box.createHorizontalStrut(30))
        boxH2.add(box5)
        boxH2.add(Box.createHorizontalStrut(30))
        boxH2.add(box6)


        val boxVer = Box.createVerticalBox()
        boxVer.add(boxH1)
        boxVer.add(Box.createVerticalStrut(30))
        boxVer.add(boxH2)


        container1.add(boxVer)
//        container1.add(box2)
//        container1.add(box3)
//        container1.add(box4)
//        container1.add(box5)
//        container1.add(box6)
        container1.layout = FlowLayout(FlowLayout.LEFT, 200, 100)
        container1.add(box7)
//        container1.add(butStep1)
//        container1.add(butStep2)
//        container1.add(butStep3)

        container1.layout = FlowLayout(FlowLayout.RIGHT, 200, 100)
        container1.add(JButton("Next step"))

        pack()
        dialog1.add(container1)
        setSize(300, 500)
        dialog1.isResizable = true
        dialog1.isVisible = true
    }

    fun putDataInTable(arr: ArrayList<Int>) {
        synchronized(tab1) {
            for (i in arr.indices) {
                //            tab1.setValueAt(1,i, arr.get(i));
                tab1.setValueAt(arr[i], 1, i)
            }
            tab1.model
        }
    }

    private fun createUIComponents() {
        // TODO: place custom component creation code here
    }

    private fun createDialog(title: String, modal: Boolean): JDialog {
        val dialog = JDialog(this, title, modal)
        dialog.defaultCloseOperation = WindowConstants.DISPOSE_ON_CLOSE
//        dialog.setSize(800, 600)
        //        dialog.setSize(200, 130);
        return dialog
    }

    companion object {
        private fun createAndShowGUI() {
            println("Created GUI on EDT? " + SwingUtilities.isEventDispatchThread())
            ViewModeling()
        }

        @JvmStatic
        fun main(args: Array<String>) {
            SwingUtilities.invokeLater { createAndShowGUI() }
        }
    }
}