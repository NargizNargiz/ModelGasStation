package finalVersion

import java.awt.Color
import java.awt.Container
import java.awt.Dimension
import java.awt.FlowLayout
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import java.util.*
import javax.swing.*
import javax.swing.border.EmptyBorder

interface Observer{
    fun update(serve:Int,notServe:Int, profit:Double, avgProfit:Double)
    fun updateTable(gasSt: GasStation)
    fun finish()
}

class View(_controller: ControllerInterface): JFrame(), Observer{
    var controller : ControllerInterface = _controller
//    var model: Model = _model

//  интерфейс главного окна
    private val mainFrame = JFrame()

    private val nameStationField: JTextField =JTextField(15)
    private val nameStLabel = JLabel("Название станции:")
    private val markUpField: JTextField = JTextField(15)
    private val markUpFieldLabel = JLabel("Наценка:")
    private val maxLenQueueField: JTextField = JTextField(15)
    private val maxLenQLabel = JLabel("Максимальная длина очереди у автомата:")
    private val countPetrolStField: JTextField = JTextField(15)
    private val countPetrolLabel = JLabel("Количество автоматов на станции:")

    private var mapDataFromFields: Map<String, String> = mapOf()

//  интерфейс окна настройки автоматов
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

//    интерфейс для отображения моделирования
    private val tab1: JTable = JTable(5, 9)
    private val tab2: JTable = JTable(5, 9)
    private val tab3: JTable = JTable(5, 9)
    private val tab4: JTable = JTable(5, 9)
    private val tab5: JTable = JTable(5, 9)
    private val tab6: JTable = JTable(5, 9)

    private val boxStepsButtons = Box.createVerticalBox()

    private val butStep1 = JButton("Шаг 10 минут")
    private val butStep2 = JButton("Шаг 30 минут")
    private val butStep3 = JButton("Шаг 60 минут")
    private val but1: JButton = JButton("A80")
    private val but2: JButton = JButton("A90")
    private val but3: JButton = JButton("A92")
    private val but4: JButton = JButton("A95")
    private val but5: JButton = JButton("A98")
    private val but6: JButton = JButton("A100")
    private val weekBut: JButton = JButton("7 дней")
    private val dayBut: JButton = JButton("1 день")

    private val nextBut: JButton = JButton("Следующий шаг")
    private val viewStepLabel = JLabel("Шаг               ")
    private val viewStepValue =JLabel()

    private val boxRes = Box.createHorizontalBox()

    private val timer = JLabel("Время:")
    private val timerVal = JLabel()
    private val timerEvent = JLabel("Время поступления запроса: ")
    private val timerEventVal = JLabel()

    private val boxViewParams = Box.createVerticalBox()
    private val boxViewParamsValue = Box.createVerticalBox()


    private val nameValue= JLabel()
    private val markUpValue = JLabel()
    private val countsPumpValue = JLabel()
    private val maxLenValue = JLabel()

    private val profitLabel = JLabel("Общая прибыль")

    private val profitValue = JLabel()
    private val avgProfitValue = JLabel()

    private val serveValue = JLabel()
    private val notServeValue= JLabel()

    private val serveLabel = JLabel("Обслужено")
    private val notServeLabel= JLabel("Не обслужено")

    private val dayValue = JLabel()

    private val convertTimeLabel = JLabel()

    private val volumeLabel = JLabel("Объем проданного бензина (л):")
    private val avgVolumeLabel = JLabel("Средний объем проданного бензина в день:")
    private val volumeValue = JLabel()
    private val avgVolumeValue = JLabel()


    private val avgVolumeHourLabel = JLabel("Средний объем проданного бензина в час:")
    private val avgVolumeHourValue = JLabel()


    private val box1 = Box.createVerticalBox()
    private val box2 = Box.createVerticalBox()
    private val box3 = Box.createVerticalBox()
    private val box4 = Box.createVerticalBox()
    private val box5 = Box.createVerticalBox()
    private val box6 = Box.createVerticalBox()


    private val boxH1 = Box.createHorizontalBox()
    private val boxH2 = Box.createHorizontalBox()
    private val boxVer = Box.createVerticalBox()

    private val boxModelingButtons : Box = Box.createVerticalBox()
    private val boxTime = Box.createVerticalBox()

