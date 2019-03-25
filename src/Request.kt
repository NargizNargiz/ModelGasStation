import kotlin.random.Random

class Request(_volume: Int = 0){
    private var volume: Int = 0
    private var mark: MarkPetrol = MarkPetrol.UNDEFINED
    private var fullTank: Boolean = false

    init{
       volume = _volume
    }
    constructor(_volume: Int, _mark: MarkPetrol, _fullTank: Boolean):this(_volume){
        mark = _mark
        fullTank = _fullTank
    }
//    sec
    private fun calculateFilling(): Int{
        return (0.4*volume).toInt()
    }

}