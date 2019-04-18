package packageGui
import javax.swing.*
import java.awt.*


import java.util.HashMap
var mapPrices: HashMap<String,String> = HashMap<String,String>()
var mapCounts: HashMap<String,String> = HashMap<String,String>()
var mapDataFromFields: HashMap<String,String> = HashMap<String,String>()

fun saveData(data: String, map : HashMap<String,String>){
    when (data){
        "price" -> mapPrices = map
        "counts" ->  mapCounts = map
        "data" -> mapDataFromFields=map
    }
}
fun printData(){
    println("This is common information of station")
    for (k in mapDataFromFields.keys){
        println("$k - ${mapDataFromFields[k]} ")
    }

    println("This is counts's every petrolstation")
    for (k in mapCounts.keys){
        println("$k - ${mapCounts[k]} ")
    }
    println("This is prices's every petrolstation")
    for (k in mapPrices.keys){
        println("$k - ${mapPrices[k]} ")
    }
}
fun myRun(frame: MyGui){
    val arr = arrayListOf<Int>(1,4,3,2,54)
    frame.putDataInTable(arr)
}
fun func(){

}