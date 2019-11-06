package main

/**
 * List : ordered, duplicated
 */
fun main(args: Array<String>) {
    // List => Array, Stack, Queue.. 파생됨
    val myFriends = listOf("John", "Elle", "Bob", "Anna", "Bob")
    val frList: List<String> = myFriends

    println("myFriends list = ${myFriends}")

    for( (i, fr) in frList.withIndex() ) {
        println("frList[$i] = $fr")
    }

    println("frList[0] = ${frList[0]} ${frList.get(0)}")    // 마치 Array처럼 보임
    println("frList.indexOf(\"Bob\") = ${frList.indexOf("Bob")}")   // return first index of element, or -1 . lastIndexOf는 끝에서부터
    println("frList.lastIndexOf(\"Bob\") = ${frList.lastIndexOf("Bob")}")
    println("frList.subList(3,5) = ${frList.subList(3,5)}")

    /**
     * MutableList
     */
    // frList[4] = "Bob"  => error. Immutable
    // val myNewFriends : MutableList<String> = mutableListOf("Gildong") // 가변 리스트
    val myNewFriends : MutableList<String> = myFriends.toMutableList()  // Immutable -> Mutable List
    myNewFriends.add("Alice")
    println("myNewFriends = ${myNewFriends} - ${myNewFriends.size}명")

    // Set
    myNewFriends[myNewFriends.lastIndexOf("Bob")] = "Jr.Bob"
    // myNewFriends.set(myNewFriends.lastIndexOf("Bob"), "Bob Jr.")
    myNewFriends.removeAt(3)
    println("myNewFriends = ${myNewFriends} - ${myNewFriends.size}명")


    /**
     * sorting - raw string  - 긴 문장 처리 시 용이
     */
    val mutableStr = """
        |A generic ordered
        |collection of elements
        |that supports adding
        |and removing elements""".trimMargin()  // trimMargin() : | 문자를 기준으로 공백 제거

    println("mutableStr = ${mutableStr}")

    // val words: List<String> = mutableStr.split(' ','\n').sortedBy { it.length }
    val words: List<String> = mutableStr.split(' ','\n').sortedByDescending { it.length }
    println("words = ${words}")
    println()
    for( (i, w) in words.withIndex()) {
        println("words[$i] => $w")
    }
}