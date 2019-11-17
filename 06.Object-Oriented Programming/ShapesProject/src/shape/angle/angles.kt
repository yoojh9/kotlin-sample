package shape.angle

import shape.MyShape
import shape.RECTANGLE
import shape.TRIANGLE
import shape.basic.MyPoint
import shape.line.MyLine

class MyTriangle : MyShape {
//    val pt0: MyPoint? = null
//    val pt1: MyPoint? = null
//    val pt2: MyPoint? = null

    val pts: ArrayList<MyPoint> = ArrayList()
    val lines: ArrayList<MyLine> = ArrayList()

    constructor(pt0: MyPoint, pt1: MyPoint, pt2: MyPoint, _name: String) : super(TRIANGLE) {
        name = _name
        pts.add(pt0)
        pts.add(pt1)
        pts.add(pt2)

        lines.add(MyLine(pt0, pt1, "삼각형의 변 1"))
        lines.add(MyLine(pt1, pt2, "삼각형의 변 2"))
        lines.add(MyLine(pt2, pt0, "삼각형의 변 3"))
    }

    constructor(pts: Array<MyPoint>, _name: String): super(TRIANGLE) {
        name = _name
        // this.pts = pts // err
        if(pts.size != 3) throw IllegalArgumentException("점이 3개가 아님")
        this.pts.addAll(pts)

        // {} 안의 실행 코드가 lines에 3개 쌓인다.
        (1..3).mapTo(lines){  // it => 1,2,3
            MyLine(pts[it-1], pts[if(it==3) 0 else it], "삼각형의 변$it")
        }
    }

    override fun showStatus() {
        super.showStatus()
        printTriangle()
    }

    private fun printTriangle() {
        println("""
            |점0: => ${pts[0].pos()} 점1: => ${pts[0].pos()} 점2: => ${pts[0].pos()}
            |넓이 ${String.format("%.4f", 0.0)} pt^2
        """.trimMargin())
    }

    // 헤론의 공식
    fun getArea() : Double {
        val ds = doubleArrayOf(
            lines[0].getDistance(), lines[1].getDistance(), lines[2].getDistance()
        )
        val s = ds.sum() / 2
        val area = Math.sqrt(
            s * (s-ds[0]) * (s-ds[1]) * (s-ds[2])
        )
        return area
    }

    fun pos() = Triple(pts[0],pts[1],pts[2])
}


class MyRectable: MyShape(RECTANGLE)
{
    // TODO
}

fun main() {
    val triangleA: MyTriangle = MyTriangle(MyPoint(), MyPoint(40,10), MyPoint(10, 40), "삼각형 A")
    triangleA.showStatus()
    triangleA.lines.forEach{ it.showStatus()}   // line의 showStatus
    println()

    val triangleB: MyTriangle = MyTriangle(
        arrayOf(MyPoint(), MyPoint(100, 0), MyPoint(0, 50)), "삼각형 B")
    triangleB.showStatus()
    triangleB.lines.forEach{ it.showStatus()}   // line의 showStatus
}