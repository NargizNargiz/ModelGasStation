package finalVersion

import kotlin.random.Random

enum class MarkPetrol(val mark: Int) {
    UNDEFINED(0), A80(1), A90(2), A92(3), A95(4), A98(5), A100(6);

    fun getRandom(): MarkPetrol {
        val random= Random
        var res = values()[random.nextInt(values().size)]
        if (res == UNDEFINED){
            while(res == UNDEFINED) {
                res = values()[random.nextInt(values().size)]
            }
        }
        return res
    }
    fun getMarkFromString(str: String): MarkPetrol {
        return when(str){
            "A80" -> A80
            "A90" -> A90
            "A92" -> A92
            "A95" -> A95
            "A98" -> A98
            "A100" -> A100
            else -> UNDEFINED
        }
    }
}