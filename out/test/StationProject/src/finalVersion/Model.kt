package finalVersion

import java.util.*
import kotlin.math.round
import kotlin.math.roundToInt
import kotlin.random.Random

interface ModelInterface{
    fun registerObserver(obj: Observer)
    fun removeObserver(obj: Observer)
    fun initialize()
}

data class Model(private var nameStation: String = "petrol",  private var markUp: Int = 10, private var countsPumps:Int = 0):
    ModelInterface {
    private var gasStation: GasStation = GasStation(nameStation)
    private var maxLengthQueue: Int = 5 // max length of queue
    private val speed: Double = 0.277

    private var observers = ArrayList<Observer>()
    private var globalTimer: Int = 0
    private var eventTimer: Int = 0
    private var segment: Deque<Int> = ArrayDeque<Int>()
    private var newRequests : Deque<Request> = ArrayDeque<Request>()
    private var countsReq : Int = 0
    private var stepModeling :Int = 1
    private var timeModeling = 10080

    constructor(_nameStation: String,
                _markUp: Int,
                _countsPumps:Int,
                _gasStation: GasStation
    ):this(_nameStation,_markUp,_countsPumps){
        gasStation = _gasStation

    }

    override fun initialize() {
        maxLengthQueue = 5
        observers = ArrayList<Observer>()
        globalTimer = 0
        eventTimer= 0
        segment = ArrayDeque<Int>()
        newRequests = ArrayDeque<Request>()
        countsReq = 0
        stepModeling = 1
        timeModeling = 10080

        gasStation = GasStation(nameStation)

        gasStation.createPetrolStations(arrayListOf())
        gasStation.setCountServe(0)
        gasStation.setNotServe(0)
        gasStation.setProfit(0.0)
        gasStation.setMaxLen(5)
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
        var countAll = 1
        println("counts : $counts")
        println("prices : $prices")
        myGasStation.setMaxLen(maxLengthQueue)
        for (k in counts.keys ){
            val mark = MarkPetrol.UNDEFINED.getMarkFromString(k)
            val price:Int = prices[k]?.toInt()?:0
            val countAutomate = counts[k]?.toInt()?:0
            println("$mark: $countAutomate ")
            var petrolStation: PetrolStation
            for(j in 0 until countAutomate) {
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
    fun setRandomSegment(a: Int, b:Int):Deque<Int>{
        val n = 15
        val res  = ArrayDeque<Int>()
        var valS: Double
        var value: Double
        for (i in 0 until n){
            val randomValues = List(12){ Random.nextDouble(0.0, 1.0)}
                    .map { round(it*1000) /1000 }
            valS = randomValues.sum()
            value = a + (b-a)*(valS-6)
            if (value.toInt() > 0 && value >a && value <=b) {
                res.add(value.toInt())
            }
        }
        segment = res
        return res
    }
    private fun getRandomVolume():Int{
        return Random.nextInt(10, 50)
    }
    fun randomValue(){
        val avgIntensity = 6.0 //средняя интнесивность это 6 машин в час(т.к время между заявками 0-20 минут -> среднee время между ними 10мин,60мин/10=6)
        val intensityWithMarkUp: Double = avgIntensity - (markUp/100)*avgIntensity
        val right = intensityWithMarkUp.roundToInt() - 5
        val left = intensityWithMarkUp.roundToInt() + 5
    }
    fun getDay():String{
        val hours = globalTimer/60
        val days : Int
        val res: String
        if (hours < 24){
            res = "Пн"
        }else{
            days = hours/24
            res = when(days % 7){
                0 -> "Пн"
                1 -> "Вт"
                2 -> "Ср"
                3 -> "Чт"
                4 -> "Пт"
                5 -> "Сб"
                6 -> "Вс"
                else -> (days%7).toString()
            }
        }
        return res
    }
//    create queue of requests, input  size queue
    fun queueRequests(size: Int){
        val res: Deque<Request> = ArrayDeque<Request>()
        var newReq: Request
        var newVolume: Int
        var newMark: MarkPetrol = MarkPetrol.UNDEFINED
        for (i in 0 until size){
            countsReq++
            newVolume = getRandomVolume()
            newMark = newMark.getRandom()
            newReq = Request(
                newVolume,
                0,
                newMark,
                0.0,
                countsReq
            )
            res.add(newReq)
        }
//        gasSt.setNewRequests(res)
        newRequests = res
//        newRequests = initArrReqs()
}
    override fun registerObserver(obj: Observer) {
        observers.add(obj)
    }

    override fun removeObserver(obj: Observer) {
        val i = observers.indexOf(obj)
        if (i>=0){
            observers.remove(obj) }
    }
    private fun notifyObservers(){
        for (obs in observers){
//            println("notify")
            obs.updateTable(gasStation)
            obs.update(gasStation.getCountServed(), gasStation.getNotServed(),gasStation.getProfit(),0.0)
        }
    }
    fun notifyObserversFinish(){
        for (obs in observers){
//            println("notify")
            obs.updateTable(gasStation)
            obs.update(gasStation.getCountServed(), gasStation.getNotServed(),gasStation.getProfit(),0.0)
            obs.finish()
        }
    }
    fun nextStepOfModeling(){
//        var generalQueue =newRequests
        if (globalTimer <= 10080){
            if (!segment.isEmpty()){
                if (!newRequests.isEmpty()){
                    val req: Request = newRequests.first
                    if (eventTimer + segment.first <= globalTimer + stepModeling){
                        incEventTImer(segment.first)
                        gasStation.allocRequests(req,markUp)
//                        print("состояние автоматов станции после аллокации : ")
//                        gasStation.getArrPetrolStation().forEach{println(it.getReqs())}
                        newRequests.removeFirst()
                        segment.removeFirst()
                    }else{
                        notifyObservers()
                        randomValues()
                        gasStation.updatePetrolStations(stepModeling)
                        gasStation.setSumAllProfits()
                        incTimer(stepModeling)
                    }
                } else{
                    queueRequests(10)
                }
            }else{
                randomValues()
            }
        }
    }

    fun modelingStep(time:Int){
        var t = globalTimer + time
        if (t >= timeModeling){
            while(globalTimer < timeModeling){
                nextStepOfModeling()
            }
            var notServed = 0
            for (pump in gasStation.getArrPetrolStation()){
                notServed += pump.requests.size
            }
            gasStation.setNotServe(notServed)
            notifyObserversFinish()
        }else{
            while(globalTimer < t){
                nextStepOfModeling()
            }
        }
    }

    fun convertTime(t: Int):String{
        val mm = t%(24*60)
        val hh = mm / 60
        val min = mm % 60
        val m: String
        val h: String
        val res: String
        h = if (hh < 10) {"0$hh"}else{"$hh"}
        m = if (min <10){"0$min" }else{ "$min" }
        res = "$h:$m"
        return res
    }
    private fun incEventTImer(time: Int){ eventTimer += time }
    private fun incTimer(time: Int){
        println("globalTImer:$globalTimer")
        globalTimer += time }

    fun continuously(){
        while(timeModeling - globalTimer > 0){
            nextStepOfModeling()
        }
    }
    fun setStep(step: Int){
        stepModeling = step
    }
    fun getTime():Int{
        return globalTimer
    }
    fun getTimeEvent():Int{
        return eventTimer
    }
    //    fun setRandomRange(){
    //    }
    fun getNewRequests():Deque<Request>{
        if (newRequests.isEmpty()) {
            println("Ошибка общая очередь заявок пуста")
        }
        return newRequests
    }
    fun decTimeModeling(t: Int){
        timeModeling -= t
    }

    fun getAvgVolumeHour():Double{
        val hh = globalTimer/60
        val res = gasStation.getVolume()/hh
        return round((res/100)*100)
    }
    fun getAvgVolumeDay():Double{
        val res = gasStation.getVolume()/7
        return round((res/100)*100)
    }
    fun randomValues(){
        val avgIntensity = 6.0 //средняя интнесивность это 6 машин в час(т.к время между заявками 0-20 минут -> среднee время между ними 10мин,60мин/10=6)
        val intensityWithMarkUp: Double = avgIntensity - 3*(markUp/100)*avgIntensity
        var left = intensityWithMarkUp.roundToInt()
        var right = intensityWithMarkUp.roundToInt()+ Random.nextInt(1,8)
        val mm = globalTimer%(24*60)
        val h = mm/60
//        println("intensityWithMarkUp = $intensityWithMarkUp")
//        println("h = $h r=$right l=$left")
        val n = Random.nextInt(1, 5)
        if (when(getDay()){
                "Вс" -> true
                "Сб" -> true
                "Пт" -> true
                else -> false
            }
            && ((h in 19..22) || (h in 8..10) )) {
            println("intensity Higth")
            right -= n
            println("h = $h r=$right l=$left")
            setRandomSegment(left, right)
            println(segment)
        }else{
            setRandomSegment(left, right)
            println(segment)
        }

    }
}

