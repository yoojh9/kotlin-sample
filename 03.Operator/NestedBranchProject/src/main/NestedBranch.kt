package main

// 16진수 문자를 10진수 숫자로 바꿔주는 함수
// 0 ~ 15 ( 0 ~ 9, A 10 B 11 C 12 D 13 E 14 F 15)
fun convertCharToHex(ch: Char): Int {
    var result : Int = -1

    if(ch in '0'..'9' || ch in 'A'..'F' || ch in 'a'..'f') {
        when {
            ch.isDigit() -> result = ch.toInt() - '0'.toInt()    // '0'의 아스키코드 값은 48
            ch.isLetter() -> {
                result = if (ch.isUpperCase())
                    ch.toInt() - 'A'.toInt()
                else
                    ch.toInt() - 'a'.toInt()
                result += 10
            }
            else -> println("$ch 에러!")
        }
    }
    else println("$ch 16진수 심볼 문자 아님")
    return result
}

fun main(args: Array<String>) {

    val input = args[0] // "f4D8" -> 'f', '4', 'D', '8'
    println("input[0] => ${convertCharToHex(input[0])}")
    println("input[1] => ${convertCharToHex(input[1])}")
    println("input[2] => ${convertCharToHex(input[2])}")
    println("input[3] => ${convertCharToHex(input[3])}")

    for(ch in input){
        println("${ch} => ${convertCharToHex(ch)}")
    }

    println("@ => ${convertCharToHex('@')}")
    println("0 => ${convertCharToHex('0')}")
    println("3 => ${convertCharToHex('3')}")
    println("7 => ${convertCharToHex('7')}")
    println("A => ${convertCharToHex('A')}")
    println("e => ${convertCharToHex('e')}")
    println("F => ${convertCharToHex('F')}")
    println("Q => ${convertCharToHex('Q')}")
    println()

    val z = 33
    when {
        false -> println("3 > 4 false")
        1 == 1 -> when(z) {
            in 30..33 -> println("z in 포함됨")
            else -> println("z not in.")
        }
        else -> println("none")
    }
}