package pack

import java.io.*
import java.util.*
import kotlin.math.round
import exampleGui

// 0.28 л/c
fun createSt(name:String): Model {
    val firstTestModel: Model = Model(name, 3)
//  создаем станцию
    firstTestModel.maxLengthQueue = 2
    firstTestModel.createGasStation()
    return firstTestModel
}
fun myWriter(writer: BufferedWriter,gasSt: GasStation){
    writer.write("Arrays of same mark's number: \n")
    gasSt.getArrPetrolStation().forEach{writer.write("${it.mark}: ${it.getNumberSameMark()}\n")}
    gasSt.getArrPetrolStation().forEach{writer.write("${it.mark}: ${it.number}\n")}
    writer.write(gasSt.maxLengthQueue.toString())
    writer.newLine()
//    writer.write(gasSt.getCountServed())
//    writer.newLine()
//    writer.write(gasSt.getNotServed())
    writer.write("Requets: \n")
    gasSt.getArrPetrolStation().forEach{writer.write("${it.mark}: ${it.requests}\n")}
    writer.write(gasSt.getArrPetrolStation().toString())
}

fun programRun(s:String) {
    val steps = 144
//  инициализация модели: создали модель с наценкой и названием
    val firstTestModel = createSt(s)
    var generalQueue: Deque<Request> = ArrayDeque<Request>()
    val writer = File("somefile.txt").bufferedWriter()
    var req: Request
    println(firstTestModel.getRandomSegment(2))
    firstTestModel.queueRequest(15, firstTestModel.getGasStation())
    generalQueue = firstTestModel.getGasStation().getNewRequest()
    generalQueue.forEach{ it.setfillTime(0.2777)}
    writer.write("AllRequets: \n")
    firstTestModel.getGasStation().getNewRequest().forEach{writer.write("${it}\n") }

//    for (day in 0 until 7) {
        for (i in 1 until steps) {
            // i = i*10 minuts
            // высчитываем плотность потока = кол-во заявок каждые 10 минут(1 час)
            // берем одну заявку - смотрим в какой ее автомат отправлять - отправляем
            // проверяем время на остальных
            // проверка очередей

            if (!generalQueue.isEmpty()){
                firstTestModel.getGasStation().updatePetrolStationsQueues(10)
                req = generalQueue.first()
                // взяли первы запрос из очереди теперь поставить в нужную очередь
                val markUp = firstTestModel.getMarkUp()
                firstTestModel.getGasStation().allocRequests(req,markUp)
                if (!generalQueue.isEmpty()) {
                    generalQueue.removeFirst()
                }
                writer.write("Requets: \n")
                firstTestModel.getGasStation().getArrPetrolStation().forEach{writer.write("${it.mark}: ${it.requests}\n")}
            }
        }

//    }
    println()
    firstTestModel.getGasStation().updatePetrolStationsQueues(10)
    writer.write("result: \n")
    firstTestModel.getGasStation().getArrPetrolStation().forEach{writer.write("${it.mark}: ${it.requests}\n")}
//    myWriter(writer,firstTestModel.getGasStation())
    println(firstTestModel.getGasStation().getCountServed())
    firstTestModel.getGasStation().setSumAllProfits()
    writer.newLine()
    println(firstTestModel.getGasStation().getNotServed())
    writer.write(firstTestModel.getGasStation().getProfit().toString())
    writer.close()
}
fun main(){
    programRun("test")
}