package main

fun getAbsoluteValue(num1: Int, num2: Int): Int {
    val result = if(num1 >= num2) num1 - num2
        else num2 - num1

    return result
}

fun getAbsoluteValue2(num1: Int, num2: Int): Int {
    return if(num1 >= num2) num1 - num2
    else num2 - num1
}


fun getAbsoluteValue3(num1: Int, num2: Int)
    = if(num1 >= num2) num1 - num2
        else num2 - num1


fun main(args: Array<String>) {

    println(getAbsoluteValue(10, 20))
    println(getAbsoluteValue2(-10, -10))
    println(getAbsoluteValue3(30, 10))

    var a: Int = 0
    a = 122
    a++

    if(true) {
        a = 200
        a--
    }

    if(false) a = -1
    println("a=${a}")

    if(a % 2 == 1)
        println("${a}는 odd number")
    else
        println("${a}는 even number")


    // 식 expression
    val numberType = if(a % 2 == 1) "$a 는 홀수" else { "$a 는 짝수" }

    println("numberType = ${numberType}")
}