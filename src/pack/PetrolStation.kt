package pack

import java.util.*
import kotlin.collections.ArrayList

data class PetrolStation(var mark: MarkPetrol = MarkPetrol.UNDEFINED, var price: Int = 0, var countSameMarkPetrol: Int = 0){
    var number: Int = 0
    var lengthQueue: Int = 0
    private var numbersSameMark: ArrayList<Int> = arrayListOf()
    var requests: Deque<Request> = ArrayDeque<Request>()
    var profitStation : Double = 0.0
    constructor(_mark: MarkPetrol,
                _price: Int,
                _number: Int,
                _countSameMarkPetrol: Int
                ): this(_mark,_price,_countSameMarkPetrol){
        number = _number
    }
//    fun getNumber():Int{
//        return number
//    }
//    fun setNumber(i: Int){
//        number = i
//    }
    fun setLengthQueue(){
        this.lengthQueue = requests.size
    }
    fun setNumbersSameMark(petrolStations:ArrayList<PetrolStation>){
        val arr = arrayListOf<Int>()
        for (elem in petrolStations){
            if (elem.mark == this.mark && elem.number != this.number){
                arr.add(elem.number)
            }
        }
        this.numbersSameMark = arr
    }
    fun quequeIsFull(maxLen: Int):Boolean = lengthQueue == maxLen

    fun addRequests(req: Request){
        lengthQueue++
        this.requests.add(req)
    }
//    fun getMark():pack.MarkPetrol{
//        return mark
//    }
    private fun setProfitSt(){

    }
    fun processRequest(time: Int):Boolean{
        if (!requests.isEmpty()) {
            val currentReq = requests.first()
            if (time * 60.0 > currentReq.getTimeLeft()) {
                profitStation += currentReq.money
                requests.removeFirst()
                return true
            }
        }
        return false
    }
    fun getNumberSameMark():ArrayList<Int>{
        return numbersSameMark
    }
    fun addNumberSameMark(first: Int, count: Int){
        for (k in first+1 until first+count){
            numbersSameMark.add(k)
        }
    }
}
