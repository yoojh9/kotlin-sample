package main

fun main(args: Array<String>) {
    // Map: Key => Value - hash, dictionary
    // 같은 키 값이 들어오면 값이 대체됨
    val students = mapOf("Alice" to 23, "John" to 21, "Peter" to 23, "Anna" to 25, "Gildong" to 30,
        "Alice" to 22, "Alice" to 20) // to : 중위식 함수

    val stMap: Map<String, Int> = students
    println("stMap = ${stMap} with size ${stMap.size}")
    println("stMap[\"Alice\"] = ${stMap["Alice"]}")
    println("stMap[\"Elle\"] = ${stMap["Elle"]}")   // .get(key) => value  키가 없으면 null이 나옴
    println("stMap.get(\"Gildong\") = ${stMap.get("Gildong")}")
    // println("stMap = ${stMap.getValue("Elle")}")    // get()과 차이점: 키를 찾을 수 없으면 예외 발생. NoSuchElementException

    val studentScores: Map<String, Float> = mapOf("Alice" to 4.3f, "John".to(3.2f),
        Pair("Peter", 3.5f))    // Entry<K,V>

    println("studentScores = ${studentScores} with size ${studentScores.size}")
    println("studentScores.keys = ${studentScores.keys}")   // 키의 집합 (문자열)
    println("studentScores.values = ${studentScores.values}")   // 값의 collections

    // studentScores["peter"] = 4.0f   // immutable, no set() err!

    /**
     * MutableMap
     */
    var studentScores2: MutableMap<String, Float> = studentScores.toMutableMap()
    studentScores2["peter"] = 4.0f  // set(), put()
    studentScores2.put("Anna", 4.5f)
    studentScores2["Gildong"] = 2.2f
    studentScores2.remove("John")
    println("studentScores2 = ${studentScores2}")


    // gildong.kim@google.com => gildong.kim 키 to 값 google.com
    val mbBook : MutableMap<String, String> = mutableMapOf()
    insertNewEmailToMemberBook("yoojh9@gmail.com", mbBook)
    insertNewEmailToMemberBook("yoojh912@naver.com",mbBook)
    insertNewEmailToMemberBook("ykwon89@gmail.com",mbBook)

    val mbIds = mbBook.keys

    for( (k,v) in mbBook) {
        println("${k},${v}")
    }

}

val NOT_FOUND = -1
fun insertNewEmailToMemberBook(email: String?, mbBook: MutableMap<String, String>){
    if(email == null) {
        println("이메일 주소가 누락")
        return
    }
    val atPos = email.indexOf('@')
    if(atPos == NOT_FOUND || atPos == email.lastIndex) {
        println("이메일 주소가 잘못 되었습니다.")
        return
    }

    // 이메일 주소를 @문자의 위치 기준으로 분리
    val key     = email.substring(0..atPos-1)
    val value   = email.substring(atPos+1..email.lastIndex)

    println("atPos = ${atPos}")
    println("key = ${key}")
    println("value = ${value}")

    mbBook.put(key, value)
}







