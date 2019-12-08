package currypartial

fun normalSum(a: Int, b:Int) = a + b

// a 인자를 받고 나서 b 인자는 나중에 받겠다
// 람다식 커링
fun currySumLambda(a: Int) = { b: Int -> a + b }

// 익명함수 커링
fun currySumAnonymousFunction(a: Int) = fun(b: Int) = a + b

fun curryIntSum2(a: Int) = fun(b: Int) = a + b
fun curryIntSum3(a: Int) = fun(b: Int) = fun(c: Int) = a + b + c
fun curryIntSum4(a: Int) = fun(b: Int) = fun(c: Int) = fun(d: Int) = a + b + c + d

fun curryStringConcat4(s1: String)
    = fun (s2: String)
        = fun (s3: String)
            = fun (s4: String)
                = "$s1$s2$s3$s4"

typealias LtoLFunc = (Long) -> Long
fun listMap(f: LtoLFunc, list: List<Long>) = list.map { f(it) }
fun partialApplication(remain: (LtoLFunc, List<Long>) -> List<Long>,
                       bind: LtoLFunc)
        = { list: List<Long> -> remain(bind, list)}

// 고정 bind 함수
fun square(x: Long) = x * x
fun cubic(x: Long) = x * x * x
fun doubleNum(x: Long) = 2 * x
fun decaNum(x: Long) = 10 * x
fun factorial(x: Long): Long {
    var fac: Long = x
    (x-1 downTo 1).forEach{ fac *= it}
    return fac
}

fun main() {
    println("normalSum(3, 4) = ${normalSum(3, 4)}")
    println("currySumLambda(3)(4) = ${currySumLambda(3)(4)}")
    println("currySumAnonymousFunction(3)(4) = ${currySumAnonymousFunction(3)(4)}")
    println("curryIntSum2(3)(4) = ${curryIntSum2(3)(4)}")
    println("curryIntSum3(3)(4)(5) = ${curryIntSum3(3)(4)(5)}")
    println("curryIntSum4(3)(4)(5)(6) = ${curryIntSum4(3)(4)(5)(6)}")

    // 중간 함수처럼 사용할 수 있음
    val curriedBy_3_4_5: (Int) -> Int = curryIntSum4(3)(4)(5)
    println("curriedBy_3_4_5(6) = ${curriedBy_3_4_5(6)}")
    println("curriedBy_3_4_5(8) = ${curriedBy_3_4_5(8)}")
    println("curriedBy_3_4_5(12) = ${curriedBy_3_4_5(12)}")

    println("curryStringConcat4(\"A\")(\"B\")(\"C\")(\"D\") = ${curryStringConcat4("A")("B")("C")("D")}")

    val partialSquare: (List<Long>) -> List<Long> = partialApplication(::listMap, ::square)
    val partialCubic: (List<Long>) -> List<Long> = partialApplication(::listMap, ::cubic)
    val partialDoubleNum: (List<Long>) -> List<Long> = partialApplication(::listMap, ::doubleNum)
    val partialDecaNum: (List<Long>) -> List<Long> = partialApplication(::listMap, ::decaNum)
    val partialFactorial: (List<Long>) -> List<Long> = partialApplication(::listMap, ::factorial)

    val testDataList: List<List<Long>>
        = listOf(
        (1L..20L step 2L).toList(),
        //(1L..10L).map{it * 2L},
        (1L..10L).map(::doubleNum)
    )

    for(list in testDataList){
        println("target list => $list")
        println("partialSquare = ${partialSquare(list)}")
        println("partialCubic = ${partialCubic(list)}")
        println("partialDoubleNum = ${partialDoubleNum(list)}")
        println("partialDecaNum = ${partialDecaNum(list)}")
        println("partialFactorial = ${partialFactorial(list)}")
    }


}