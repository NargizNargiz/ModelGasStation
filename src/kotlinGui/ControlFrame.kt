package kotlinGui

import finalVersion.ControllerInterface
import packageGui.JDialogStation
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import javax.swing.*
import javax.swing.border.EmptyBorder

class ControlFrame(_control: ControllerInterface) : JFrame() {
    private var mapMarksCount: Map<String, String>? = null
    private var mapMarksPrices: Map<String, String>? = null
    private var stationField1: JTextField? = null
    private var stationField2: JTextField? = null
    private var stationField3: JTextField? = null
    private var stationField4: JTextField? = null
    private var stationField5: JTextField? = null
    private var stationField6: JTextField? = null

    private var priceField1: JTextField? = null
    private var priceField2: JTextField? = null
    private var priceField3: JTextField? = null
    private var priceField4: JTextField? = null
    private var priceField5: JTextField? = null
    private var priceField6: JTextField? = null

    private val controller = _control

     init{
        val dialog = createDialog("Настройка автоматов с бензином", true)

        val box11 = Box.createVerticalBox()
        val stationLabel1 = JLabel("A80:")
        stationField1 = JTextField(2)
        box11.add(stationLabel1)
        box11.add(Box.createVerticalStrut(6))
        box11.add(stationField1)

        val box12 = Box.createVerticalBox()
        val stationLabel2 = JLabel("A90:")
        stationField2 = JTextField(2)
        box12.add(stationLabel2)
        box12.add(Box.createVerticalStrut(6))
        box12.add(stationField2)

        val box13 = Box.createVerticalBox()
        val stationLabel3 = JLabel("A92:")
        stationField3 = JTextField(2)
        box13.add(stationLabel3)
        box13.add(Box.createVerticalStrut(6))
        box13.add(stationField3)

        val box14 = Box.createVerticalBox()
        val stationLabel4 = JLabel("A95:")
        stationField4 = JTextField(2)
        box14.add(stationLabel4)
        box14.add(Box.createVerticalStrut(6))
        box14.add(stationField4)

        val box15 = Box.createVerticalBox()
        val stationLabel5 = JLabel("A98:")
        stationField5 = JTextField(2)
        box15.add(stationLabel5)
        box15.add(Box.createVerticalStrut(6))
        box15.add(stationField5)

        val box16 = Box.createVerticalBox()
        val stationLabel6 = JLabel("A100:")
        stationField6 = JTextField(2)
        box16.add(stationLabel6)
        box16.add(Box.createVerticalStrut(6))
        box16.add(stationField6)


        val box21 = Box.createVerticalBox()
        val priceLabel1 = JLabel("Цена A80:")
        priceField1 = JTextField(5)
        box21.add(priceLabel1)
        box21.add(Box.createVerticalStrut(6))
        box21.add(priceField1)

        val box22 = Box.createVerticalBox()
        val priceLabel2 = JLabel("Цена A90:")
        priceField2 = JTextField(5)
        box22.add(priceLabel2)
        box22.add(Box.createVerticalStrut(6))
        box22.add(priceField2)

        val box23 = Box.createVerticalBox()
        val priceLabel3 = JLabel("Цена A92:")
        priceField3 = JTextField(5)
        box23.add(priceLabel3)
        box23.add(Box.createVerticalStrut(6))
        box23.add(priceField3)

        val box24 = Box.createVerticalBox()
        val priceLabel4 = JLabel("Цена A95:")
        priceField4 = JTextField(5)
        box24.add(priceLabel4)
        box24.add(Box.createVerticalStrut(6))
        box24.add(priceField4)

        val box25 = Box.createVerticalBox()
        val priceLabel5 = JLabel("Цена A98:")
        priceField5 = JTextField(5)
        box25.add(priceLabel5)
        box25.add(Box.createVerticalStrut(6))
        box25.add(priceField5)

        val box26 = Box.createVerticalBox()
        val priceLabel6 = JLabel("Цена A100:")
        priceField6 = JTextField(5)
        box26.add(priceLabel6)
        box26.add(Box.createVerticalStrut(6))
        box26.add(priceField6)

        val h1Box = Box.createHorizontalBox()
        val h2Box = Box.createHorizontalBox()
        val h3Box = Box.createHorizontalBox()
        val h4Box = Box.createHorizontalBox()
        val h5Box = Box.createHorizontalBox()
        val h6Box = Box.createHorizontalBox()

        h1Box.border = EmptyBorder(10, 10, 10, 10)
        h2Box.border = EmptyBorder(10, 10, 10, 10)
        h3Box.border = EmptyBorder(10, 10, 10, 10)
        h4Box.border = EmptyBorder(10, 10, 10, 10)
        h5Box.border = EmptyBorder(10, 10, 10, 10)
        h6Box.border = EmptyBorder(10, 10, 10, 10)

        h1Box.add(box11)
        h1Box.add(Box.createHorizontalStrut(10))
        h1Box.add(box21)

        h2Box.add(box12)
        h2Box.add(Box.createHorizontalStrut(10))
        h2Box.add(box22)

        h3Box.add(box13)
        h3Box.add(Box.createHorizontalStrut(10))
        h3Box.add(box23)

        h4Box.add(box14)
        h4Box.add(Box.createHorizontalStrut(10))
        h4Box.add(box24)

        h5Box.add(box15)
        h5Box.add(Box.createHorizontalStrut(10))
        h5Box.add(box25)

        h6Box.add(box16)
        h6Box.add(Box.createHorizontalStrut(10))
        h6Box.add(box26)


        val vBox = Box.createVerticalBox()
        vBox.border = EmptyBorder(40, 40, 40, 40)
        vBox.add(h1Box)
        vBox.add(Box.createVerticalStrut(10))
        vBox.add(h2Box)
        vBox.add(Box.createVerticalStrut(10))
        vBox.add(h3Box)
        vBox.add(Box.createVerticalStrut(10))
        vBox.add(h4Box)
        vBox.add(Box.createVerticalStrut(10))
        vBox.add(h5Box)
        vBox.add(Box.createVerticalStrut(10))
        vBox.add(h6Box)
        vBox.add(Box.createVerticalStrut(10))

         val keyL = TestKeyListener()
         stationField1!!.addKeyListener(keyL)
         stationField2!!.addKeyListener(keyL)
         stationField3!!.addKeyListener(keyL)
         stationField4!!.addKeyListener(keyL)
         stationField5!!.addKeyListener(keyL)
         stationField6!!.addKeyListener(keyL)
         priceField1!!.addKeyListener(keyL)
         priceField2!!.addKeyListener(keyL)
         priceField3!!.addKeyListener(keyL)

         priceField4!!.addKeyListener(keyL)
         priceField5!!.addKeyListener(keyL)
         priceField6!!.addKeyListener(keyL)

         val ok = JButton("OK")
         ok.addActionListener {
             if (!setMapMarksCount() || !setMapMarksPrices()){
                JOptionPane.showMessageDialog(this,"Введены неверные данные, попробуйте еще раз","Ошибка ввода",1)
            }
         }
        //        ok.setVisible(true);
        ok.setBounds(dialog.width / 2 - 50, 500, 100, 35)
        dialog.add(ok)
        //        dialog.add(mBox);
        val panel = JPanel()
        panel.add(vBox)
        //        dialog.add(vBox);
        dialog.add(panel)
        dialog.isResizable = true
        dialog.isVisible = true

    }

