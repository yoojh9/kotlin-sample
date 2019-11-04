package main

// Range <==> Array
fun main(args: Array<String>) {
    val naturalNumbers = 1..100 // 1,2,3,...100 상하 경계값 포함

    val r = 1..99+1
    val r2 = IntRange(1,100) // 범위 빌더 클래스
    val arr1: IntArray = r.toList().toIntArray()
    val arr2: Array<Int> = r.toList().toTypedArray()    // toTypedArray(): Array<T>으로 반환해줌

    val r3 = 100..200   // .. : rangeTo()
    val r4 = 100 until 200  // 200 미포함 , until(): 끝 경계를 포함하지 않는 range

    val r5 = 200 downTo 100 // 100 포함, -1씩
    val r6 = (200 downTo 100).step(20) // 100 포함, -20씩
    println("r5.joinToString(\", \") = ${r5.joinToString(", ")}")
    println("r6.joinToString(\", \") = ${r6.joinToString(", ")}")

    println("r3.last = ${r3.last} r4.last = ${r4.last} r5.last = ${r5.last}")
    println()

    /**
     * 짝수 구하기
     */
    for(number in 1..20)
        if(number % 2 == 0) println("even number = ${number}")

    // Long형의 range
    for(number2 in 2L..20L step 2L)
        println("long even number = ${number2}")

    println("(1..20).filter{ it % 2 == 0 = ${(1..20).filter{ it % 2 == 0 }}")


    // range도 배열처럼 withIndex()를 사용할 수 있다. 단 indices는 범위에는 없다.
    for( (i,n) in (51..80 step 4).withIndex() )
        println("i = ${i}번째 값 => $n")


    // 구구단
    printGuGuDan()

    sumOfBetweenInts(1,10)
}

fun printGuGuDan(){
    for(i in 2..9) {
        println("--- ${i} 단 ---")
        for (j in 1..9)
            println("$i x $j = ${i * j}")
    }
}

// 두 정수 사이의 합
fun sumOfBetweenInts(start: Int, end: Int) {
    when {
        end >= start -> {
            val range = start..end
            println("sum = ${range.sum()}")
        }
        else -> println("순방향만 가능")
    }
}