package sam

import java.util.Collections.sort

fun main() {
    // object선언 - singleton 패턴
    // companion object - java static

    /**
     * 1. object expression
     */
    // 클래스 생성자 없이도 객체 생성 가능
    val objHuman = object {
        val name = "einstein"
        val job = "scientist"
    }

    println("objHuman = $objHuman, objHuman.name = ${objHuman.name}, objHuman.job = ${objHuman.job}")


    /**
     * 2. Java SAM FI
     */
    val numbers = arrayListOf<Int>(4,1,8,5,2,7,3,6,9)
    numbers.sort()
    println("numbers.sort() = ${numbers}")
    numbers.sortDescending() // 내림차순
    println("numbers.sortDescending() = ${numbers}")
    println("numbers.sorted() = ${numbers.sorted()}")
    println("numbers.sort() = ${numbers.apply(ArrayList<Int>::sort)}") // :: 함수 레퍼런스

    sort(numbers, object: Comparator<Int>{  // java.util.Comparator<T>
        override fun compare(o1: Int, o2: Int): Int {
            return o2 - o1  // 내림차순. o1 - o2 : 오름차순
        }
    })

    // 단 하나의 메소드 이름만 가지고 있으므로 메소드는 필요 없음 (람다식)
    sort(numbers, Comparator<Int>{ // java.util.Comparator<T> SAM FI
       o1, o2 -> o2 - o1  // 내림차순. o1 - o2 : 오름차순
    })

    sort(numbers, {o1, o2 -> o1 - o2})

    // 마지막 파라미터가 람다 함수형이기 때문에 람다블록으로 사용할 수도 있음
    sort(numbers) { o1,o2 -> o1 - o2}

    val objComparable : java.util.Comparator<Int> = object: java.util.Comparator<Int> {
        override fun compare(o1: Int, o2: Int): Int {
            return o1 - o2
        }
    }
    sort(numbers, objComparable)

    // custom SAM
    val objCountJava = object: MyCountable {
        override fun myCount(list: MutableList<Int>?): Int {
            return list?.size ?: 0
        }
    }

    // val objCountJava2 =  MyCountable { list -> list?.size ?: 0 }
    val objCountJava2 =  MyCountable { it?.size ?: 0 } // SAM 축약 표현
    println("java SAMFI objCountJava.myCount(null) = ${objCountJava.myCount(null)}")
    println("java SAMFI objCountJava.myCount(numbers) = ${objCountJava.myCount(numbers)}")

    // 코틀린에서 만든 interface with one abstract function은 SAM이 아니므로 축약이 되지 않음
    val objCountKt = object: MyCountableKt {
        override fun myCount(list: List<Int>): Int {
            return list.size
        }
    }
    //val objCountKt2 = MyCountableKt { list: List<Int> -> list.size }
    //val objCountKt3 = MyCountableKt { it.size }

    /**
     * typealias
     */
    val objCountTypeAlias: MyCountableTypeAlias = object : MyCountableTypeAlias {
        override fun invoke(p1: MutableList<Int>): Int {
            return p1.size
        }
    }

    println("objCountTypeAlias.invoke() = ${objCountTypeAlias.invoke(numbers)}")
    println("objCountTypeAlias() = ${objCountTypeAlias(numbers)}")

    // 람다
    val objCountTypeAliasLambda: MyCountableTypeAlias = {
        list: MutableList<Int> -> list.size
    }

    // 익명함수
    val objCountTypeAliasAnony = fun(list: MutableList<Int>) = list.size

    val mcList: List<MyCountableTypeAlias> = listOf(objCountTypeAlias, objCountTypeAliasLambda, objCountTypeAliasAnony)
    mcList.map { it(numbers) }.forEach(::println)
}

// 이건 코틀린에서 만든 것이므로 SAM이 아님
interface MyCountableKt {
    fun myCount(list: List<Int>): Int
}

/**
 * invoke라는 abstract method를 가지고 있는 인터페이스
 */
typealias MyCountableTypeAlias = (MutableList<Int>) -> Int