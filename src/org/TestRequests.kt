package org

import java.util.*
fun initArrReqs():Deque<Request>{
        var testReq : Deque<Request> = ArrayDeque<Request>()
        val r1= Request(800,0,MarkPetrol.A100)
        val r2= Request(200,0,MarkPetrol.A100)
        val r3= Request(900,0,MarkPetrol.A100)
        val r4= Request(900,0,MarkPetrol.A100)
        val r5= Request(300,0,MarkPetrol.A100)
        testReq.add(r1)
        testReq.add(r2)
        testReq.add(r3)
        testReq.add(r4)
        testReq.add(r5)
        testReq.forEach{ it.setfillTime(1.0)}
        return testReq
    }




