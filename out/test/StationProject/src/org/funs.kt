package org

import java.io.*
import finalVersion.GasStation

fun myWriter(writer: BufferedWriter,gasSt: GasStation){
//    writer.write("Arrays of same mark's number: \n")
//    gasSt.getArrPetrolStation().forEach{writer.write("${it.mark}: ${it.getNumberSameMark()}\n")}
//    gasSt.getArrPetrolStation().forEach{writer.write("${it.mark}: ${it.number}\n")}
//    writer.write(gasSt.maxLengthQueue.toString())
    writer.newLine()
//    writer.write(gasSt.getCountServed())
//    writer.newLine()
//    writer.write(gasSt.getNotServed())
    writer.write("Requets: \n")
    gasSt.getArrPetrolStation().forEach{writer.write("${it.mark}: ${it.requests}\n")}
    writer.write("served: ${gasSt.getCountServed()}\n")

//    writer.write(gasSt.getArrPetrolStation().toString())
}
