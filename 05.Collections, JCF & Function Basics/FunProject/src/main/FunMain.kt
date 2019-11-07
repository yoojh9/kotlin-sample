package main

// return 타입으로 Unit이 생략되어있음
fun thisIsFunction(): Unit{
    val a = 3
    println("a is $a")
    return
    println("not arrived")
}

fun thisIsFunction(argument: Int, parameter: Int?): Int{
    return argument * 3 // 단일 식은 생략 가능
}

/**
 * 단일 식 축약 함수
 *  - return 타입은 Int형으로 추론할 수 있으므로 단일 식 함수에서 리턴타입도 생략할 수 있음
 */
fun thisIsFunction2(argument: Int, parameter: Int?) = argument * 3


/**
 * Overloading
 */
fun joinToGuild(guild: MutableMap<String, String>, nickname: String?){
    val name = nickname ?: "dummy"
    val member = "플레이어 $name : level 1, type 검사, stat 1.0"
    // 가입
    if(guild.containsKey(name)) println("$name 플레이어 이미 가입됨")
    else guild.put(name, member)
}

fun joinToGuild(guild: MutableMap<String, String>, nickname: String?, level: Int){
    val name = nickname ?: "dummy"
    val member = "플레이어 $name : level $level, type 검사, stat 1.0"
    // 가입
    if(guild.containsKey(name)) println("$name 플레이어 이미 가입됨")
    else guild.put(name, member)
}

fun joinToGuild(guild: MutableMap<String, String>, nickname: String?,
                level: Int, type: Int){
    val playerTypes = arrayOf("검사","마법사","궁수","성직자","도적")
    val name = nickname ?: "dummy"
    val typeNumber = if(type in 0..playerTypes.lastIndex) type else 0
    val member = "플레이어 $name : level $level, type ${playerTypes[typeNumber]}, stat 1.0"
    // 가입
    if(guild.containsKey(name)) println("$name 플레이어 이미 가입됨")
    else guild.put(name, member)
}

fun joinToGuild(guild: MutableMap<String, String>, nickname: String?,
                level: Int, type: Int, stat: Float){
    val playerTypes = arrayOf("검사","마법사","궁수","성직자","도적")
    val name = nickname ?: "dummy"
    val typeNumber = if(type in 0..playerTypes.lastIndex) type else 0
    val member = "플레이어 $name : level $level, type ${playerTypes[typeNumber]}, stat $stat"
    // 가입
    if(guild.containsKey(name)) println("$name 플레이어 이미 가입됨")
    else guild.put(name, member)
}

/**
 * 파라미터 default 값 설정.
 *  - joinToGuild() 오버로딩 함수를 처리할 수 있음
 */
fun joinToGuild2(guild: MutableMap<String, String>,
                 nickname: String?,
                 level: Int = 1,
                 type: Int = 0,
                 stat: Float = 1.0f){
    val playerTypes = arrayOf("검사","마법사","궁수","성직자","도적")
    val name = nickname ?: "dummy"
    val typeNumber = if(type in 0..playerTypes.lastIndex) type else 0
    val member = "플레이어 $name : level $level, type ${playerTypes[typeNumber]}, stat $stat"
    // 가입
    if(guild.containsKey(name)) println("$name 플레이어 이미 가입됨")
    else guild.put(name, member)
}

fun main(args: Array<String>) {
    println(thisIsFunction2(3, null))

    val starGuild = mutableMapOf<String, String>()
    joinToGuild(starGuild, null)
    joinToGuild(starGuild, "Alice")
    joinToGuild(starGuild, "Alice")
    joinToGuild(starGuild,"Anna", 5)
    joinToGuild(starGuild, "John", 10, 1)
    joinToGuild(starGuild, "Angela", 33, 4)
    joinToGuild(starGuild, "Bob", 40, 3, 2.0f)

    /**
     * 코틀린에서의 함수 오버로딩은 하나의 함수로 가능하다
     */
    joinToGuild2(starGuild, "Tom", 20, 2)
    joinToGuild2(starGuild, "Peter", stat= 10.99f)  // named parameter
    joinToGuild2(starGuild, "Gildong", stat=7.7f, type=2)

    for( (k, v) in starGuild) {
        println("$k, $v")
    }
}