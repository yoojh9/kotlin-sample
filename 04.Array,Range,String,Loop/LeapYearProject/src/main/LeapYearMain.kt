package main

/*
 윤년 구하기
    if (year is not divisible by 4 ) then (it is a common year)
    else if (year is not divisible by 100) then (it is a leap year)
    else if (year is not divisible by 400) then (it is a common year)
    else (it is a leap year)
 */
// 윤년 true, 평년 false
fun isLeapYear(year: Int): Boolean {
    return if( year % 4 != 0) false     // 평년
        else if(year % 100 != 0) true   // 윤년
        else if(year % 400 != 0) false  // 평년
        else true                       // 윤년
}


// 년도 구간을 받아 처음 판단되는 10개의 윤년을 배열에 저장하고 결과 출력
fun findFirstTenLeapYears(from: Int, to: Int): IntArray{
    val years = if(from <= to) from..to else from downTo to
    val foundLeaps = IntArray(10) // 0으로 초기화 되어있음
    var ly = 0 // 윤년을 발견한 개수(누적)

    for( (i, y) in years.withIndex() ){
        if( !isLeapYear(y) ) continue

        foundLeaps[ly] = y
        ly++

        if(ly == foundLeaps.size) break
    }

    return foundLeaps
}

fun main(args: Array<String>) {
    println("isLeapYear(2016) = ${isLeapYear(2016)}")
    println("isLeapYear(2019) = ${isLeapYear(2019)}")

    val testYears = intArrayOf(1988, 1992, 1996, 2004, 2008, 2012, 1900, 2100, 2200, 2300, 2500, 1600, 2000, 2400, 2016)

    for( (i, y) in testYears.withIndex() ){
        println("testYears[$i] $y = ${if(isLeapYear(y)) "leap year" else "common year"}")
    }

    println()
    println(findFirstTenLeapYears(1900, 2020).joinToString(", "))


}
