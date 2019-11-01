package main

/*
    ShortArrayOf()      <=>     ShortArray
    byteArrayOf()       <=>     ByteArray
    intArrayOf()        <=>     IntArray
    longArrayOf()       <=>     LongArray
    floatArrayOf()      <=>     FloatArray
    doubleArrayOf()     <=>     DoubleArray
    booleanArrayOf()    <=>     BooleanArray
    charArrayOf()       <=>     CharArray
*/

fun main(args: Array<String>) {
    val iceCreams = intArrayOf(1000, 2000, 4500, 9000, 14000, 20000)

    // val coffeeCups = IntArray(3, {i -> i * 2000 + 1000})
    val coffeeCups = IntArray(3) { i -> i * 2000 + 1000} // i 0,1,2 => 1000, 3000, 5000

    val sweetDonuts = IntArray(4)
    sweetDonuts.fill(990, 0,4)

    printPrice("iceCream", iceCreams)
    printPrice("coffeeCups", coffeeCups)
    printPrice("sweetDonuts", sweetDonuts)

    /**
     * index
     */
    println()
    var index = 0
    for(ic in iceCreams){
        println("ic[$index] => $ic")
        index += 1
    }
    println()
    for(i in iceCreams.indices) // i => 0..5
        println("ic[$i] => ${iceCreams[i]}")

    /**
     * last(), first()
     */
    println()
    println("iceCreams[0] = ${iceCreams[0]}")
    println("iceCreams[iceCreams.size-1] = ${iceCreams[iceCreams.size-1]}")
    println("iceCreams.first() = ${iceCreams.first()}")
    println("iceCreams.last() = ${iceCreams.last()}")


    /**
     * sum
     */
    var ccSum = 0
    println()

    // withIndex()
    for( (i,cc) in coffeeCups.withIndex()){
        println("cc[$i] = ${cc}")
        ccSum += cc
    }
    println("coffeCups Sum = ${ccSum} won")
    println("coffeCups Sum = ${coffeeCups.sum()} won")


    println()   // 합 평균
    var sdSum: Double = 0.0
    for ( (i, sd) in sweetDonuts.withIndex()){
        println("sd[$i] = $sd")
        sdSum += sd
    }
    println("sdSum = ${sdSum}, ${sweetDonuts.sum()}")
    println("sweetDonuts Avg = ${sdSum / sweetDonuts.size}, ${sweetDonuts.average()}")


    /**
     * filter, find
     */
    for ((i, ic) in iceCreams.withIndex()) {
        if( ic > 5000 ) println("expensive $i = ${ic}")
    }

    // 배열의 요소를 필터링 함.
    println("iceCreams.filter{ it } = ${iceCreams.filter { it > 5000 }}")  // 람다 블럭. 배열의 요소를 하나하나 가져와서 조건식에 맞는 데이터를 필터링함.
    println()

    // 조건에 맞는 첫번째 요소를 찾음
    println("iceCreams.find {  } = ${iceCreams.find { it > 5000 }}")
}

fun printPrice(product: String, prices: IntArray) {
    println("$product.size = ${prices.size}, $product = ${prices.joinToString(", ")} ")
}