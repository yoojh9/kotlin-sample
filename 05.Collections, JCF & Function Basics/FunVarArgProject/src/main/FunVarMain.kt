package main

/**
 * 가변 인자 함수 vararg
  - 0개부터 n개까지 가변인자를 받을 수 있음
 */
fun varargFunction(vararg numbers: Int){
    // vararg는 배열처럼 쓰임
    println("numbers.javaClass = ${numbers.javaClass}")
    println("numbers.sum() = ${numbers.sum()}")
    println("numbers.average() = ${numbers.average()}")
    println("numbers.size = ${numbers.size}")
}

// mutableMapOf(vararg pair : Pair<K,V>)
val basket = mutableMapOf<String, String>()

fun putIceCreams(customer: String, vararg ic: String) {
    if(ic.size < 1) return

    val prevCustomer = basket[customer]
    basket[customer] = ( if(prevCustomer == null) "" else prevCustomer+", " )+
            ic.joinToString(", ")
}

fun main(args: Array<String>) {
    val nums: IntArray = intArrayOf(1,2,3,4,5)
    varargFunction(10,20,30,40,50)
    println()
    varargFunction(*nums)

    putIceCreams("Frank", "체리맛", "초코맛", "딸기맛")
    putIceCreams("Susan", "체리맛", "바닐라맛", "바나나맛", "메론맛")
    putIceCreams("Frank", "오렌지맛", "쿠키맛")
    putIceCreams("Frank", "파인애플맛")


    // Immutable
    // 뷰
    val checkoutBasket : Map<String, String> = basket
    // basket["Frank"] = "xyz" // private
    // checkoutBasket["Frank"] = "xyz" // err: public
    putIceCreams("Frank", "허니초코맛")  // basket이 바뀌면 view인 checkoutBasket도 바뀜

    val bonusIceCreams = arrayOf("bn땅콩맛","bn호두맛","bn고구마맛","bn호박맛")

    /**
     '*' : 펼침 연산자
        - 배열 앞에 *를 붙이면 배열이 풀어지는 효과가 발생
        - ["땅콩맛","호두맛","고구마맛","호박맛"] => "땅콩맛","호두맛","고구마맛","호박맛
     */
    putIceCreams("Susan", *bonusIceCreams,"당근맛","사과맛")

    // b: Pair(K,V)
    for(b in checkoutBasket)
        println("${b.key} => ${b.value}")

}