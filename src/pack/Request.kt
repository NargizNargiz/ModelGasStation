package pack

import pack.MarkPetrol
import kotlin.math.round
data class Request(var volume: Int = 0,
                   var money: Int = 0,
                   var mark: MarkPetrol = MarkPetrol.UNDEFINED,
                   private var timeLeft: Double = 0.0,
                   private var fullTank: Boolean = false){

    private fun calculateFilling(): Int{
        return (0.4*volume).toInt()
    }
    fun setfillTime(speed: Double){
        timeLeft = round((volume/speed)*1000)/1000
    }
    fun getTimeLeft():Double{
        return timeLeft
    }
    fun setMoney(markUp: Int, price: Int){
        money = ((markUp/100)*price + price)*volume
    }
}
