package main

/**
 SET
  - 중복 허용 안함
  - 순서 유지 언됨

 List
  - 중복 허용
  - 순서 유지
 */
fun main(args: Array<String>) {
    println("setOf(1,2,2,3) = ${setOf(1,2,2,3)}")
    val myNumberSet = setOf(2,1,3, 2,2,3, 1,3,3)    // Set<out E>
    val myNumberList = listOf(2,1,3, 2,2,3, 1,3,3)
    val myDistinctNumbers = myNumberList.distinct().sorted()

    println("myNumberSet = ${myNumberSet}, size = ${myNumberSet.size}")
    println("myNumberList = ${myNumberList}, size = ${myNumberList.size}")
    println("myDistinctNumbers = ${myDistinctNumbers}, size = ${myDistinctNumbers.size}")

    for(n in myNumberSet) println("set n => $n")
    for ( (i,n) in myNumberSet.withIndex()) println("set[$i] => $n")
    
    val mySet: Set<Int> = myNumberSet
    println("mySet = ${mySet}")
    println("mySet.isEmpty() = ${mySet.isEmpty()}")
    println("4 in mySet = ${4 in mySet}")   // in : contain
    println("myNumberSet.contains(4) = ${myNumberSet.contains(4)}")


    /**
     * iteration, iterator - 요소들을 순차적으로 탐색
     */
    val myAlphabets = setOf<Char>('A','B','C','D', 69.toChar(), 'F', 'G')
    val it = myAlphabets.iterator()
    while(it.hasNext()) {
        print("${it.next()} \t")
    }



}