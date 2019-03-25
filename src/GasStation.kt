import java.util.*
import kotlin.collections.ArrayList

class GasStation(var _name: String){
    private var name: String = _name
    private var newRequests: Queue<Request> = ArrayDeque<Request>()
    private var arrayPetrolStation: ArrayList<PetrolStation> = arrayListOf()
    private var countServed: Int = 0
    private var countNotServe: Int = 0

    constructor(_name: String, _newRequests: Queue<Request>,
                _arrayPetrolStation: ArrayList<PetrolStation>,
                _countServed: Int,
                _countNotServe: Int):this(_name){
        newRequests = _newRequests
        arrayPetrolStation = _arrayPetrolStation
        countServed = _countServed
        countNotServe = _countNotServe
    }
    fun setNewRequest(requests: Queue<Request>){
        newRequests = requests
    }
    fun addNewRequest(req: Request){
        newRequests.add(req)
    }
    fun createPetrolStations(petrolStations: ArrayList<PetrolStation>){
        arrayPetrolStation = petrolStations
    }
    fun addPetrolStation(petrolStation: PetrolStation){
        arrayPetrolStation.add(petrolStation)
    }
    fun incCountServed(){
        countServed++
    }
    fun incNotServe(){
        countNotServe++
    }
}