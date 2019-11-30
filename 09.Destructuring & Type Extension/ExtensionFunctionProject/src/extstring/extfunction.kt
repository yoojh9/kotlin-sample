package extstring

import java.lang.Math.random
import java.nio.charset.Charset
import java.security.MessageDigest


// 정수 수치형의 확장
fun Int.code(): String { // Receiver type
    val c = ('A'..'Z').toList().joinToString("") +
            ('0'..'9').toList().joinToString("")
    var s = ""

    for(i in 1..this){
        s += c[ (random() * c.length).toInt() ]
    }
    return s
}

fun Int.code2(): String { // Receiver type
    val c = ('A'..'Z').toS() +
            ('0'..'9').toS()
    var s = ""

    for(i in 1..this){
        s += c[ (random() * c.length).toInt() ]
    }
    return s
}

// 문자 범위형의 확장 : 모든 문자 range가 문자열로 리턴됨
fun CharRange.toS() : String
        = this.toList().joinToString("")

// 기본형 Byte 확장 - unsigned byte 흉내
fun Byte.toUnsignedInt() = this.toInt() and 0x000000FF // 최하위 비트만 unsigned로 남겨
// fun Byte.toUnsignedInt() = toInt() and 0xFF

// 문자열형 확장 => hash 코드 함수로 확장
// MD5, SHA-1, SHA-256
fun String.hash(algo: String = "MD5"): String {
    val ds = MessageDigest.getInstance(algo)
    ds.update(this.toByteArray())
    return ds.digest().map{ it.toUnsignedInt().toString(16).toUpperCase() }
            .joinToString("") // it은 byte
}

fun String.mask(target: String = " ", using: String): String
        = this.replace(target, using.hash())    // MD5

fun main() {
    println("6.code() = ${6.code()}")
    println("12.code() = ${12.code()}")
    println("6.code2() = ${6.code2()}")
    println("12.code2() = ${12.code2()}")

    println("kotlin is good! => (md5) ${"kotlin is good!".hash()}")
    println("kotlin is good! => (sha-1) ${"kotlin is good!".hash("SHA-1")}")
    println("kotlin is good! => (sha-256) ${"kotlin is good!".hash("SHA-256")}")

    println("""
        |Kotlin provides the ability to extend a class 
        |with new functionality without having to inherit 
        |from the class or use design patterns such as Decorator. 
        |This is done via special declarations called extensions. 
        |For example, you can write new functions for a class from a third-party library 
        |that you can't modify. 
    """.trimMargin()
        .mask("Kotlin", "jetbrain") // "Kotlin"을 "jetbrain"이 MD-5로 마스킹 된 단어로 변경해라
        .mask("extension","good")
        .mask("function", "wow")
    )
}