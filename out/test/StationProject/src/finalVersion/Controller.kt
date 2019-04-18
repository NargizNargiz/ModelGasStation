package finalVersion
import createSt
import org.Model
import programRun1
import kotlin.math.max

interface ControllerInterface{
    fun start()
    fun setStep()
    fun stop()
    fun stepByStepDo()
    fun continuoslyDo()
    fun setPrimarySetting(name: String, markUp: Int, maxLen : Int,countPumps :Int,counts :Map<String,String>?, prices:Map<String,String>?)
    fun setSettingsPumps(counts :Map<String,String>?, prices:Map<String,String>?)
    fun setStartModeling()
    fun setStartSettings()
    fun errorOfInput()
}

class Controller(_model:Model): ControllerInterface{
    var model: Model = _model
    var view: View


    init{
        view = View(this,model)
        view.createView()
//        view.createControls()
//        model.initialize()
    }
    override fun setPrimarySetting(name: String, markUp: Int, maxLen : Int,countPumps :Int,
                                   counts :Map<String,String>?, prices:Map<String,String>?){
        model = createSt(name,markUp, maxLen,14, countPumps,counts!!,prices!!)
        programRun1(model)
    }
    override fun setSettingsPumps(counts :Map<String,String>?, prices:Map<String,String>?){
//        if (counts != null && prices != null){
//            model.createGasStation(counts,prices)
//        }else{
//            println("Неправильно заполнены поля")
//        }

    }
    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun stop() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setStep() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun stepByStepDo() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun continuoslyDo() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setStartModeling() {
        view.createModelViewFrame()
    }

    override fun setStartSettings() {
        view.createControls()
    }

    override fun errorOfInput() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
fun main(){
    val model: Model = Model()
    val controller: ControllerInterface  = Controller(model)

}