package org

import finalVersion.Observer
import java.util.*
import kotlin.math.abs
import kotlin.math.round
import kotlin.math.sqrt
import kotlin.random.Random

interface ModelInterface{
    fun initialize()
    fun registerObserver(obj: Observer)
    fun removeObrever(obj: Observer)
}

data class Model(private var nameStation: String = "petrol",  private var markUp: Int = 10, private var countsPumps:Int = 0):ModelInterface{
    private var timeRange: Int = 20
    private var markRange: Int = 7
    private var volumeRange: Int = 1
    private var gasStation: GasStation = GasStation(nameStation)
    private var maxLengthQueue: Int = 5 // max length of queue
    private val speed: Double = 0.277
    private val observers = ArrayList<Observer>()
    constructor(_nameStation: String,
                _markUp: Int,
                _countsPumps:Int,
                _timeRange: Int,
                _markRange: Int,
                _volumeRange: Int, _gasStation: GasStation
    ):this(_nameStation,_markUp,_countsPumps){
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
    fun createGasStation(counts: Map<String,String>, prices :Map<String,String>){
        val myGasStation = GasStation(nameStation)
        val marks = MarkPetrol.values()
        var countAll = 1
        println("counts : $counts")
        println("prices : $prices")
//        myGasStation.maxLengthQueue = maxLengthQueue
        myGasStation.setMaxLen(maxLengthQueue)
//        for (i in 1 until 7){
        for (k in counts.keys ){
            var mark = MarkPetrol.UNDEFINED.getMarkFromString(k)
            var price:Int = prices[k]?.toInt()?:0
//            println("Какой количество автоматов типа ${marks[i]}")
            val countAutomate = counts[k]?.toInt()?:0
            println("$mark: $countAutomate ")
            var petrolStation = PetrolStation()
            for(j in 0 until countAutomate) {
//                petrolStation = PetrolStation(marks[i], i * 3, countsPumps)
                petrolStation = PetrolStation(mark, price, countAutomate)
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
        notifyObservers()
    }
//    возрващает массив отрезков времени, через которые поступают заявки. Это случайные величины
    fun getRandomSegment(a: Int, b:Int):Deque<Int>{
        val n = 15
        val res  = ArrayDeque<Int>()
        var valS = 0.0
        var value = 0.0
        for (i in 0 until n){
            val randomValues = List(12){ Random.nextDouble(0.0, 1.0)}
                    .map { round(it*1000) /1000 }
            valS = randomValues.sum()
            value = a + (b-a)*(valS-6)
            if (value.toInt() > 0 && value >a && value <=b) {
                res.add(value.toInt())
            }
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

    override fun initialize() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun registerObserver(obj: Observer) {
        observers.add(obj)
    }

    override fun removeObrever(obj: Observer) {
        var i = observers.indexOf(obj)
        if (i>=0){
            observers.remove(obj)
        }
    }
    fun notifyObservers(){
        for (obs in observers){
            obs.updateTable()
        }
    }
}
