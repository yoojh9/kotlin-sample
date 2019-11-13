package license.exec

import license.code.*   // 패키지 수준(top-level)에 선언된 변수나 함수만 사용 가능
import license.code.LicenseKey  // 클래스만 임포트
import license.code.getCode // 함수 임포트 가능
import java.util.*

import license.code.getCode
import license.code.getLicenseKey
// import license.code.Code    // Code private class라 보이지 않음


internal fun printLicenseKey(lcKey: LicenseKey?, issuer:  String,
                             order: Int, desc: String){
    // null이 아닐 때만 함수 실행 (null일 경우에는 그냥 null)
    lcKey?.let { // 호출한 객체 자체가 인자로 들어감 (it)
        it.issuedWhen = Date()
        it.issuedBy = issuer
        it.issuedNumber = order
        it.description = desc

        it.generate()
        val br = "=".repeat(56)

        println("""
        |$br
        |       *** License Key ***
        |   issued by ${it.issuedBy} at ${it.issuedWhen}
        |   serial 0000${it.issuedNumber}
        |
        |   ${it.key}
        |   desc: ${it.description}
        |$br
        """.trimIndent())
    } ?: println("lckey is null !") // lcKey가 null일 때 실행됨

    // == lcKey.let({}) // 함수 타입의 인자
}

internal fun printLicenseKey2(lcKey: LicenseKey?, issuer:  String,
                             order: Int, desc: String){
    // with는 it이 없고 this만 있음.
    if(lcKey == null){
        println("lckey is null")
        return
    }

    with(lcKey){    // with 블록 내에서는 receiver가 들어가 있으므로 this가 이미 존재
        issuedWhen = Date()
        issuedBy = issuer
        issuedNumber = order
        description = desc

        generate()
        val br = "=".repeat(56)

        println("""
        |$br
        |       *** License Key ***
        |   issued by ${issuedBy} at ${issuedWhen}
        |   serial 0000${issuedNumber}
        |
        |   ${key}
        |   desc: ${description}
        |$br
        """.trimIndent())
    } ?: println("lckey is null !") // lcKey가 null일 때 실행됨

    // == lcKey.let({}) // 함수 타입의 인자
}

fun main(args: Array<String>) {
    printLicenseKey(null, "gildong", 1, "길동이 테스트 키")
    println()
    printLicenseKey(LicenseKey(), "alice", 2, "게임 앱 구매 키")
    println()
    printLicenseKey(LicenseKey(), "john", 3, "미디어 서버 설치 ")

    printLicenseKey2(null, "gildong", 1, "길동이 테스트 키")
    println()
    printLicenseKey2(LicenseKey(), "alice", 2, "게임 앱 구매 키")
    println()
    printLicenseKey2(LicenseKey(), "john", 3, "미디어 서버 설치 ")

}

// 패키지 수준(top-level 수준)에서는 함수, 클래스, 변수를 정의할 수 있다.
private val variable = 123
internal val stringx = "111"


//fun main(args: Array<String>) {
//    // val c1: Code = Code() // err
//    println(getCode(null, null))
//    println(getCode("start", null))
//    println(getCode("xyz", 16))
//
//    // internal val lc3 : String = "" // err : 로컬 변수나 로컬 함수에는 가시성(접근제한자)을 사용할 수 없다
//    // lc1, lc2 메인함수 안에 있는 로컬변수. 메인함수가 닫히는 순간 메모리에서 사라짐
//    val lc1 = getLicenseKey("WINBKR")   // count 4
//    val lc2 = getLicenseKey("GAME123", 6)
//
//    println("lc1 = ${lc1}")
//    println("lc2 = ${lc2}")
//}
