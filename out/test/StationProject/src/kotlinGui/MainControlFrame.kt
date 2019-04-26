package kotlinGui


import finalVersion.ControllerInterface
import javax.swing.*
import javax.swing.border.EmptyBorder
import java.awt.event.*
import java.util.ArrayList


class MainControlFrame(_control: ControllerInterface) : JFrame("Модель: бензозаправочная станция") {
    private val nameStationField: JTextField
    private val markUpField: JTextField
    private val maxLenQueueField: JTextField
    private val countPetrolStField: JTextField
    private var mapDataFromFields: Map<String, String> = mapOf()
    private var panelModeling: ViewModeling? = null

    private val controller = _control
    init{
        // Выход из программы при закрытии
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        // Кнопки для создания диалоговых окон
        val box1 = Box.createHorizontalBox()
        val nameStLabel = JLabel("Название cтанции:")
        nameStationField = JTextField(15)
        box1.add(nameStLabel)
        box1.add(Box.createHorizontalStrut(6))
        box1.add(nameStationField)

        val box2 = Box.createHorizontalBox()
        val markUpFieldLabel = JLabel("Наценка:")
        markUpField = JTextField(15)
        box2.add(markUpFieldLabel)
        box2.add(Box.createHorizontalStrut(6))
        box2.add(markUpField)

        val box3 = Box.createHorizontalBox()
        val maxLenQLabel = JLabel("Максимальная длина очереди у автомата:")
        maxLenQueueField = JTextField(15)
        box3.add(maxLenQLabel)
        box3.add(Box.createHorizontalStrut(6))
        box3.add(maxLenQueueField)


        val box4 = Box.createHorizontalBox()
        val countPetrolLabel = JLabel("Количество автоматов на станции:")
        countPetrolStField = JTextField(15)
        box4.add(countPetrolLabel)
        box4.add(Box.createHorizontalStrut(6))
        box4.add(countPetrolStField)

        val ok = JButton("Начать моделирование")
        ok.addActionListener {
//            setValuesMap()
//            printData()
            if (fieldsIsCorrect()) {
                controller.setPrimarySettings(
                    nameStationField.getText(),
                    markUpField.getText().toInt(),
                    maxLenQueueField.getText().toInt(),
                    countPetrolStField.getText().toInt(),
                    mapOf(),
                    mapOf()
                )
                controller.startModeling()
            }else{
                JOptionPane.showMessageDialog(this,"Введены неверные данные, попробуйте еще раз","Ошибка ввода",1)
            }
//            panelModeling = ViewModeling()
        }
        val mainBox = Box.createVerticalBox()
        mainBox.border = EmptyBorder(20, 20, 20, 20)
        mainBox.add(box1)
        mainBox.add(Box.createVerticalStrut(12))
        mainBox.add(box2)
        mainBox.add(Box.createVerticalStrut(17))
        mainBox.add(box3)
        mainBox.add(Box.createVerticalStrut(22))
        mainBox.add(box4)
        val testKeyL = TestKeyListener()
        nameStationField.addKeyListener(testKeyL)
        markUpField.addKeyListener(testKeyL)
        maxLenQueueField.addKeyListener(testKeyL)
        countPetrolStField.addKeyListener(testKeyL)

        val button2 = JButton("Настройка параметров автоматов")
        button2.addActionListener {
//            val dialog2 = ControlFrame(controller)
//            dialog2.DialogPanel()
            controller.startSettingsPumps()
        }

        val contents = JPanel()
        contents.add(mainBox)
        contents.add(ok)
        contents.add(button2)
        contentPane = contents

        setSize(500, 300)
        isVisible = true
    }

    private fun fieldsIsCorrect(): Boolean {
        val list = listOf(nameStationField.getText(),markUpField.getText(),maxLenQueueField.getText(),countPetrolStField.getText())
        if (list.all{it.length>0}){
            return true
        }
        return false

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

    fun setValuesMap() {
        mapDataFromFields = mapOf(Pair("StationName",nameStationField.text),
            Pair("MarkUp",markUpField.text),
            Pair("MarkUp",markUpField.text),
            Pair("MaxLenQueue",maxLenQueueField.text),
            Pair("CountAutomate", countPetrolStField.text))
    }


    /** Функция создания диалогового окна.
     * @param title - заголовок окна
     * @param modal - флаг модальности
     */


    fun createDialog(title: String, modal: Boolean): JDialog {
        val dialog = JDialog(this, title, modal)
        dialog.defaultCloseOperation = WindowConstants.DISPOSE_ON_CLOSE
        //        dialog.setSize(200, 130);
        return dialog
    }

    fun putData(data: ArrayList<Int>) {
        if (panelModeling != null) {
            panelModeling!!.putDataInTable(data)
        }
    }

    companion object {
        private val serialVersionUID = 1L

        @JvmStatic
        fun main(args: Array<String>) {
//            val dia = MainControlFrame()

        }
    }
}