    fun setMapMarksCount():Boolean {
        val list = listOf(stationField1,stationField2,stationField3,stationField4,stationField5,stationField6)
        if (list.all { it!!.getText().length > 0}) {
            mapMarksCount = mapOf(
                Pair("A80", stationField1!!.text),
                Pair("A90", stationField2!!.text),
                Pair("A92", stationField3!!.text),
                Pair("A95", stationField4!!.text),
                Pair("A98", stationField5!!.text),
                Pair("A100", stationField6!!.text)
            )
            return true
        }
        return false
    }

    fun setMapMarksPrices():Boolean {
        val list = listOf(priceField1,priceField2,priceField3,priceField4,priceField5,priceField6)
        if (list.all { it!!.getText().length > 0}) {
            mapMarksPrices = mapOf(
                Pair("A80", priceField1!!.text),
                Pair("A90", priceField2!!.text),
                Pair("A92", priceField3!!.text),
                Pair("A95", priceField4!!.text),
                Pair("A98", priceField5!!.text),
                Pair("A100", priceField6!!.text)
            )
            return true
        }
        return false
    }

    private fun createDialog(title: String, modal: Boolean): JDialog {
        val dialog = JDialog(this, title, modal)
        dialog.defaultCloseOperation = WindowConstants.DISPOSE_ON_CLOSE
        dialog.setSize(400, 600)
        //        dialog.setSize(200, 130);
        return dialog
    }

    class TestKeyListener : KeyListener {
        override fun keyTyped(e: KeyEvent) {}
        override fun keyPressed(event: KeyEvent) {
            if (event.keyCode == KeyEvent.VK_ENTER) {
                event.component.transferFocus()
            }
        }
        override fun keyReleased(e: KeyEvent) {}
    }
}
