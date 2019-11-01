package main

fun printScoreToMark(name: String, score: Int): String {
    if(name.isEmpty() ) return "학생 이름이 없음"
    if( score < 0 || score > 100) return "$name 학생의 점수가 범위에서 벗어남"

    // A: >=90, B : >=80, C : >= 60 D: >= 40, F < 40
    // DRY : Do not Repeat Yourself
    val mark: String // 학점
    if(score >= 90) mark = "A"
    else if(score >= 80) mark = "B"
    else if(score >= 60) mark = "C"
    else if(score >= 40) mark = "D"
    else {
        if(score == 0)
            mark = "F(낙제)"
        else
            mark = "F"
    }

    return "학생 $name 학점 => $mark "
}

fun main(args: Array<String>) {
    println("printScoreToMark(\"Jeonghyun\", -10) = ${printScoreToMark("Jeonghyun", -10)}")
    println("printScoreToMark(\"Jeonghyun\", -10) = ${printScoreToMark("Yong", 60)}")
    println("printScoreToMark(\"Jeonghyun\", -10) = ${printScoreToMark("John", 0)}")
}