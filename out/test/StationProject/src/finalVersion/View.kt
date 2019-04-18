package finalVersion

import kotlinGui1.ViewModeling
import org.*
import packageGui.JDialogStation
import java.awt.Color
import java.awt.Dimension
import java.awt.FlowLayout
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import javax.swing.*
import javax.swing.border.EmptyBorder

interface Observer{
    fun update()
    fun updateTable()
}

class View(_controller: ControllerInterface, _model: Model): JFrame(), Observer{
    var controller : ControllerInterface = _controller
    var model: Model = _model
//  интерфейс главного окна
    private val mainFrame = JFrame()
    private val nameStationField: JTextField =JTextField(15)
    private val markUpField: JTextField = JTextField(15)
    private val maxLenQueueField: JTextField = JTextField(15)
    private val countPetrolStField: JTextField = JTextField(15)
    private var mapDataFromFields: Map<String, String> = mapOf()
    private var panelModeling: ViewModeling? = null

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
    private val butStep1 = JButton("Шаг 10 минут")
    private val butStep2 = JButton("Шаг 30 минут")
    private val butStep3 = JButton("Шаг 60 минут")
    private val but1: JButton = JButton("A80")
    private val but2: JButton = JButton("A90")
    private val but3: JButton = JButton("A92")
    private val but4: JButton = JButton("A95")
    private val but5: JButton = JButton("A98")
    private val but6: JButton = JButton("A100")
    private val nextBut: JButton = JButton("Next step")

    init{
        model.registerObserver(this)

    }
    fun createView(){
//        val dialogPanel = MainControlFrame(controller)

        mainFrame.title = "Модель: бензозаправочная станция"
        mainFrame.defaultCloseOperation = EXIT_ON_CLOSE
        // Кнопки для создания диалоговых окон
        val box1 = Box.createHorizontalBox()
        val nameStLabel = JLabel("Название cтанции:")
        box1.add(nameStLabel)
        box1.add(Box.createHorizontalStrut(6))
        box1.add(nameStationField)

        val box2 = Box.createHorizontalBox()
        val markUpFieldLabel = JLabel("Наценка:")
        box2.add(markUpFieldLabel)
        box2.add(Box.createHorizontalStrut(6))
        box2.add(markUpField)

        val box3 = Box.createHorizontalBox()
        val maxLenQLabel = JLabel("Максимальная длина очереди у автомата:")
        box3.add(maxLenQLabel)
        box3.add(Box.createHorizontalStrut(6))
        box3.add(maxLenQueueField)


        val box4 = Box.createHorizontalBox()
        val countPetrolLabel = JLabel("Количество автоматов на станции:")
        box4.add(countPetrolLabel)
        box4.add(Box.createHorizontalStrut(6))
        box4.add(countPetrolStField)

        val ok = JButton("Начать моделирование")
        ok.addActionListener {
            //            setValuesMap()
//            printData()
            if (fieldsIsCorrect() && setMapMarksCount() && setMapMarksPrices()) {
                controller.setPrimarySetting(
                    nameStationField.getText(),
                    markUpField.getText().toInt(),
                    maxLenQueueField.getText().toInt(),
                    countPetrolStField.getText().toInt(),
                    mapMarksCount,
                    mapMarksPrices
                )
                setValuesMap()
                controller.setStartModeling()
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
            if (fieldsIsCorrect()) {
                controller.setStartSettings()
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
    fun createControls(){
//        val subDialogControl = ControlFrame(controller)

        val dialog = JDialog(mainFrame, title, true)
        dialog.defaultCloseOperation = WindowConstants.DISPOSE_ON_CLOSE
        dialog.setSize(400, 600)
//            createDialog("Настройка автоматов с бензином", true)

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

        val keyL = JDialogStation.TestKeyListener()
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
                controller.setSettingsPumps(mapMarksCount,mapMarksPrices)
                dialog.isVisible = false

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

    fun createModelViewFrame(){
//        var modelinView = ViewModeling()
//        val dialog1 = createDialog("Настройка автоматов", true,this)
        val dialog1 = JDialog(mainFrame, title, true)
        dialog1.defaultCloseOperation = WindowConstants.DISPOSE_ON_CLOSE
        dialog1.setBounds(300, 100, 1300, 900)

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

        val container1 = contentPane
        container1.layout = FlowLayout(FlowLayout.LEFT, 100, 10)

        val box1 = Box.createVerticalBox()
        box1.add(but1)
        box1.add(Box.createVerticalStrut(10))
        box1.add(tab1)
        //        JScrollPane scroll = new JScrollPane(tab1);
        //        scroll.setBorder(BorderFactory.createEmptyBorder(50,100,50,100));
        //        box1.add(scroll);
        //        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        val box2 = Box.createVerticalBox()
        box2.add(but2)
        box2.add(Box.createVerticalStrut(10))
        box2.add(tab2)
        val box3 = Box.createVerticalBox()
        box3.add(but3)
        box3.add(Box.createVerticalStrut(10))
        box3.add(tab3)
        val box4 = Box.createVerticalBox()
        box4.add(but4)
        box4.add(Box.createVerticalStrut(10))
        box4.add(tab4)
        val box5 = Box.createVerticalBox()
        box5.add(but5)
        box5.add(Box.createVerticalStrut(10))
        box5.add(tab5)

        val box6 = Box.createVerticalBox()
        box6.add(but6)
        box6.add(Box.createVerticalStrut(10))
        box6.add(tab6)


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
        container1.layout = FlowLayout(FlowLayout.LEFT, 100, 10)
        container1.add(box7)
//        container1.add(butStep1)
//        container1.add(butStep2)
//        container1.add(butStep3)

        container1.layout = FlowLayout(FlowLayout.RIGHT, 100, 10)
        container1.add(nextBut)
        dialog1.add(container1)
        dialog1.pack()
        dialog1.isResizable = true
        dialog1.isVisible = true

    }
    override fun update() {

    }

    override fun updateTable() {
        for( i in 0 until tab1.columnCount){
            tab1.setValueAt(i,0,i)
        }
    }

}