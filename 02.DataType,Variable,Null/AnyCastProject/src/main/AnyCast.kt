package main

fun main(args: Array<String>) {
    val a: Any = 1234   // kotlin.Any는 최상위 타입 클래스 -> Java Object
    val a2: Any = 'A'
    var a3: Any = "xyz"
    a3 = 3.141592
    a3 = true   // boolean

    val b1 = 365
    val b2 = b1 is Int  // is : type check 연산자 -> java instanceOf 와 흡사

    println("b1 is Int = ${b1 is Int}, b2 = ${b2}")
    println("a is Int = ${a is Int}")
    println("a2 is Char = ${a2 is Char}")
    println("a3 is Boolean = ${a3 is Boolean}")
    println("a3 !is String = ${a3 !is String}")

    if(a2 is Char) println("$a2 is type Char")

    val c1 = 123
    val c2 = 123L
    val c3: Byte = 123
    val c4: Short = 123

    println("c1.javaClass = ${c1.javaClass} ${c1 is Int}")
    println("c2.javaClass = ${c1.javaClass} ${c2 is Long}")
    println("c3.javaClass = ${c3.javaClass} ${c3 is Byte}")
    println("c4.javaClass = ${c4.javaClass} ${c4 is Short}")
}