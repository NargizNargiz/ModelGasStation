package finalVersion
import createSt
import javax.swing.JDialog
import kotlin.math.round

interface ControllerInterface{
    fun setStep(step: Int)
    fun stepByStepDo()
    fun continuouslyDo()
    fun setPrimarySettings(name: String, markUp: Int, maxLen : Int, countPumps :Int, counts :Map<String,String>?, prices:Map<String,String>?)
    fun startModeling()
    fun startSettingsPumps()
    fun getStateAfterDay(time: Int)
    fun getInfoPump(p:JDialog, mark: MarkPetrol)
    fun viewAllParams()
}

class Controller(_model: Model): ControllerInterface{
    private var model: Model = _model
    private var view: View

    init{
        model = _model
        view = View(this)
//        view.regObsev()
        view.createView()
//        view.createControls()
        model.initialize()
    }
    override fun setPrimarySettings(name: String, markUp: Int, maxLen : Int, countPumps :Int,
                                    counts :Map<String,String>?, prices:Map<String,String>?){
        model = createSt(name,markUp, maxLen,14, countPumps,counts!!,prices!!)
        view.controller = this
//        view.model = model
        view.viewDay(model.getDay())
        view.viewConvertGlobalTime(model.convertTime(model.getTime()))
        view.viewConvertEventTime(model.convertTime(model.getTimeEvent()))
        view.viewVolume("0")
        view.viewAvgVolumeHour("0")
        view.viewAvgVolumeDay("0")
        view.viewCounts(0,0)
        view.viewProfit(0.0)
        model.registerObserver(view)
    }
    override fun setStep(step: Int) {
        model.setStep(step)
    }
    override fun stepByStepDo() {
        model.nextStepOfModeling()
        view.viewDay(model.getDay())
        view.viewConvertGlobalTime(model.convertTime(model.getTime()))
        view.viewConvertEventTime(model.convertTime(model.getTimeEvent()))
        view.viewVolume(model.getGasStation().getVolume().toString())

        view.viewCounts(model.getGasStation().getCountServed(), model.getGasStation().getNotServed())
        view.viewProfit(model.getGasStation().getProfit())
    }
    override fun continuouslyDo() {
        model.continuously()

        view.viewDay(model.getDay())
        view.viewConvertGlobalTime(model.convertTime(model.getTime()))
        view.viewConvertEventTime(model.convertTime(model.getTimeEvent()))
        view.viewVolume(model.getGasStation().getVolume().toString())
        view.viewAvgVolumeDay(model.getAvgVolumeDay().toString())
        view.viewCounts(model.getGasStation().getCountServed(), model.getGasStation().getNotServed())
        view.viewProfit(model.getGasStation().getProfit())
    }
    override fun getStateAfterDay(time:Int){
        model.modelingStep(time)
        view.viewDay(model.getDay())
        view.viewConvertGlobalTime(model.convertTime(model.getTime()))
        view.viewConvertEventTime(model.convertTime(model.getTimeEvent()))
        view.viewVolume(model.getGasStation().getVolume().toString())
        view.viewAvgVolumeHour(model.getAvgVolumeHour().toString())

    }
    override fun startModeling() {
        view.createModelViewFrame()
//        view.viewTime(model.getTime(),model.getTimeEvent())
        view.viewDay(model.getDay())
    }
    override fun startSettingsPumps() {
        view.createControls()
    }
    override fun getInfoPump(p: JDialog, mark: MarkPetrol){
        view.viewInfoPump(p,model.getGasStation().getInfo(mark))
    }

    override fun viewAllParams() {
        view.viewDay(model.getDay())
        view.viewConvertGlobalTime(model.convertTime(model.getTime()))
        view.viewConvertEventTime(model.convertTime(model.getTimeEvent()))

        view.viewVolume(model.getGasStation().getVolume().toString())
        view.viewAvgVolumeDay(model.getAvgVolumeDay().toString())
        view.viewAvgVolumeHour(model.getAvgVolumeHour().toString())
        view.viewProfit(model.getGasStation().getProfit())
        view.viewCounts(model.getGasStation().getCountServed(), model.getGasStation().getNotServed())

    }
}
fun main(){
    Controller( Model())
}