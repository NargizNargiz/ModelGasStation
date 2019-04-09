package pack

import kotlin.math.round

fun threadRequest(day: Int, i : Int, avgPrice: Double):Int{
    val k1 = day
    val k2 = i
    val k3 = 1/avgPrice
//    print("koef ${k1*k2*k3}")
    var h = 0;
    var m = 10*i
    var mm = m%60
    h = m/60
    print("day : $day, hours: $h, minuts $mm ")
    var result = 0.0
    if ((h >=1) and (h<=7)) {
        result = (day*h)/8.0
    }else
        if( (h>7) and (h<=14)){
            result = (day*h)/2.0
        }else {
            if ((h>14 ) and (h <=19)){
                result = (day*h)/4.0
            }else
                result=(day*h)/2.0
        }
    result = result/avgPrice
    print("без нормализации: $result ")
    val norm = result/10 + 1
    println("с нормализацие: $norm")
    return round(k1*k2*k3).toInt()
}
fun main(){
    val steps = 144
//    for (day in 0 until 8){
        for( i in 1 until steps+1) {
            threadRequest(5,i,10.0)
    }
}