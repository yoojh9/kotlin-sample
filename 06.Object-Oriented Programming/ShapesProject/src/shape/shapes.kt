package shape

// 패키지 상수 정의
val POINT: String = "점"
val LINE: String = "선"
val TRIANGLE: String = "삼각형"
val RECTANGLE: String = "사각형"

val BLACK = "0x000000"  //  RGB
val RED: String = "0xFF0000"
val GREEN: String = "0x00FF00"
val BLUE: String = "0x0000FF"


// shape 공통 클래스 ('open': 상속 가능 클래스)
open class MyShape(val type: String ? = null) {
    var name: String? = null
    var color: String = BLACK

    // 공통 클래스
    fun showStatus(){
        println("""
            |*Shape*
            |이름: $name
            |타입: $type, 색상: $color
        """.trimMargin())
    }
}

fun main(args: Array<String>) {
    val ms = MyShape(POINT)
    ms.name = "원점"
    ms.showStatus()
}