    private var container1 = Container()

    fun createView(){
//        val dialogPanel = MainControlFrame(controller)
        mainFrame.title = "Модель: бензозаправочная станция"
        mainFrame.defaultCloseOperation = EXIT_ON_CLOSE
        val box1 = Box.createHorizontalBox()
        box1.add(nameStLabel)
        box1.add(Box.createHorizontalStrut(6))
        box1.add(nameStationField)

        val box2 = Box.createHorizontalBox()
        box2.add(markUpFieldLabel)
        box2.add(Box.createHorizontalStrut(6))
        box2.add(markUpField)

        val box3 = Box.createHorizontalBox()
        box3.add(maxLenQLabel)
        box3.add(Box.createHorizontalStrut(6))
        box3.add(maxLenQueueField)


        val box4 = Box.createHorizontalBox()
        box4.add(countPetrolLabel)
        box4.add(Box.createHorizontalStrut(6))
        box4.add(countPetrolStField)

        val ok = JButton("Начать моделирование")
        ok.addActionListener {
            if (fieldsIsCorrect() && setMapMarksCount() && setMapMarksPrices()) {
                var mess = ""
                var flag = 0
                if (markUpField.text.toInt() > 15 || markUpField.text.toInt() < 5){
                    mess += "Наценка должна находится в диапазоне от 5 до 15% \n"
                    flag++
                }
                if (maxLenQueueField.text.toInt() > 9 || maxLenQueueField.text.toInt() < 5){
                    mess += "Максимальная длина очереди должна находится в диапазоне от 5 до 9 машин \n"
                    flag++
                }
                if (flag >0){
                    JOptionPane.showMessageDialog(this,mess,"Ошибка ввода",1)
                }else {
                    controller.setPrimarySettings(
                        nameStationField.text, markUpField.text.toInt(),
                        maxLenQueueField.text.toInt(), countPetrolStField.text.toInt(), mapMarksCount, mapMarksPrices
                    )
                    setValuesMap()
                    controller.startModeling()
                }
            }else{
                JOptionPane.showMessageDialog(this,"Введены неверные данные, попробуйте еще раз","Ошибка ввода",1)
            }
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
            if (fieldsIsCorrect()){
                if (countPetrolStField.text.toInt() < 6){
                    JOptionPane.showMessageDialog(this,"Количество автоматов находится в диапазоне от 6 до 30 штук","Ошибка ввода",1)
                }else{
                    println(mapDataFromFields)
                    controller.startSettingsPumps()
                }

            }else{
                JOptionPane.showMessageDialog(this,"Введены неверные данные, попробуйте еще раз","Ошибка ввода",1)
            }
        }

        val contents = JPanel()
        contents.add(mainBox)
        contents.add(ok)
        contents.add(button2)
        mainFrame.contentPane = contents

        mainFrame.setSize(500, 300)
        mainFrame.isVisible = true
    }
    private fun fieldsIsCorrect(): Boolean {
        val list = listOf(nameStationField.text,markUpField.text,maxLenQueueField.text,countPetrolStField.text)
        if (list.all{ it.isNotEmpty()}){
            setValuesMap()
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
    private fun setValuesMap() {
        mapDataFromFields = mapOf(Pair("StationName",nameStationField.text),
            Pair("MarkUp",markUpField.text),
            Pair("MaxLenQueue",maxLenQueueField.text),
            Pair("CountAutomate", countPetrolStField.text))
    }
    fun createControls(){
        val dialog = JDialog(mainFrame, "Настройка бензозаправочных колонок", true)
        dialog.defaultCloseOperation = WindowConstants.DISPOSE_ON_CLOSE
        dialog.setSize(400, 600)

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
            if (setMapMarksCount() && setMapMarksPrices()){
                val count = mapDataFromFields["CountAutomate"]?.toInt()?:0
//                controller.setSettingsPumps(mapMarksCount,mapMarksPrices)
                var sum = 0
                for (elem in mapMarksCount!!.values){
                    val elemInt = elem.toInt()
                    sum += elemInt
                }
                println(sum)
                if (count != sum){
                    JOptionPane.showMessageDialog(this,"Общее количество автоматов должно быть $count","Ошибка ввода",1)
                }else {
                    dialog.isVisible = false
                }
            }else{
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
    private fun setMapMarksCount():Boolean {
        val list = listOf(stationField1,stationField2,stationField3,stationField4,stationField5,stationField6)
        if (list.any { it == null }){
            return false
        }
        if (list.all { it!!.text.isNotEmpty() }) {
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
    private fun setMapMarksPrices():Boolean {
        val list = listOf(priceField1,priceField2,priceField3,priceField4,priceField5,priceField6)
        if (list.any { it == null }){
            return false
        }
        if (list.all { it!!.text.isNotEmpty() }) {
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
    fun createModelViewFrame(){
        val dialog1 = JDialog(mainFrame, "Моделирование станции: ${mapDataFromFields["StationName"]}", true)
        dialog1.defaultCloseOperation = WindowConstants.DISPOSE_ON_CLOSE
        dialog1.setBounds(200, 100, 900, 900)
        tab1.rowHeight = 20
        tab2.rowHeight = 20
        tab3.rowHeight = 20
        tab4.rowHeight = 20
        tab5.rowHeight = 20
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

        container1 = contentPane
        container1.layout = FlowLayout(FlowLayout.LEFT, 100, 20)


        box1.add(but1)
        box1.add(Box.createVerticalStrut(10))
        box1.add(tab1)

        box2.add(but2)
        box2.add(Box.createVerticalStrut(10))
        box2.add(tab2)

        box3.add(but3)
        box3.add(Box.createVerticalStrut(10))
        box3.add(tab3)

        box4.add(but4)
        box4.add(Box.createVerticalStrut(10))
        box4.add(tab4)

        box5.add(but5)
        box5.add(Box.createVerticalStrut(10))
        box5.add(tab5)


        box6.add(but6)
        box6.add(Box.createVerticalStrut(10))
        box6.add(tab6)

        but1.addActionListener {
            controller.getInfoPump(dialog1, MarkPetrol.A80)
        }
        but2.addActionListener {
            controller.getInfoPump(dialog1, MarkPetrol.A90)
        }
        but3.addActionListener {
            controller.getInfoPump(dialog1, MarkPetrol.A92)
        }
        but4.addActionListener {
            controller.getInfoPump(dialog1, MarkPetrol.A95)
        }
        but5.addActionListener {
            controller.getInfoPump(dialog1, MarkPetrol.A98)
        }
        but6.addActionListener {
            controller.getInfoPump(dialog1, MarkPetrol.A100)
        }

        butStep1.addActionListener{
            controller.setStep(10)
            viewStepValue.text = "10"
        }
        boxStepsButtons.add(butStep1)
        boxStepsButtons.add(Box.createVerticalStrut(10))

        butStep2.addActionListener{
            controller.setStep(30)
            viewStepValue.text = "30"
        }
        boxStepsButtons.add(butStep2)
        boxStepsButtons.add(Box.createVerticalStrut(10))

        butStep3.addActionListener{
            controller.setStep(60)
            viewStepValue.text = "60"
        }

        boxStepsButtons.add(butStep3)



        boxH1.add(box1)
        boxH1.add(Box.createHorizontalStrut(30))
        boxH1.add(box2)
        boxH1.add(Box.createHorizontalStrut(30))
        boxH1.add(box3)


        boxH2.add(box4)
        boxH2.add(Box.createHorizontalStrut(30))
        boxH2.add(box5)
        boxH2.add(Box.createHorizontalStrut(30))
        boxH2.add(box6)



        boxVer.add(boxH1)
        boxVer.add(Box.createVerticalStrut(30))
        boxVer.add(boxH2)
        boxVer.add(Box.createVerticalStrut(30))



        boxViewParams.add(nameStLabel)
        boxViewParams.add(Box.createVerticalStrut(10))
        boxViewParams.add(markUpFieldLabel)
        boxViewParams.add(Box.createVerticalStrut(10))
        boxViewParams.add(countPetrolLabel)
        boxViewParams.add(Box.createVerticalStrut(10))
        boxViewParams.add(maxLenQLabel)
        boxViewParams.add(Box.createVerticalStrut(10))

        boxViewParams.add(profitLabel)
        boxViewParams.add(Box.createVerticalStrut(10))

        boxViewParams.add(serveLabel)
        boxViewParams.add(Box.createVerticalStrut(10))
        boxViewParams.add(notServeLabel)
        boxViewParams.add(Box.createVerticalStrut(10))
        boxViewParams.add(viewStepLabel)
        boxViewParams.add(Box.createVerticalStrut(10))
        boxViewParams.add(volumeLabel)
        boxViewParams.add(Box.createVerticalStrut(10))
        boxViewParams.add(avgVolumeLabel)
        boxViewParams.add(Box.createVerticalStrut(10))
        boxViewParams.add(avgVolumeHourLabel)
        boxViewParams.add(Box.createVerticalStrut(10))


        boxViewParamsValue.add(nameValue)
        boxViewParamsValue.add(Box.createVerticalStrut(10))
        boxViewParamsValue.add(markUpValue)
        boxViewParamsValue.add(Box.createVerticalStrut(10))
        boxViewParamsValue.add(countsPumpValue)
        boxViewParamsValue.add(Box.createVerticalStrut(10))
        boxViewParamsValue.add(maxLenValue)
        boxViewParamsValue.add(Box.createVerticalStrut(10))
        boxViewParamsValue.add(profitValue)
        boxViewParamsValue.add(Box.createVerticalStrut(10))


        boxViewParamsValue.add(serveValue)
        boxViewParamsValue.add(Box.createVerticalStrut(10))
        boxViewParamsValue.add(notServeValue)
        boxViewParamsValue.add(Box.createVerticalStrut(10))
        boxViewParamsValue.add(viewStepValue)
        boxViewParamsValue.add(Box.createVerticalStrut(10))
        boxViewParamsValue.add(volumeValue)
        boxViewParamsValue.add(Box.createVerticalStrut(10))
        boxViewParamsValue.add(avgVolumeValue)
        boxViewParamsValue.add(Box.createVerticalStrut(10))
        boxViewParamsValue.add(avgVolumeHourValue)
        boxViewParamsValue.add(Box.createVerticalStrut(10))




        boxRes.border = BorderFactory.createTitledBorder("Параметры")
        boxRes.add(boxViewParams)
        boxRes.add(Box.createHorizontalStrut(10))
        boxRes.add(boxViewParamsValue)
        boxRes.add(Box.createHorizontalStrut(10))


        boxModelingButtons.add(nextBut)
        boxModelingButtons.add(Box.createVerticalStrut(10))
        boxModelingButtons.add(dayBut)
        boxModelingButtons.add(Box.createVerticalStrut(10))
        boxModelingButtons.add(weekBut)
        boxModelingButtons.add(Box.createVerticalStrut(10))

        nextBut.addActionListener{ controller.stepByStepDo()}
        dayBut.addActionListener{controller.getStateAfterDay(60*24)}
        weekBut.addActionListener{controller.continuouslyDo()}

        boxTime.add(timer)
        boxTime.add(Box.createVerticalStrut(10))
        boxTime.add(timerVal)
        boxTime.add(Box.createVerticalStrut(10))
        boxTime.add(timerEvent)
        boxTime.add(Box.createVerticalStrut(10))
        boxTime.add(timerEventVal)
        boxTime.add(Box.createVerticalStrut(10))
        boxTime.add(dayValue)

//        val boxDayTime = Box.createHorizontalBox()
//
//        boxDayTime.add(dayValue)
//        boxDayTime.add(Box.createHorizontalStrut(10))
//        boxDayTime.add(convertTimeLabel)
//        boxDayTime.add(Box.createHorizontalStrut(10))

//        boxTime.add(boxDayTime)

        container1.layout = FlowLayout(FlowLayout.LEFT, 100, 10)
        container1.add(boxVer)
        container1.layout = FlowLayout(FlowLayout.LEFT, 100, 10)
        container1.add(boxRes)
        container1.layout = FlowLayout(FlowLayout.LEFT, 100, 10)
        container1.add(boxModelingButtons)
        container1.layout = FlowLayout(FlowLayout.LEFT, 100, 10)
        container1.add(boxStepsButtons)
        container1.layout = FlowLayout(FlowLayout.LEFT, 100, 10)
        container1.add(boxTime)

        viewParams()
        viewCounts(0,0)

        dialog1.add(container1)
//        dialog1.pack()
        dialog1.setSize(1400,700)
        dialog1.isResizable = true
        dialog1.isVisible = true

    }
    override fun update(serve:Int,notServe:Int, profit:Double, avgProfit:Double) {
        viewProfit(profit)
        viewCounts(serve,notServe)
    }
    private fun pasteTab(row: Int, pump: PetrolStation){
        val reqs: Deque<Request> = pump.requests
        val arr = reqs.toTypedArray()
        if (reqs.isNotEmpty()){
            val sizeQueue = reqs.size
            for (col in 0 until tab1.columnCount){
                if (col < sizeQueue){
                    when (pump.mark) {
                        MarkPetrol.A80 -> tab1.setValueAt(arr[col].index, row, col)
                        MarkPetrol.A90 -> tab2.setValueAt(arr[col].index, row, col)
                        MarkPetrol.A92 -> tab3.setValueAt(arr[col].index, row, col)
                        MarkPetrol.A95 -> tab4.setValueAt(arr[col].index, row, col)
                        MarkPetrol.A98 -> tab5.setValueAt(arr[col].index, row, col)
                        MarkPetrol.A100 -> tab6.setValueAt(arr[col].index, row, col)
                        else -> {
                        }
                    }
                }else{
                    when (pump.mark){
                        MarkPetrol.A80 -> tab1.setValueAt(' ', row, col)
                        MarkPetrol.A90 -> tab2.setValueAt(' ', row, col)
                        MarkPetrol.A92 -> tab3.setValueAt(' ', row, col)
                        MarkPetrol.A95 -> tab4.setValueAt(' ', row, col)
                        MarkPetrol.A98 -> tab5.setValueAt(' ', row, col)
                        MarkPetrol.A100-> tab6.setValueAt(' ', row, col)
                        else -> {}
                    }
                }
            }
        }else{
            for (col in 0 until tab1.columnCount){
                when (pump.mark){
                    MarkPetrol.A80 -> tab1.setValueAt(' ', row, col)
                    MarkPetrol.A90 -> tab2.setValueAt(' ', row, col)
                    MarkPetrol.A92 -> tab3.setValueAt(' ', row, col)
                    MarkPetrol.A95 -> tab4.setValueAt(' ', row, col)
                    MarkPetrol.A98 -> tab5.setValueAt(' ', row, col)
                    MarkPetrol.A100-> tab6.setValueAt(' ', row, col)
                    else -> {}
                }
            }
        }
        return
    }
    override fun updateTable(gasSt:GasStation) {
//        val gasSt = model.getGasStation()
        val pumps = gasSt.getArrPetrolStation()
        var j = 0
        while ( j < pumps.size){
            var i = 0
            while (i < pumps[j].countSameMarkPetrol ){
//              println("вставляю в $i-ую очередь автомата ${pumps[j]}")
                pasteTab(i, pumps[j+i])
                i++
            }
            j += i
        }
    }

    private fun viewParams(){
        nameValue.text = mapDataFromFields["StationName"]
        markUpValue.text = mapDataFromFields["MarkUp"]
        countsPumpValue.text = mapDataFromFields["CountAutomate"]
        maxLenValue.text = mapDataFromFields["MaxLenQueue"]
        profitValue.text = "0"
        avgProfitValue.text = "0"
        viewStepValue.text ="0"
    }
    fun viewCounts(serve:Int, notServe: Int){
        serveValue.text = "$serve"
        notServeValue.text = "$notServe"
    }
    fun viewProfit(profit:Double){
        profitValue.text = "$profit"
    }
    fun viewVolume(volume: String){
        volumeValue.text = volume
    }
    fun viewAvgVolumeDay(avg: String){
        avgVolumeValue.text = avg
    }
    fun viewAvgVolumeHour(avg: String){
        avgVolumeHourValue.text = avg
    }
    fun viewDay(day:String){
        dayValue.text = day
    }
    fun viewConvertGlobalTime(convertTime: String){
        timerVal.text = convertTime
    }
    fun viewConvertEventTime(convertTime: String){
        timerEventVal.text = convertTime
    }
    fun viewInfoPump(p: JDialog, mess:String){
        JOptionPane.showMessageDialog(p,mess,"Информации о колонке",1)
    }

    override fun finish() {
        controller.viewAllParams()
    }
}