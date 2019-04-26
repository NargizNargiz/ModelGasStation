package finalVersion

import java.util.*

data class GasStation(private var name: String,
                      private var arrayPetrolStation: ArrayList<PetrolStation> = arrayListOf(),
                      private var countServed: Int = 0,
                      private var countNotServe: Int = 0,
                      private var profit: Double = 0.0,
                      private var maxLengthQueue: Int = 5) {
    private var volumeSold: Double = 0.0

    fun setMaxLen(maxLen: Int){
        maxLengthQueue = maxLen
    }
    fun setCountServe(c: Int){
        countServed = c
    }
    fun setProfit(c: Double){
        profit = c
    }
    fun getVolume():Double{
        return volumeSold
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
        countNotServe = count
    }
    private fun chosePetrolStation(listFreeStations: List<PetrolStation>) = listFreeStations.minBy { it.lengthQueue }

    fun allocRequests(req: Request, markUp: Int) {
        // если одна очередь уже заполнена
        val findPetrolStation = arrayPetrolStation.find { it.mark == req.mark } ?: PetrolStation(
            MarkPetrol.UNDEFINED,
            0
        )
        if (findPetrolStation.mark != MarkPetrol.UNDEFINED){
            if (!findPetrolStation.quequeIsFull(maxLengthQueue)){
                for (i in 0 until arrayPetrolStation.size){
//                for (elem in this.arrayPetrolStation){
//                    if (findPetrolStation.number == elem.number) {
                        if (findPetrolStation.number == arrayPetrolStation[i].number) {
                        req.setPriceMarkUp(markUp,arrayPetrolStation[i].price)
                        arrayPetrolStation[i].addRequests(req)
//                        println("произошла аллокация : ${arrayPetrolStation[i].requests}")
                        break
                    }
                }
            }else{
                val freePetrolStations = arrayPetrolStation.filter{
                    it.number in findPetrolStation.getNumberSameMark() &&
                    !it.quequeIsFull(maxLengthQueue)
                }
//                freePetrolStations.forEach { println("$it, ${it.number}")}
                if (freePetrolStations.isNotEmpty()){
                    val finalStation = chosePetrolStation(freePetrolStations)
                    if (finalStation != null){
                        val num = finalStation.number
                        arrayPetrolStation[num-1].addRequests(req)
//                        println(arrayPetrolStation[num-1].lengthQueue)
                    }else{
                        //если не найдены свободные колонки, машина уезжает, увеличиваем кол-во не обработанных заявок
                        this.countNotServe++
                        println(" countNotServe = $countNotServe")
                    }
                }else{
                    this.countNotServe++
                    println(" countNotServe = $countNotServe")
                }
            }
        } else {
            println("Ошибка, такого типа бензина нет : ${req.mark}")
        }
    }
    fun updatePetrolStations(time:Int){
        for (station in arrayPetrolStation){
            incCountServed(station.processReqs(time))
            setVolume()
        }
    }

    fun getCountServed():Int{
        return countServed
    }
    fun getNotServed():Int{
        return countNotServe
    }
    fun setVolume(){
        volumeSold = arrayPetrolStation.sumByDouble { it.soldGasoline }
    }
    fun setSumAllProfits(){
        profit =  arrayPetrolStation.sumByDouble{ it.profitStation }
    }
    fun getProfit():Double{
        return profit
    }
    fun getInfo(mark:MarkPetrol):String{
        val pump = arrayPetrolStation.find { it.mark == mark }
        var res: String
        res ="Количество очередей: ${pump!!.getNumberSameMark().size + 1} \n"
        res += "Цена: ${pump.price} \n"
        var value = 0.0
        for(elem in arrayPetrolStation){
            if (elem.mark ==pump.mark){
                value += elem.profitStation
            }
        }
        res += "Прибыль: $value\n"
        value = 0.0
        for(elem in arrayPetrolStation){
            if (elem.mark ==pump.mark){
                value += elem.soldGasoline
            }
        }
        res += "Объем проданного бензина: $value\n"
        return res
    }

}
