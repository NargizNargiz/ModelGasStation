package org

import finalVersion.Model
import finalVersion.MarkPetrol.A90
import finalVersion.Request
import java.util.*
import kotlin.math.round
import kotlin.random.Random

fun initArrReqs():Deque<Request>{
        var testReq : Deque<Request> = ArrayDeque<Request>()
        val r1= Request(800, 0, A90, index = 1)
        val r2= Request(200, 0, A90, index = 2)
        val r3= Request(900, 0, A90, index = 3)
        val r4= Request(900, 0, A90, index = 4)
        val r5= Request(300, 0, A90, index = 5)
        val r6= Request(300, 0, A90, index = 6)
        val r7= Request(300, 0, A90, index = 7)
        val r8= Request(300, 0, A90, index = 8)
        testReq.add(r1)
        testReq.add(r2)
        testReq.add(r3)
        testReq.add(r4)
        testReq.add(r5)
        testReq.add(r6)
        testReq.add(r7)
        testReq.add(r8)
        testReq.forEach{ it.setfillTime(1.0)}
        return testReq
    }
fun setRandomSegment1(a: Int, b:Int):Deque<Int>{
        val n = 15
        val res  = ArrayDeque<Int>()
        var valS: Double
        var value: Double
        for (i in 0 until n){
                val randomValues = List(12){ Random.nextDouble(0.0, 1.0)}
                        .map { round(it*1000) /1000 }
                valS = randomValues.sum()
                value = a + (b-a)*(valS-6)
                if (value.toInt() > 0 && value >a && value <=b) {
                        res.add(value.toInt())
                }
        }
//        segment = res
        return res
}
fun main(){
        println(setRandomSegment1(3,11))
        println(setRandomSegment1(1,11))
        println(setRandomSegment1(2,11))
        println(setRandomSegment1(5,11))
        println(setRandomSegment1(8,11))

}


