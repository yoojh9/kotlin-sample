package standard

class StandardFunctions {

    init {
        letFun()
        mapFun()
        withFun()
        applyFun()
        runFun()
        alsoFun()
    }
    /**
     * let()
      - inline fun <T, R> T.let(block: (T) -> R): R
      - let에서는 this가 it가 같음
     */
    fun letFun(): Unit {
        val obj: String = "ABCDE"
        var count = 0
        val result: Char = obj.let { 
            // 클로저: count 외부 변수 접근 가능. (외부 변수 문맥 변화 가능)
            println("[$count] in the let() function")
            count++;
            println("this = ${this}")   // let에서의 this는 obj가 아니고 StandartFunctions의 객체를 의미
            println("this@StandardFunctions = ${this@StandardFunctions}")
            println("it = ${it}")
            // return  // 람다식 리턴이 아니고 Unit 타입 리턴 (letFun() 리턴)
            // return@let 'B' // let의 리턴은 block:(String) -> Char 형식이어야 함

            'A' // let의 마지막 결과가 리턴값과 같
        }
        println("result = ${result} and count => ${count} \n\n")
    }

    /**
     * map()
      - inline fun <T, R> Iterable<T>.map(
            transform: (T) -> R
        ): List<R>
      - transform: 함수형 파라미터 (람다, 익명함수, 함수)
      - 요소가 차례로 it으로 들어옴
     */
    fun mapFun(): Unit {
        val obj: List<Char> = "ABCDE".toList()
        var count = 0
        val result: List<Char> = obj.map {
            println("[$count] in the map() function")
            count++;
            println("this = ${this}")
            println("this@StandardFunctions = ${this@StandardFunctions}")
            println("it = ${it}")

            it.toLowerCase()
        }
        println("result = ${result} and count => ${count} \n\n")
    }

    /**
     * with()
      - inline fun <T, R> with(receiver: T, block: T.() -> R): R
      - with()는 확장함수가 아님
     */
    fun withFun(): Unit {
        val obj: Toy = Toy("Gundam",100, ToyType.DOLL)
        var count = 0
        val result: Char = with(obj) {
            println("[$count] in the with() function")
            count++;
            println("this = ${this}")   // this가 obj 객체
            println("this@StandardFunctions = ${this@StandardFunctions}")

            name += " MK-II"
            price = 1000
            category = ToyType.ROBOT

            'A' // 마지막 expression이 타입으로 나감
        }
        println("result = ${result} and count => ${count} \n\n")
    }

    /**
     * apply()
        - inline fun <T> T.apply(block: T.() -> Unit): T
        - 자기 자신 리턴
        - with()와 비슷하지만 T 자신을 리턴
        - 빌더 패턴이 없는 객체에 빌더 패턴을 적용시키고 T 자체를 리턴
     */
    fun applyFun(): Unit {
        val obj: Toy = Toy("Princess").apply{ name += "Elsa"}
                     .apply { price = 2000
                     category = ToyType.DOLL}    // 빌더 패턴처럼 적용 가
        var count = 0
        val result: Toy = obj.apply {
            println("[$count] in the apply() function")
            count++;
            println("this = ${this}")   // this가 obj 객체
            println("this@StandardFunctions = ${this@StandardFunctions}")

            name += " Elsa"
            price = 2000
            category = ToyType.DOLL

            'A' // result 'A'로 찍히지 않음. apply()의 리턴은 obj 그 자체이므로
        }
        println("result = ${result} and count => ${count} \n obj => $obj \n\n")
    }

    /**
     * run()
      - with()처럼 normal 함수로 쓸 수도 있고, let()처럼 확장함수로 쓸 수도 있다
      - let()과 with()를 조합한 함수 느낌..
      - inline fun <R> run(block: () -> R): R
      - inline fun <T, R> T.run(block: T.() -> R): R
     **/
    fun runFun(): Unit {
        val obj: Toy = Toy("Tesla", 100, ToyType.SPACESHIP)
        var count = 0
        val result: Char = obj.run {
            println("[$count] in the run() function")
            count++;
            println("this = ${this}")   // this가 obj 객체
            println("this@StandardFunctions = ${this@StandardFunctions}")

            // with()와 apply()처럼 this를 이용해 객체에 접근하는 건 가능.
            // 하지만 builder 패턴은 아님 (apply 처럼 리턴하지는 않음)
            this.name += " model S"
            price = 10000
            category = ToyType.CAR

            'A' // result에는 'A'가 찍힘. apply()와 다른 점.
        }
        println("result = ${result} and count => ${count} \n obj => $obj \n\n")
    }

    /**
     * also()

     */
    fun alsoFun(): Unit {
        val obj: Toy = Toy("Apolo", 100, ToyType.BRICK)
        var count = 0
        val result: Toy = obj.also {
            println("[$count] in the run() function")
            count++;
            println("this = ${this}")   // this가 obj 객체
            println("this@StandardFunctions = ${this@StandardFunctions}")
            println("it = ${it}")

            it.name += " XII"
            it.price = 10000
            it.category = ToyType.SPACESHIP

            'A' // result에는 obj가 찍힘
        }
        println("result = ${result} and count => ${count} \n obj => $obj \n\n")

    }
}

enum class ToyType {NONE, ROBOT, DOLL, CAR, BRICK, SPACESHIP}

data class Toy(var name: String, var price: Int = 0, var category: ToyType = ToyType.NONE)


fun main() {
    //StandardFunctions().letFun()
    //StandardFunctions().mapFun()

    StandardFunctions()
}