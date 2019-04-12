package org

import java.util.*

data class GasStation(private var name: String,
                      private var newRequests: Deque<Request> = ArrayDeque<Request>(),
                      private var arrayPetrolStation: ArrayList<PetrolStation> = arrayListOf(),
                      private var countServed: Int = 0,
                      private var countNotServe: Int = 0,
                      private var profit: Double = 0.0,
                      private var maxLengthQueue: Int = 5){
     // max length of queue
    fun setNewRequests(requests: Deque<Request>){
        newRequests = requests
    }
    fun getNewRequests():Deque<Request>{
        if (newRequests.isEmpty()) {
            println("Ошибка общая очередь заявок пуста")
        }
        return newRequests
    }
    fun setMaxLen(maxLen: Int){
        maxLengthQueue = maxLen
    }
    fun incProfit(money: Int){
        profit += money
    }
    fun createPetrolStations(petrolStations: ArrayList<PetrolStation>){
        arrayPetrolStation = petrolStations
    }
    fun addPetrolStation(petrolStation: PetrolStation){
        arrayPetrolStation.add(petrolStation)
    }
    fun getArrPetrolStation():ArrayList<PetrolStation>{
        return arrayPetrolStation
    }
    fun incCountServed(reqs: Int){
        countServed += reqs
    }
    fun setNotServe(count: Int){
        countNotServe = count - countServed
    }
    fun chosePetrolStation(listFreeStations: List<PetrolStation>) = listFreeStations.minBy { it.lengthQueue }

    fun allocRequests(req: Request, markUp: Int) {
        // если одна очередь уже заполнена
        val findPetrolStation = arrayPetrolStation.find { it.mark == req.mark } ?: PetrolStation(MarkPetrol.UNDEFINED, 0)
        if (findPetrolStation.mark != MarkPetrol.UNDEFINED){
//            println(findPetrolStation)
//            println(findPetrolStation.lengthQueue)
//            println(findPetrolStation.quequeIsFull(maxLengthQueue))
//            println(findPetrolStation.requests)
            if (!findPetrolStation.quequeIsFull(maxLengthQueue)){
                for (elem in this.arrayPetrolStation){
                    if (findPetrolStation.number == elem.number) {
                        req.setPriceMarkUp(markUp,elem.price)
                        elem.addRequests(req)
                        break
                    }
                }
            }else{
                val freePetrolStations = arrayPetrolStation.filter{
                    it.number in findPetrolStation.getNumberSameMark() &&
                    !it.quequeIsFull(maxLengthQueue)
                }
                freePetrolStations.forEach { println("$it, ${it.number}") }
                if (!freePetrolStations.isEmpty()){
                    val finalStation = chosePetrolStation(freePetrolStations)
                    if (finalStation != null){
                        val num = finalStation.number
                        arrayPetrolStation[num-1].addRequests(req)
                        println(arrayPetrolStation[num-1].lengthQueue)
                    }
                }
            }
        } else {
            println("Ошибка, такого типа бензина нет : ${req.mark}")
        }
    }
    fun updatePetrolStationsQueues(time:Int){
        for (station in arrayPetrolStation){
            if (station.processRequest(time)){
                incCountServed(1)
            }
        }
    }
    fun newUpd(time:Int){
        println("newUpd")
        for (station in arrayPetrolStation){
            incCountServed(station.processReqs(time))
        }
    }

    fun getCountServed():Int{
        return countServed
    }
    fun getNotServed():Int{
        return countNotServe
    }
    fun setSumAllProfits(){
        profit =  arrayPetrolStation.sumByDouble{ it.profitStation }
    }
    fun getProfit():Double{
        return profit
    }
}
