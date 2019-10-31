package main

// Any 타입 인자 => 문자열 타입이면 문자열로 변환하여 길이를 구해서 길이와 함께 문자열을 출력
//  => Int 정수 타입이라면 정수로 변환 후, * 2 두배한 값을 출력

fun whichType(data: Any){
    if(data is String){
        /**
         * Smart Casting : automatic data가 String형으로 변경 됨 'is'
         */
        // is String 을 체크해서 true가 나올 경우 이미 명시적으로 String이기 때문에 as String으로 형변환을 할 필요가 없다.
        // val result: String = data as String
        // println("result.length 길이 = ${result.length}")

        println("data.length = ${data.length}")
        
    }

    else if (data is Int) {
        println("data * 2 = ${data * 2}")
        // val result : Int = data as Int
        // println("result * 2 = ${result * 2}")
    }

    /**
     * Safe Casting : ClassCastException을 발생시키지 않고 캐스팅을 시킬 수 있는 방법이 있음 'as?'
     */
    else{
        val result = data as? Float // safe cast(nullable cast)
        println("강제 float으로 변환 = ${result}")
        // println("$data 는 String 형도 아니고 Int 형도 아니다. ${data.javaClass}형이다.")
    }
}

fun main(args: Array<String>) {
    whichType("ABCDEFG")
    whichType(123)
    whichType(-10)
    whichType(3.14f)
    whichType(true)
}