package main

fun main(args: Array<String>) {
    val a = !true // => not()
            // -1
            // +1  => unaryPlus() 라는 함수가 연산자화 되어있음
    val b =  1.22 / 3 // 3.14f * 33 // 20L - 3 // 3 + 4
    val c = 21 % 10 // mod, rem
    // val c1 = 21.mod(10) // use rem instead
    val c2 = 21.rem(10)

    val e = (3.14f * 2 - 5) / 1.23

    // 우선 순위
    var f = 10
    f = f + 5
    f = f + 1
    f += 1  // += -= *= /= %=
    f++

    var g = 100
    g /= 10


    // 논리 관계 => if, when 조건식
    val h = 300 > 100
    val h2 = 200 < 200
    val h3 = 'A' == 'B'
    val h4 = 'x' != 'y'

    val i = 3 in 1..10  // range => contains()
    val i2 = 3 in intArrayOf(1,2,3,4,5) // array
    val j = 'A' !in listOf('X','Y','Z') // list

 }