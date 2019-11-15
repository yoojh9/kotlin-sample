package shape.basic

import shape.MyShape
import shape.POINT
import shape.RED

// err : this type is final, so it cannot be inherited from
// 기본적으로 코틀린은 final 클래스(상속이 불가능함)
class MyPoint(_x: Int = 0, _y: Int = 0,
              _name: String = "원") : MyShape(POINT) {
    var x: Int = _x
    var y: Int = _y

    init {
        super.name = _name  // super: 상위 클래스 객체 자신
    }

    fun printPoint(){
        println("pt(x,y) => ($x,$y)\n")
    }

    fun pos() = Pair(this.x, y) // 점 좌표를 쌍으로 리컨해주는 함
}

fun main(args: Array<String>) {
    val sp : MyPoint = MyPoint()    // 원점
    val ep: MyPoint = MyPoint(10,10, "도착점")
    val ep2: MyPoint = MyPoint(40,10, "도착점2")

    sp.color = RED
    sp.showStatus() // super
    sp.printPoint()

}

