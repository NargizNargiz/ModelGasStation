import org.*
import java.io.File
import java.util.*

// 0.28 л/c
fun createSt(name:String, markUp: Int, maxLenQue:Int, sizeGeneralQueue: Int): Model {
    val firstTestModel = Model(name, markUp)
    val generalQueue: Deque<Request>
//  создаем станцию
//    firstTestModel.maxLengthQueue = 3
    firstTestModel.setMaxLen(maxLenQue)
    firstTestModel.createGasStation()
    firstTestModel.queueRequests(sizeGeneralQueue, firstTestModel.getGasStation())
    generalQueue = firstTestModel.getGasStation().getNewRequests()
    generalQueue.forEach{ it.setfillTime(0.2777)}
    return firstTestModel
}

fun programRun1(s:String) {
    val sizeGeneralQueue = 14
    var countInputRequests: Int = 0
    val beginInterval = 3
    val endInterval = 15
//  инициализация модели: создали модель с наценкой и названием
   val firstTestModel = createSt(s,5,1,sizeGeneralQueue)
    countInputRequests += sizeGeneralQueue
    var segment = firstTestModel.getRandomSegment(beginInterval,endInterval)
    println(segment)
//    var generalQueue = firstTestModel.getGasStation().getNewRequests()
//    var generalQueue = initArrReqs()
    var generalQueue = firstTestModel.getGasStation().getNewRequests()
    val writer = File("somefile4.txt").bufferedWriter()
    writer.write("AllRequets: \n")
    generalQueue.forEach{writer.write("${it}\n")}
//    firstTestModel.getGasStation().getNewRequests().forEach{writer.write("${it}\n") }
    var timeGlob = 0
    var timeEvent = 0
    var step = 10
    val wholeTime = 10080
    var req :Request
    while(timeGlob <= wholeTime ){
        println("tg = $timeGlob, tr =  $timeEvent")
        if(!generalQueue.isEmpty()){
            if(!segment.isEmpty()){
                if (timeEvent+segment.first() <= timeGlob+step){
                    println ("Я взял из очереди запрос c временем ${timeEvent+segment.first()}. Это между $timeGlob и ${timeGlob+step}")
                    timeEvent+= segment.first()
                    req = generalQueue.first()
                    // взяли первы запрос из очереди теперь поставить в нужную очередь
                    val markUp = firstTestModel.getMarkUp()
                    firstTestModel.getGasStation().allocRequests(req,markUp)
                    generalQueue.removeFirst()
                    segment.removeFirst()
                }else{
                    firstTestModel.getGasStation().updatePetrolStations(step)
                    timeGlob+=step
                }
                myWriter(writer,firstTestModel.getGasStation())
            }else{
                segment = firstTestModel.getRandomSegment(beginInterval,endInterval)
                println(segment)
            }
        }else{
            println("Главная очередь пуста")
//            break
            firstTestModel.queueRequests(sizeGeneralQueue, firstTestModel.getGasStation())
            generalQueue = firstTestModel.getGasStation().getNewRequests()
            countInputRequests +=sizeGeneralQueue
        }
    }
    firstTestModel.getGasStation().updatePetrolStations(step)
    myWriter(writer,firstTestModel.getGasStation())
    firstTestModel.getGasStation().setSumAllProfits()
    firstTestModel.getGasStation().setNotServe(countInputRequests)
    writer.write(firstTestModel.getGasStation().toString())
    writer.close()
}

fun main(){
    programRun1("test")
}