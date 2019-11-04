package main

fun isPrimeNumber(num: Int) {
    println("\n ${num} 소수 판단")

    when {
        num <= 1 -> return
        num == 2 -> println("2는 당연히 소수입니다.")
        num >= 3 -> {
            for(n in 2 until num) {
                if(num % n == 0) {  // 약수
                    println("${num}은 소수가 아닙니다.")
                    return
                }
            }
            println("${num}은 소수입니다.")
        }
        else -> return
    }
}

// for -> while
fun isPrimeNumber2(num: Int) {
    println("\n ${num} 소수 판단")

    when {
        num <= 1 -> return
        num == 2 -> println("2는 당연히 소수입니다.")
        num >= 3 -> {
            var n = 2
            val end = num -1
            // while에는 따로 주어진 index가 없음.
            while(n <= end) {
                if(num % n == 0) {  // 약수
                    println("${num}은 소수가 아닙니다.")
                    return
                }
                n++
            }
            println("${num}은 소수입니다.")
        }
        else -> return
    }
}

fun main(args: Array<String>) {

    // 적어도 한번은 실행
   do {
        println("run once !")
   } while(false)

    isPrimeNumber(14)
    isPrimeNumber(111)
    isPrimeNumber(101)
    isPrimeNumber2(15)
    isPrimeNumber2(7)

    /**
     * do-while
     */
    val myNumbers = intArrayOf(3,8,9,13,15,17,20)
    var i = 0;
    do {
        isPrimeNumber2(myNumbers[i])
        i++;
    } while(i < myNumbers.size)

    /**
     * args[0]..args[1] 범위 소수 판단
     */
    println("\n ----- args ------\n")
    val from = args[0].toInt()
    val to = args[1].toInt()
    val range = if(from <= to)
                    from..to
                else from downTo to
    println("args range = ${range}")

    for(n in range){
        isPrimeNumber2(n)
    }
}

