import kotlin.random.Random
import kotlin.math.round
fun main(){
    var firstTestModel: Model = Model("testModel1",5,3)
    println(firstTestModel.getRandomSegment(2))
    println(firstTestModel.getRandomVolume())
    val markRandomTest: MarkPetrol = MarkPetrol.UNDEFINED
    println(markRandomTest.getRandom())
}