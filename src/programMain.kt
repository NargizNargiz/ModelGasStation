import kotlin.random.Random
import kotlin.math.round
fun threadRequest(day: Int, hours: Int, avgPrice: Double):Int{
    val k1 = day
    val k2 = hours
    val k3 = 1/avgPrice
    //print("koef ${k1*k2*k3}")
    return round(k1*k2*k3).toInt()
}
fun main() {
    val steps = 144
    var firstTestModel: Model = Model("testModel1", 5, 3)
//    println(firstTestModel.getRandomSegment(2))
//    println(firstTestModel.getRandomVolume())
    val markRandomTest: MarkPetrol = MarkPetrol.UNDEFINED
//    println(markRandomTest.getRandom())
    val l = firstTestModel.queueRequest(5)
    l.forEach { it.println() }
    var hours: Int
    for (day in 0 until 7) {
        hours = 1
        for (i in 1 until steps) {
            if (i % 6 == 0) {
                hours += 1
                println("hours $hours, day $day")
                println(threadRequest(day,hours,14.5))
            }
        }
        println()
    }
}