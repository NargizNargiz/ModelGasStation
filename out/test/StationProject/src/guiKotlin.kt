import java.awt.Color
import java.awt.Panel
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JPanel

//class gui {
//    var pan: JPanel = JPanel()
//
//    fun gui(){
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