package main

fun main(args: Array<String>) {
    /**
     * String vs CharArray
     */
    val str1: CharArray = charArrayOf('A','B','C','D','E')
    val str2: String = "ABCDE"

    println("str1 = ${str1}")   // [C@b684286
    println("str1.joinToString(\"\") = ${str1.joinToString("")}")
    println("str2 = ${str2}")   // ABCDE
    println("str2.toCharArray() = ${str2.toCharArray()}")
    println("str2.toCharArray().joinToString(\",\") = ${str2.toCharArray().joinToString(",")}")

    val c0 = str2.get(0)    // 'A'
    val c1 = str2[0]
    // str2[2] = 'Z'           // Error, 문자열은 set이 없음
    println("c0 = ${c0}  ${c0.toInt()} ${c0.javaClass}")
    println("str2.lastIndex = ${str2.lastIndex} ${str2[str2.lastIndex]} ${str2.length}")

    /**
     * 2차원 배열 : 아직 코틀린에서 공식적으로 리터럴처럼 지원하지는 않음
     */
    // Array(m, { oooArray(n) } )   // m x n 2차원 배열
    // row 0 1 2 , column 0 1 2 3   => 총 12 요소
    val numbers2d = Array(3) { IntArray(4) }   // 3행 4열

    // Array(m, { oooArray(n), { initial } } )   // m x n 2차원 배열
    // Array(m, { oooArray(n) } ) { initial }
    val numbers2dZero = Array(3) { IntArray(4) {0} }
    for( (i, row) in numbers2dZero.withIndex() ) {       // row : IntArray 하나씩
        for( (j, column) in row.withIndex() ){
            print("[$i,$j] => $column\t")
        }
        println()
    }
    println()

    val numbers2dOrdered = Array(3){ i -> IntArray(4) { j -> j+i*4 }}
    for( (i, row) in numbers2dOrdered.withIndex() ) {       // row : IntArray 하나씩
        for( (j, column) in row.withIndex() ){
            print("[$i,$j] => $column\t")
        }
        println()
    }

    /**
     * args: Array<String> ==> Array<Array<Char>>
     */
    println()
    val myFriends = arrayOf<String>("John", "Alice", "Bob", "Anna")
    if(myFriends[0] == "John") println("첫번째 친구 이름 : ${myFriends[0]}")
    if(myFriends[1][0] == 'A' ) println("두번쨰 친구의 첫글자 : ${myFriends[1][0]}")
    
    /**
     * map() : 로직과 처리 공식을 통해 List를 변환하여 돌려주는 함수
     */
    println("가장 이름 길이가 긴 친구의 문자길이 = ${myFriends.map{ it.length }}")
    // [4,5,3,4]

}