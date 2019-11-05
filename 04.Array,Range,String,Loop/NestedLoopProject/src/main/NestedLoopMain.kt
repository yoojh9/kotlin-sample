package main

fun printTriagle(target: Int){
    println("${target}번 도형")
    val row = when(target) {
        1,2 -> 1..4
        else -> 4 downTo 1
    }

    val column = when(target) {
        1,3 -> 1..8
        else -> 8 downTo 1
    }

    for(i in row) { // row 4개
        for(j in column){
            print("${ if(j <= (i-1)*2) " " else "★" }")
        }
        println()
    }
}


fun main(args: Array<String>) {

    /**
     00000000
       000000
         0000
           00
     */
    println("1번 도형")
    for(i in 1..4) { // row 4개
        for(j in 1..8){
            print("${ if(j <= (i-1)*2) " " else "0" }")
        }
        println()
    }

    /**
     00000000
     000000
     0000
     00
     */
    println("\n2번 도형")    // 1번 도형 column 좌우 대칭
    for(i in 1..4) { // row 4개
        for(j in 8 downTo 1){
            print("${ if(j <= (i-1)*2) " " else "0" }")
        }
        println()
    }

    /**
           00
         0000
       000000
     00000000
     */
    println("\n3번 도형") // 1번 도형 상하 반전
    for(i in 4 downTo 1) {
        for(j in 1..8){
            print("${ if(j <= (i-1)*2) " " else "0" }")
        }
        println()
    }

    /**
     00
     0000
     000000
     00000000
     */
    println("\n4번 도형")    // 3번 도형 좌우 대칭
    for(i in 4 downTo 1) {
        for(j in 8 downTo 1){
            print("${ if(j <= (i-1)*2) " " else "0" }")
        }
        println()
    }

    println()
    printTriagle(4)


    val typeA = intArrayOf(1,3)
    val typeB = intArrayOf(4,2)
    val typeC = intArrayOf(4,4,4,4,4)
    val typeT = intArrayOf(0)

    val shapes = arrayOf(typeB, typeA, typeA, typeC, typeT)

    /**
     * 레이블(Label)
     */
    var i = 0
    label_1@ while(i < shapes.size ){
        for(triangle in shapes[i]) {
            if (triangle == 0) break@label_1        // break 지점 지정
            printTriagle(triangle)
        }
        i++
    }
}