package shape.line

import shape.LINE
import shape.MyShape
import shape.basic.MyPoint
import kotlin.math.sqrt

fun main() {
    val line1: MyLine = MyLine()
    val line2: MyLine = MyLine("선2")
    val line3: MyLine = MyLine(10,10,50,80,"선3")
    val line4: MyLine = MyLine(MyPoint(), MyPoint(30,30),"선4")
    val line5: MyDottedLine = MyDottedLine(10,10,50,80,"선5")
    val line6: MyDashedLine = MyDashedLine(10,10,50,80,"선6")

    val myLines = arrayListOf<MyLine>(line1, line2, line3, line4, line5, line6)
    for(ln in myLines)
        ln.showStatus()  // 재정의 함수 MyShape에 재정의 된 게 있으면 그걸 호출하고 재정의 된 함수가 없으면 부모 클래스의 함수를 호
}

open class MyLine(_name: String = "테스트선") : MyShape(LINE) {
    var sp: MyPoint
    var ep: MyPoint
    var thick: Int = 1
    // private val strokeType = "solid" // 나만
    open protected val strokeType = "solid"  // 후손과 나만, overriding이 가능하게

    init {
        super.name = _name
        sp = MyPoint()  // 원점
        ep = MyPoint(10,10)
    }

    // 2차 생성자의 parameter name이 1차 생성자에 들어갈 수 있도록 위임
    constructor(_sp: MyPoint? = MyPoint(),
                _ep: MyPoint? = MyPoint(),
                _name: String): this(_name){
        this.sp = _sp ?: MyPoint()
        this.ep = _ep ?: MyPoint(10, 10)
    }

    constructor(x1: Int = 0, y1: Int = 0,
                x2: Int, y2: Int,
                _name: String): this(_name){
        sp = MyPoint(x1, y1)
        ep = MyPoint(x2, y2)
    }

    private fun printLine(){
        println("""
        |선 종류: $strokeType, 선 두께: $thick pt
        |시작점 ${sp.pos()} => 끝점 ${ep.pos()}
        |길이: ${String.format("%.4f",getDistance())} pt
        """.trimMargin())
    }

    fun getDistance() =
        sqrt((ep.x - sp.x) * (ep.x - sp.x).toDouble()
                    + (ep.y - sp.y) * (ep.y - sp.y).toDouble())

    fun pos() = Pair(sp, ep)

    // final : 나는 오버라이딩 해서 재정의해서 썼지만, 내 후손들은 재정의 하지 못하게 막음
    final override fun showStatus() {
        super.showStatus()
        this.printLine()
    }
}

class MyDottedLine: MyLine {
    /**
     * 프로퍼티 오버라이딩
     */
    override val strokeType: String = "dotted"

    init {
        super.thick = 2
    }

    constructor(_sp: MyPoint? = MyPoint(),
                _ep: MyPoint? = MyPoint(),
                _name: String): super(_sp,_ep,_name)

    constructor(x1: Int = 0, y1: Int = 0,
                x2: Int, y2: Int,
                _name: String): super(x1,y1,x2,y2,_name)

//    override fun showStatus() {   // err => final
//        super.showStatus()  // super: MyLine
//    }
}

class MyDashedLine: MyLine {

    override val strokeType: String = "dashed"

    init {
        super.thick = 2
    }

    constructor(_sp: MyPoint? = MyPoint(),
                _ep: MyPoint? = MyPoint(),
                _name: String): super(_sp,_ep,_name)

    constructor(x1: Int = 0, y1: Int = 0,
                x2: Int, y2: Int,
                _name: String): super(x1,y1,x2,y2,_name)


}