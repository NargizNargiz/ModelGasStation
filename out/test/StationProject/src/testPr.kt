import pack.Request
import pack.createSt
import java.io.File
import java.util.*

fun programRun1(s:String) {
    val steps = 144
//  инициализация модели: создали модель с наценкой и названием
    val firstTestModel = createSt(s)
    var generalQueue: Deque<Request> = ArrayDeque<Request>()
    val writer = File("somefile2.txt").bufferedWriter()
    var req: Request
    val segment = firstTestModel.getRandomSegment(1)
    println(segment)
    var newArr: Array<Int> = arrayOf<Int>()
    val k = segment.size
//    newArr.set(0, segment.first())
    segment.removeFirst()
    for (i in 1 until k){
        var f1 = 0
        var f2 = 0
        if (!segment.isEmpty()) {
            f1 = segment.first()
            segment.removeFirst()
        }
        if (!segment.isEmpty()){
            f2 = segment.first()
            segment.removeFirst()
        }
        newArr[i] = f1+f2
    }
    println(segment)
    println(newArr)
    firstTestModel.queueRequest(10, firstTestModel.getGasStation())
    generalQueue = firstTestModel.getGasStation().getNewRequest()
    generalQueue.forEach{ it.setfillTime(0.2777)}
    writer.write("AllRequets: \n")
    var globalTimer = 0
    var timer = 0
//    for (day in 0 until 7) {
//    for (i in 1 until steps) {
//        var sv: Int = 0
//        var segm: Int = 0
//        if (!segment.isEmpty()) {
//            segm = segment.first()
//            sv = segm + globalTimer
//        }
//        print("sv $sv, timer: $timer, globTimer: $globalTimer, ")
//
//        if (sv <= timer + 10){
//            if (!generalQueue.isEmpty()){
//                println("Время события: $sv, ОБРАБОТАНО")
//                firstTestModel.getGasStation().updatePetrolStationsQueues(10)
//                req = generalQueue.first()
//                // взяли первы запрос из очереди теперь поставить в нужную очередь
//                val markUp = firstTestModel.getMarkUp()
//                firstTestModel.getGasStation().allocRequests(req,markUp)
//                if (!generalQueue.isEmpty()) {
//                    generalQueue.removeFirst()
//                }
////                writer.write("Requets: \n")
////                firstTestModel.getGasStation().getArrPetrolStation().forEach{writer.write("${it.mark}: ${it.requests}\n")}
//                globalTimer += segm
//                timer+=10
//                if (!segment.isEmpty()) {
//                    segment.removeFirst()
//                }
//            }
//        }else{
//            println("Время события, которое не вошло в сегмент $sv")
//            val newSv = segment.first() - 10
//            if (!segment.isEmpty()) {
//                segment.removeFirst()
//            }
//            segment.addFirst(newSv)
//            globalTimer += 10
//            timer +=10
//            continue
//        }
//    }

//    }
    println()
    writer.close()
}
fun main(){
    programRun1("test")
}