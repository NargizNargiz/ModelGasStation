package org

import kotlin.random.Random

enum class MarkPetrol(val mark: Int) {
    UNDEFINED(0), A80(1), A90(2), A92(3), A95(4), A98(5), A100(6);

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
    fun getMarkFromString(str: String):MarkPetrol{
        when(str){
            "A90" -> return A90
            "A80" -> return  A80
            "A92" -> return A92
            "A95" -> return A95
            "A98" -> return A98
            "A100" -> return A100
            else -> return UNDEFINED
        }
    }
}