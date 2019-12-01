package main

// 함수형 파라미터
fun myFun(p:()->Unit) = p() // invoke()

// HOF
fun takePrintNameFunction(name: String, pnFun: (String) -> Unit) {
    val local: (String) -> Unit = pnFun
    local(name)
}

// 함수를 만들어서 리턴
fun supplyPrintNameFunction(): (String) -> Unit {
    return { a: String ->
        println("your name is '$a'!")
    }
}

fun main() {
    myFun {
        println("Hello kotlin FP!")
    }
    // p : { println("Hello kotlin FP!") }

    // 1. 변수에 담을 수 있음 - 1급 함수
    val printName: (String) -> Unit = fun(name: String) {
        println("your name is '$name'!")
    } // 익명함수
    printName("hong gildong")
    printName("anna")
    println("printName.javaClass = ${printName.javaClass}")

    val pName2: (String) -> Unit = printName
    pName2("princess Ellsa")

    val pName3: (String) -> Unit = { name: String ->
        println("your name is '$name'!")
    } // 람다식

    pName3("Jeonghyun")

    // 2. 인자로 전달할 수 있음
    takePrintNameFunction("David",  pName2)
    takePrintNameFunction("Lilly", fun(n: String){
        println("your name is '$n'!")
    })
    takePrintNameFunction("Mark", {x: String -> println("your name is '$x'!")})

    // 3. 반환값 리턴할 수 있음
    takePrintNameFunction("Yan", supplyPrintNameFunction())
    supplyPrintNameFunction()("HoHoHo")

    val pName4: (String) -> Unit = supplyPrintNameFunction()
    pName4("Last Man")

    listOf<Int>(1,2,3,4,5,6,7).showNumbersToString({n -> n % 2 == 1}, concats)
    (1..7).toList().showNumbersToString(fun(n: Int) = n % 2 == 0 , concats)
}

// 숫자 리스트 확장함수 - 고차함수(함수 2개 이상 소비)
fun List<Int>.showNumbersToString(
    pre: (Int) -> Boolean ,
    con: (List<Int>, String) -> String
) {
    val list: ArrayList<Int> = arrayListOf<Int>()
    for(n in this){
        if(pre(n)) list.add(n)
    }
    println(con(list,","))
}

val concats = fun(ints:List<Int>, sep:String): String{
    var s = ""
    for((i,n) in ints.withIndex()){
        if(i < ints.lastIndex) s += "$n$sep"
        else s+= "$n"
    }
    return s
}
