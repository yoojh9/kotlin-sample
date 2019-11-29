import java.lang.ArithmeticException
import java.lang.IllegalArgumentException

// sealed class vs enum class
// 계산기 calcualator +-*/ %

// sealed class 자체는 abstract class.
// 봉인된 클래스. sealed된 범위의 상속 타입만 가져
// abstract class 이므로 instance를 생성할 수는 없다
sealed class Calculator {
    class Sum(val a: Int, val b: Int): Calculator()
    class Subtract(val a: Int, val b: Int): Calculator()
    class Multiply(val a: Int, val b: Int): Calculator()
    class Divide(val a: Int, val b: Int): Calculator()
    class Remainder(val a: Int, val b: Int): Calculator()
    //class Pow(val a: Int, val b: Int): Calculator()

    companion object {
        fun cul(op: Calculator)
            = when(op){ // 실드형 인자 조건에 대해서 '모든' 하위 타입 체크 브랜치를 요구
                is Calculator.Sum -> op.a + op.b
                is Calculator.Subtract -> op.a - op.b
                is Calculator.Multiply -> op.a * op.b
                is Calculator.Divide ->
                    if(op.b == 0) {
                        throw ArithmeticException("divide by zero for divide")
                    }
                    else op.a / op.b.toDouble()
                is Calculator.Remainder ->
                    if(op.b == 0) {
                        throw ArithmeticException("divide by zero for Remainder")
                    }
                    else op.a % op.b
                is Pow -> {
                    var z = 1
                    for(i in 1..op.b) z *= op.a
                    z
                }
                // else는 필요가 없음. 모든 타입의 브랜치를 다 생성했기 때문
       }

    }
}

// 밖에 나와있지만 얘도 sealed 되어 있
class Pow(val a: Int, val b: Int): Calculator()

typealias Cal = Calculator
typealias cSum = Calculator.Sum
typealias cSub = Calculator.Subtract
typealias cMul = Calculator.Multiply
typealias cDiv = Calculator.Divide
typealias cRem = Calculator.Remainder


class Dummy

/**
 * 상수 객체들은 특정한 상태를 가질 수 있지만, 다양한 값들을 가진 객체 상수가 존재할 수는 없음
 */
enum class Operation(val a: Int, val b: Int){
    SUM(1,1) {
        // 객체지만 추상 메소드 구현해야 함
        override fun cul(): Int = a + b
    },
    SUB(8,6){
        override fun cul(): Int = a - b
    },
    // MUL(2,3), DIV(11,3)
    ;
    abstract fun cul(): Int
}

fun main() {
    //val ex0: Calculator = Calculator()  // err, abstract, private
    val ex1: Calculator = cSub(8,6) // 8 - 6
    val val1 = Calculator.cul(ex1) as Int
    println("val1 = $val1")

    //val ex2: Calculator = Dummy() // errr
    /**
     * sealed class: 다양한 값들을 가진 객체 상수가 여러개 존재할 수 있음
     */
    val ex2: Calculator = cSub(3,3)

    // (3 + 4) * (12 / 4)
    val result = Cal.cul(cMul( Cal.cul(cSum(3,4)) as Int,
        (Cal.cul(cDiv(12,4)) as Double).toInt() ) )
    println("(3 + 4 ) * ( 12 / 4 ) = $result")

    // (8 - 6)^5 pow
    val result2 = Cal.cul(Pow(Cal.cul(ex1) as Int, 5))
    println("(8 - 6 ) ^ 5 = $result2")
}