package license.exec

import license.code.getCode
import license.code.getLicenseKey
// import license.code.Code    // Code private class라 보이지 않음

// 패키지 수준(top-level 수준)에서는 함수, 클래스, 변수를 정의할 수 있다.
private val variable = 123
internal val stringx = "111"


fun main(args: Array<String>) {
    // val c1: Code = Code() // err
    println(getCode(null, null))
    println(getCode("start", null))
    println(getCode("xyz", 16))

    // internal val lc3 : String = "" // err : 로컬 변수나 로컬 함수에는 가시성(접근제한자)을 사용할 수 없다
    // lc1, lc2 메인함수 안에 있는 로컬변수. 메인함수가 닫히는 순간 메모리에서 사라짐
    val lc1 = getLicenseKey("WINBKR")   // count 4
    val lc2 = getLicenseKey("GAME123", 6)

    println("lc1 = ${lc1}")
    println("lc2 = ${lc2}")
}