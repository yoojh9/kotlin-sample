package main

fun main(args: Array<String>) {
    var a : String = "ABCD" // non-null type
    // a = null  // error
    var b : String? = "XYZ" // nullable type
    b = null

    println("a.length = ${a.length}")
    // println("b.length = ${b.length}")   // null 일수도?  // error
    println("b?.length = ${b?.length}") // safe call : null이 아닐 때만 뒤에를 참조하거나 호출함

    println("b.length의 길이 => ${
        if(b != null) b.length      // null이 아닌게 context 상 확인되었으므로 b?.length로 안해도 됨
        else "length를 알 수 없음"
    }")

    /**
     * Elvis Operator ?:
     */
    println("b?.length ?  = ${b?.length ?: "$b length를 알 수 없음"}")


    println(joinForm("홍길동", 33))
    println(joinForm(null, 30) ?: "가입 내용 누락")
}

/**
 * nullable 타입을 리턴하는 함수
 */
fun joinForm(name: String?, age: Int): String? {
    val result = if (name != null) "$name 가입 ($age 세)" else null  // if가 식으로 쓰임
    return result
}