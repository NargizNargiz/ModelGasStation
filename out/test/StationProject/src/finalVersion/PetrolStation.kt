package finalVersion

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
    var soldGasoline = 0.0
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
//    fun getMark():finalVersion.MarkPetrol{
//        return mark
//    }
    private fun setProfitSt(){

    }
    fun processReqs(time: Int):Int{
        var countServed = 0
        var timer = time*60
        var currentReq: Request
        while (timer > 0){
//            println("while in procedd reqs $countServed . reqs: $requests")
            if (!requests.isEmpty()){
                    currentReq = requests.first()
//                    println(" if 1 in procedd reqs $countServed timer ^ $timer")
//                  если время обслуживания данной заявки меньше шага, то обслуживание происходит
                    if (timer  > currentReq.getTimeLeft()){
                        profitStation += currentReq.priceWithMarkUp
                        timer -=  currentReq.getTimeLeft().toInt()
                        countServed++
                        soldGasoline += currentReq.volume
//                        println("if 2 in procedd reqs $countServed")
                        requests.removeFirst()
                        setLengthQueue()
                    }else{
                        currentReq.setTimeLeft(timer.toDouble())
                        break
                    }
                }else{
                    break
                }
        }
        return countServed
    }
    fun getNumberSameMark():ArrayList<Int>{
        return numbersSameMark
    }
    fun addNumberSameMark(first: Int, count: Int){
        for (k in first+1 until first+count){
            numbersSameMark.add(k)
        }
    }
    fun getReqs():Deque<Request>{
        return requests
    }
}
