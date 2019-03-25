import java.util.*
import kotlin.collections.ArrayList

class PetrolStation(_mark: MarkPetrol,_price: Int){
    private var mark: MarkPetrol = _mark
    private var price: Int = _price
    private var number: Int = 0
    private var lengthQueue: Int = 0
    private var numbersSameMark: ArrayList<Int> = arrayListOf()
    private var requests: Queue<Request> = ArrayDeque()
    constructor(_mark: MarkPetrol, _price: Int,
                _number: Int, _lengthQueue: Int,
                _numbersSameMark: ArrayList<Int>,
                _requests: Queue<Request>): this(_mark,_price){
        mark = _mark
        price = _price
        number = _number
        lengthQueue = _lengthQueue
        numbersSameMark = _numbersSameMark
        requests = _requests
    }
    fun setLengthQueue(){
        this.lengthQueue = requests.size
    }
    fun setNumbersSameMark(petrolStations:Array<PetrolStation>){
        val arr = arrayListOf<Int>()
        for (elem in petrolStations){
            if (elem.mark == this.mark){
                arr.add(elem.number)
            }
        }
        this.numbersSameMark = arr
    }
    fun addRequests(req: Request){
        this.requests.add(req)
    }
}
