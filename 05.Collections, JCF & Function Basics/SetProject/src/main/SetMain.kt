package main

/**
 SET
  - 중복 허용 안함
  - 순서 유지 언됨

 List : ordered & duplicated
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
    // val myAlphabets = setOf<Char>('A','B','C','D', 69.toChar(), 'F', 'G')
    val myAlphabets = "ABCDEFG".toSet()
    val it = myAlphabets.iterator()
    while(it.hasNext()) {
        print("${it.next()} \t")
    }

    /**
     * Set 연산
     */
    val myName = "BEN".toSet()  // Set<Char>
    val yourName = "DEA".toSet()
    val hisName = "XYZ".toSet()

    // 1. 포함관계
    println()
    println("myAlphabets.containsAll(myName) = ${myAlphabets.containsAll(myName)}")
    println("myAlphabets.containsAll(yourName) = ${myAlphabets.containsAll(yourName)}")

    // 2. 부분집합 (교집합)
    println("myAlphabets intersect myName = ${myAlphabets intersect  myName}")
    println("myAlphabets intersect yourName = ${myAlphabets intersect  yourName}")

    // 3. 합집합
    println("myAlphabets union myName = ${myAlphabets union myName}")
    println("myAlphabets + myName = ${myAlphabets + myName}")

    // 4. 차집합
    println("myAlphabets subtract myName = ${myAlphabets subtract myName}")
    println("myAlphabets - myName = ${myAlphabets - myName}")


    /**
     * 불변 vs 가변
     */
    val herName = setOf('M','a','r','y')
    // herName.add('n') // error: 불변 immutable

    val herName2 : MutableSet<Char> = mutableSetOf('M','a','r','y')    //
    herName2.add('n')   // 가변 mutable
    herName2.addAll(setOf('L','e'))
    herName2.remove('y')
    herName2.clear()
    println("herName2 = ${herName2}")
}