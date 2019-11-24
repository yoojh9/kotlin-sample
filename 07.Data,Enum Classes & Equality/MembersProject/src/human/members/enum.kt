package human.members

// 배열이나 리스트처럼 순서 번호가 있다. (ordinal)
enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

enum class Color(val rgb: Int){
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

enum class Weekdays(val kr: String){
    SUN("일"), MON("월"), TUE("화"),
    WED("수"), THU("목"), FRI("금"), SAT("토")
}

fun main(args: Array<String>) {
    val d1: Direction = Direction.EAST  // .ordinal
    println("d1 = ${d1}")   // 내용을 찍는 함수가 없으면 문자열 그대로 나옴
    
    val cr1: Color = Color.RED
    println("cr1.toString() = ${cr1.toString()}")   // RED
    println("cr1.rgb = ${cr1.rgb}")
    println("cr1.rgb = 0x${cr1.rgb.toString(16).toUpperCase()}")    // 0xFF0000
    println("cr1.name = ${cr1.name}")   // RED
    println("cr1.ordinal = ${cr1.ordinal}") // 0


}