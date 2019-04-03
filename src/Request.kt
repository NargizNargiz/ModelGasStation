import kotlin.random.Random

class Request(_volume: Int = 0,_timeStill:Int = 0 ){
    private var volume: Int = 0
    private var mark: MarkPetrol = MarkPetrol.UNDEFINED
    private var timeStill: Double = 0.0
    private var fullTank: Boolean = false

    init{
       volume = _volume
    }
    constructor(_volume: Int, _mark: MarkPetrol,_timeStill: Double, _fullTank: Boolean ):this(_volume){
        mark = _mark
        fullTank = _fullTank
        timeStill = _timeStill
    }
//    sec
    private fun calculateFilling(): Int{
        return (0.4*volume).toInt()
    }
    fun println(){
        println("volume: $volume, mark: $mark, fullTank: $fullTank;")
    }
    private fun fillTime(speed: Double):Double{
        return volume*speed
    }
}
