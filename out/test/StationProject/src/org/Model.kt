package org

import java.util.*
import kotlin.math.round
import kotlin.math.sqrt
import kotlin.random.Random

data class Model(private var nameStation: String = "petrol",  private var markUp: Int = 10){
    private var timeRange: Int = 20
    private var markRange: Int = 7
    private var volumeRange: Int = 1
    private var gasStation: GasStation = GasStation(nameStation)
    private var maxLengthQueue: Int = 5 // max length of queue
    private val speed: Double = 0.2777
    constructor(_nameStation: String,
                _markUp: Int,
                _timeRange: Int,
                _markRange: Int,
                _volumeRange: Int, _gasStation: GasStation
    ):this(_nameStation,_markUp){
        markRange = _markRange
        timeRange = _timeRange
        volumeRange = _volumeRange
        gasStation = _gasStation
    }
    fun setMaxLen(maxLen: Int){
        maxLengthQueue = maxLen
    }
    fun getMarkUp():Int{return markUp}
    fun getGasStation(): GasStation {
        return gasStation
    }
    fun createGasStation(){
        val myGasStation = GasStation(nameStation)
        val marks = MarkPetrol.values()
        var countAll = 1
//        myGasStation.maxLengthQueue = maxLengthQueue
        myGasStation.setMaxLen(maxLengthQueue)
        for (i in 1 until 8){
            println("Какой количество автоматов типа ${marks[i]}")
            val countAutomate = readLine()!!.toInt()
            var petrolStation = PetrolStation()
            for(j in 0 until countAutomate) {
                petrolStation = PetrolStation(marks[i], i * 3, countAutomate)
                petrolStation.number = countAll
                myGasStation.addPetrolStation(petrolStation)
                countAll++
            }
        }
        //инициализация  для каждого автомата массивов номеров идентичных автоматов
        for (elem in myGasStation.getArrPetrolStation()){
            elem.setNumbersSameMark(myGasStation.getArrPetrolStation())
        }
        gasStation =  myGasStation
    }
//    возрващает массив отрезков времени, через которые поступают заявки. Это случайные величины
    fun getRandomSegment(stadanrtDeviation: Int):Deque<Int>{
        var value = 0.0
        val n = 12
        val res  = ArrayDeque<Int>()
        val randomValues = List(12){ Random.nextDouble(0.0, 10.0)}
            .map { round(it*1000) /1000 }
        for (i in 0 until n){
            value = (randomValues[i] - 1)*stadanrtDeviation*sqrt(1.0) + 5
            res.add(value.toInt())
        }
        return res
    }
    fun getRandomVolume():Int{
        return Random.nextInt(10, 50)
    }
//    create queue of requests, input  size queue
    fun queueRequests(size: Int, gasSt:GasStation){
        val res: Deque<Request> = ArrayDeque<Request>()
        var newReq: Request
        var newVolume: Int
        var newMark: MarkPetrol = MarkPetrol.UNDEFINED
        for (i in 0 until size){
            newVolume = getRandomVolume()
            newMark = newMark.getRandom()
            newReq = Request(
                newVolume,
                0,
                newMark,
                0.0
            )
            res.add(newReq)
        }
        gasSt.setNewRequests(res)
    }

}
