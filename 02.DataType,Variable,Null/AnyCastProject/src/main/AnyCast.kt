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
    println()


    val c5: Any = c3
    println("c5.javaClass = ${c5.javaClass} ${c5 is Byte}")


    val c6: Any = c3 + 1
    println("c6.javaClass = ${c6.javaClass} ${c6 is Int}")

    val c7: Any = c3 + 1L
    println("c7.javaClass = ${c7.javaClass} ${c7 is Long}")


    val d1: Byte = c5 as Byte   // cast 타입을 강제 변환 c5가 Byte로 형변환이 되지 않을 시 에러 발생
    // val d2: Int = c5 as Int     // classCastException 예외 발생. Byte -> Int 자동형변환 안됨

    val d3: Int = d1.toInt()    // 명시적으로 Byte -> Int로 변환됨
    val d4: Short = d1.toShort()
    val d5: Long = d1.toLong()
    val d6: Float = d1.toFloat()
    val d7: Double = d1.toDouble()
    val d8: Char = d1.toChar()  // Byte값을 유니코드 코드 값으로 가지고 있는 값이 나옴
    val d9: String = d1.toString()

    println("d3 = ${d3}")
    println("d4 = ${d4}")
    println("d5 = ${d5}")
    println("d6 = ${d6}")
    println("d7 = ${d7}")
    println("d8 = ${d8}")
    println("d9 = ${d9}")


    // 타입을 체크해서 그 값이 확실하게 바뀔 수 있을 때만 as를 쓰고 보통 to를 사용하여 다른 자료형으로 명시적으로 변환시키는 것을 권장함.

}