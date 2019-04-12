import packageGui.gui
import java.awt.Color
import javax.swing.JButton
import javax.swing.JFrame

//class packageGui.gui {
//    var pan: JPanel = JPanel()
//
//    fun packageGui.gui(){
//        pan.background = Color.darkGray
//    }
//}

fun main() {
    val f = JFrame("hello")
    val b = JButton("click me")
    b.setBounds(150, 200, 100, 40)
    b.background = Color.LIGHT_GRAY
    b.isVisible = true

    f.contentPane = gui().pan
    f.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    f.setSize(400, 400)
    f.setLocationRelativeTo(null)
    f.isVisible = true
    f.add(b)
}