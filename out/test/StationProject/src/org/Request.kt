package org

import kotlin.math.round
data class Request(var volume: Int = 0,
//                 сколько заплатит покупатель с наценкой за volume литров бензина
                   var priceWithMarkUp: Int = 0,
                   var mark: MarkPetrol = MarkPetrol.UNDEFINED,
                   private var timeLeft: Double = 0.0
){

    private fun calculateFilling(): Int{
        return (0.4*volume).toInt()
    }
    fun setfillTime(speed: Double){
        timeLeft = round((volume/speed)*1000)/1000
    }

    fun getTimeLeft():Double{
        return timeLeft
    }
    fun setPriceMarkUp(markUp: Int, price: Int){
        priceWithMarkUp = ((markUp/100)*price + price)*volume
    }
}
