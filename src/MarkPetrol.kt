import kotlin.random.Random
import kotlin.math.round
enum class MarkPetrol(val mark: Int) {
    UNDEFINED(0), A80(1), A92(2), A95(3), A98(4), A100(5), A101(6), A102(7);

    fun getRandom(): MarkPetrol {
        val random: Random = Random
        val res = values()[random.nextInt(values().size)]
        if (res == UNDEFINED){
            return  values()[random.nextInt(values().size)]
        }else
            return res
        }
}