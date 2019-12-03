package dices

import java.util.Random as JRandom

fun getNumberInt(max: Int) = (Math.random()*max).toInt() + 1
fun getNumberInt2(max: Int) = JRandom().nextInt(max) + 1 // java.util.Random 사용
fun getNumberStream(max: Int) = JRandom().ints(1,max).findFirst().asInt

fun getNumberHedron(hed: Hedron) = (Math.random() * hed.faces).toInt() + 1

enum class Hedron(val faces: Int) {
    TETRAHEDRON(4), CUBE(6), OCTAHEDRON(8), DODECAHEDRON(12)
}

/**
 * typealias
 */
// 함수형 타입을 HedronToInt로 표현하겠다.
// typealias HedronToInt = (Hedron) -> Int // 함수 타입을 typealias로
typealias Random = (Hedron) -> Int

class Dice(val sides: Hedron){
    fun cast(ranFun: (Int)->Int) = ranFun(sides.faces)
    fun castHedron(ranFun: Random) = ranFun(sides)

    override fun toString(): String {
        // return "Dice(${sides.name}) casts '${getNumberInt(sides.faces)}'"
        // return "Dice(${sides.name}) casts '${cast(fun(n: Int) = (Math.random()*n).toInt() + 1) }'" // 익명함수
        // return "Dice(${sides.name}) casts '${cast({(Math.random() * sides.faces).toInt() + 1}) }'" // 람다식

        // 람다 블럭 : 마지막 파라미터 또는 하나의 파라미터가 함수형 인자일 때, 함수형 파라미터를 람다 블럭으로 뺄 수 있음
        // return "Dice(${sides.name}) casts '${cast{(Math.random() * sides.faces).toInt() + 1 }}'"

        /**
         * 함수 레퍼런스
         */
        // sides.face가 getNumberInt의 max 파라미터로 들어옴
        // return "Dice(${sides.name}) casts '${cast(::getNumberInt)}'"
        // return "Dice(${sides.name}) casts '${cast(::getNumberInt2)}'"
        //return "Dice(${sides.name}) casts '${cast(::getNumberStream)}'"
        return "Dice(${sides.name}) casts '${castHedron(::getNumberHedron)}'"
    }
}

/*
4 Tetrahedron
6 Cube
8 Octahedron
12 Dodecahedron
 */
fun main() {
    val dices: List<Dice> = listOf<Dice>(Dice(Hedron.TETRAHEDRON),
        Dice(Hedron.CUBE),Dice(Hedron.OCTAHEDRON),Dice(Hedron.DODECAHEDRON))

    println("\n 0. for loop iteration")
    for(dice in dices){
        println(dice.toString())
    }

    //
    println("\n 1. anonymous function parameter")
    dices.forEach( fun(dice: Dice){ println(dice.toString())} )

    println("\n 2. lambda expression parameter")
    dices.forEach( { dice: Dice -> println(dice.toString())} )

    println("\n 3. last parameter to external lambda block")
    dices.forEach(){ dice: Dice -> println(dice.toString()) }

    println("\n 4. () removing for single argument lambda block") // () 생략
    dices.forEach{ dice: Dice -> println(dice.toString()) }

    println("\n 5. single argument 'it' for lambda expression") // lambda 블럭에 single parameter(argument)가 들어오고 타입 추론이 가능하다면 it으로 사용 가능
    dices.forEach{ dice -> println(dice.toString()) }
    dices.forEach { it -> println(it.toString())}
    dices.forEach{ println(it)}

    println("\n 6. function reference of kotlin.io::println") // 함수 레퍼런스
    dices.forEach(::println)

    println("\n 7. custom function reference of ::printDice")
    dices.forEach(::printDice)

    println("\n 8. function reference of System.out::println (JVM)")
    dices.forEach(System.out::println)

}

fun printDice(d: Dice) = println(d)