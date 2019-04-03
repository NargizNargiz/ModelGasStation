import com.sun.org.apache.xpath.internal.operations.Mod
import java.util.*
import kotlin.math.round
import kotlin.math.sqrt
import kotlin.random.Random

class Model(_nameStation: String, _n: Int, _k: Int){
    private var nameStation: String = "petrol"
    private var n: Int = 5 // max length of queue
    private var k: Int = 3 // count petrol stations
    private var markUp: Int = 10
    private var timeRange: Int = 20
    private var markRange: Int = 7
    private var volumeRange: Int = 1
    private var gasStation: GasStation = GasStation(nameStation)
    private val speed: Double = 3.6
    init{
        nameStation = _nameStation
        n = _n
        k = _k
    }
    constructor(_nameStation: String,_n: Int, _k: Int, _markUp: Int,
                _timeRange: Int,_markRange: Int, _volumeRange: Int, _gasStation: GasStation):this(_nameStation,_n,_k){
        n = _n
        k= _k
        markUp = _markUp
        markRange = _markRange
        timeRange = _timeRange
        volumeRange = _volumeRange
        gasStation = _gasStation
    }
    fun createGasStation(){
    }
//    возрващает массив отрезков времени, через которые поступают заявки. Это случайные величины
    fun getRandomSegment(stadanrtDeviation: Int):ArrayList<Int>{
        var value = 0.0
        val n = 6
        var res = arrayListOf<Int>()
        val randomValues = List(6){ Random.nextDouble(0.0, 5.0)}
            .map { round(it*1000) /1000 }
        for (i in 0 until n){
            value = (randomValues[i] - 1)*stadanrtDeviation*sqrt(1.0) + 10
            res.add(value.toInt())
        }
        return res
    }
    fun getRandomVolume():Int{
        return Random.nextInt(10, 50)
    }
//    create queue of requests, input  size queue
    fun queueRequest(size: Int):Queue<Request>{
        val res: Queue<Request> = ArrayDeque<Request>()
        var newReq: Request
        var newVolume: Int
        var newMark: MarkPetrol = MarkPetrol.UNDEFINED
        for (i in 0 until size){
            newVolume = getRandomVolume()
            newMark = newMark.getRandom()
            newReq = Request(
                newVolume,
                newMark,
                0.0,
                false
            )
            res.add(newReq)
        }
        return res
    }
}
