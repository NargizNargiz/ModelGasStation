package packageGui

import javax.swing.*
import java.awt.*
import sun.swing.SwingUtilities2.drawRect
import javax.swing.JComponent
import javax.swing.border.TitledBorder


class MyGraphics internal constructor() : JFrame() {
    init {
        preferredSize = Dimension(500, 100)
    }

    fun MyGraphics() {
        val frame = JFrame()
        val box1 = Box.createVerticalBox()
        val box3 = Box.createVerticalBox()
        val box2 = Box.createHorizontalBox()
        val container1 = contentPane
        frame.defaultCloseOperation = EXIT_ON_CLOSE

        container1.layout = FlowLayout(FlowLayout.CENTER, 50, 50)
        box1.add(Box.createVerticalStrut(10))
        box1.add(Pump1(10,10))
        box1.add(Box.createVerticalStrut(10))
        box1.add(Pump2())
        box1.add(Box.createVerticalStrut(10))
        box1.add(Pump3())
        box1.add(Box.createVerticalStrut(10))
        box1.add(Pump4())
        box1.add(Box.createVerticalStrut(10))
        box1.add(Pump5())
        box1.add(Box.createVerticalStrut(10))
        box1.add(Pump5())

        box1.border =  BorderFactory.createTitledBorder("A80")
        box1.setBounds(40,40,100,6*30+30*5)

        box3.add(Box.createVerticalStrut(10))
        box3.add(Pump1(10,10))
        box3.add(Box.createVerticalStrut(10))
        box3.add(Pump2())
        box3.add(Box.createVerticalStrut(10))
        box3.add(Pump3())
        box3.add(Box.createVerticalStrut(10))
        box3.add(Pump4())
        box3.add(Box.createVerticalStrut(10))
        box3.add(Pump5())
        box3.add(Box.createVerticalStrut(10))
        box3.add(Pump5())

        box3.border =  BorderFactory.createTitledBorder("dsfdjkghdj")
        box3.setBounds(250,40,100,6*30 + 30*5)

        box2.add(box1)
        box2.add(Box.createHorizontalStrut(60))
        box2.add(box3)

//        container1.add(box1)
//        container1.add(box3)
        frame.add(box1)
        frame.add(box3)
//        container1.add(box2)
//        frame.add(box2)


        frame.add(container1)
        frame.setSize(800, 600)
        frame.isVisible = true
    }

    internal class Pump1(val xx:Int = 0, val yy: Int = 0) : JComponent() {
       override fun paint(g: Graphics) {
            g.drawOval(xx, yy, 20, 20)
            g.color = Color.darkGray
            g.fillOval(xx, yy, 20, 20)
            g.drawString("A80", 10, 10)
        }
    }
    internal class Pump2 : JComponent() {
        override fun paint(g: Graphics) {
            g.drawOval(10, 10, 20, 20)
            g.color = Color.BLACK
            g.fillOval(10, 10, 20, 20)
            g.drawString("A92", 20, 30)
        }
    }
    internal class Pump3 : JComponent() {
        override fun paint(g: Graphics) {
            g.drawOval(10, 10, 30, 30)
            g.color = Color.RED
//            g.fillOval(40, 110, 30, 30)
            g.drawString("A95", 10, 10)
        }
    }
    internal class Pump4 : JComponent() {
        override fun paint(g: Graphics) {
            g.drawOval(10, 10, 30, 30)
            g.color = Color.BLUE
//            g.fillOval(40, 140, 30, 30)
            g.drawString("A98", 10, 10)
        }
    }
    internal class Pump5 : JComponent() {
        override fun paint(g: Graphics) {
            g.drawOval(10, 10, 30, 30)
            g.color = Color.CYAN
//            g.fillOval(40, 170, 30, 30)
            g.drawString("A100", 10, 10)
        }
    }
    internal class Pump6 : JComponent() {
        override fun paint(g: Graphics) {
            g.drawOval(10, 10, 30, 30)
            g.color = Color.GREEN
//            g.fillOval(40, 200, 30, 30)
            g.drawString("A101", 10, 10)
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            EventQueue.invokeLater {
//                val GUI = Graph()
//                GUI.createGui()
                MyGraphics().MyGraphics()
            }
        }
    }

}
