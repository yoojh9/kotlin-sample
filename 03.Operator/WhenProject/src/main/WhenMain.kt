package main

fun calculateValue(op: String, first: Int, second: Int) {
    when(op) {
        "" -> println("op가 없음")
        "plus","+" -> println("$first + $second = ${first + second}")
        "minus","-" -> println("$first - $second = ${first - second}")
        "times","*", "x" -> println("$first * $second = ${first * second}")
        "divide","/" -> println("$first / $second = ${first / second}")   // 0으로 나누면 안됨
        "average","@" -> println("($first + $second) / 2.0 = ${(first + second) / 2.0}")
        else -> {
            println("${op}는 처리할 수 없는 연산")
            println("사칙연산, 평균만 계산 가능")
        }
    }
}


fun main(args: Array<String>) {
    var a = 123
    when (a) {
        is kotlin.Int -> println("a 타입은 Int.")
        123 -> println("a는 123임")       // 실행 안
    }

    when (a) {
        in 10..200 -> println("$a 가 범위 안에 있음")
        !is Int -> {
            println("a 타입 판정했으나..")
            println("a는 Int 타입이 아님.")
        }
        is kotlin.Int -> println("a 타입은 Int.")
        123 -> println("a는 123")
        else -> println("a는 어느 경우도 아님")
    }

    val s: String? = when {
        'z'.isDigit() -> "z는 숫자임"
        'z'.isLetter() -> "z는 문자임"
        else -> null
    }
    println("s  = ${s ?:"도달할 수 없음"}")


    calculateValue("", 3, 4)
    calculateValue("+", 3, 4)
    calculateValue("minus", 300, 200)
    calculateValue("*", 99, 2)
    calculateValue("sum", 100,2)
    calculateValue("@", 60,40)
    println()
    println()

}