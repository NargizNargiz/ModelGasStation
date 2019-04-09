package pack

import kotlin.random.Random

enum class MarkPetrol(val mark: Int) {
    UNDEFINED(0), A80(1), A92(2), A95(3), A98(4), A100(5), A101(6), A102(7);

    fun getRandom(): MarkPetrol {
        val random: Random = Random
        var res = values()[random.nextInt(values().size)]
        if (res == UNDEFINED){
            while(res == UNDEFINED) {
                res = values()[random.nextInt(values().size)]
            }
        }
        return res
    }
}