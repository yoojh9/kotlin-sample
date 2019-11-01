package main

fun main(args: Array<String>) {
    // Array(n, {fun})  n 개의 요소를 가진 배열을 생성할건데, fun 함수를 적용해서 초기화를 할거다.
    // 람다식, 함수파라미터
    // (초기화하는) 팩토리 함수를 통해서 각 요소를 초기화한다.
    val a = Array(2, {0} )  // 0,0

    // Generic : (타입을 제한하는) 타입 파라미터, 타입 제한 인자
    val b = Array<Char>(3, {'_'}) // Array<T> _,_,_
    val c = Array<Int?>(4, {null})
    val d: Array<String> = args

    println("a.size = ${a.size}  b.size = ${b.size}  c.size = ${c.size}  d.size = ${d.size}")
    println("a.get(0) = ${a.get(0)}  b.get(0) = ${b.get(0)}  c.get(0) = ${c.get(0)}" )

    // [] brackets, get(), set()
    a.set(0, 33)
    b.set(0, 'A')
    c.set(0, 123)

    a[0] = 55
    a[1] = 66
    println("a[0] = ${a[0]}  b[0] = ${b[0]}  c[0] = ${c[0]}")

    println("array a = ${a}")
    println("array a = ${a.joinToString(",")}")


    /**
     * 표준 라이브러리 함수
     */
    val f1 = arrayOf<String>("apple", "banana", "orange")
    val f2 : Array<String> = Array(3, {"_"})        // "_"로 초기화 된 배열
    // f2[2] = "plum"
    f2[f2.size -1] = "plum"
    f2[f2.lastIndex] = "last plum"
    val fruitsArray = f1 + f2

    // spread 연산자: 펼침 연산자
    val fruitsArray2 = arrayOf<String>(*f1, *f2)    // f1, f2 배열을 붙여서 새로운 배열을 만들어줌
    println("fruitsArray = ${fruitsArray.joinToString(", ")}")

    val e = arrayOfNulls<String>(3) // null로 초기화 시켜줌
    println("e[0] = ${e[0]}")


    val eng = charArrayOf('A','B','C','D','E')  // CharArray
    val prices = intArrayOf(100, 200, 300)
    val temps = floatArrayOf(3.14f, 3.22f)

    val trueFalse = booleanArrayOf(true, false, true)
    val trueFalse2 = BooleanArray(4, {true})
    trueFalse2[1]=false

    // shortArrayOf()
    // byteArrayOf()
    // intArrayOf()
    // longArrayOf()
    // floatArrayOf()
    // doubleArrayOf()
    // booleanArrayOf()
    // charArrayOf()
}