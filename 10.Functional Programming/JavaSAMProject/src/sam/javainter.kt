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
}