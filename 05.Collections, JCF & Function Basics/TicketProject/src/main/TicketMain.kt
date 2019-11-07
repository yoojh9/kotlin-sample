package main
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

/**
 * JCF: Java Collection Framework
 *  - CRUD가 HashSet, ArrayList, HashMap에 적용되어 있음
 */
fun main(args: Array<String>) {
    // JCF : Java Collection Framework
    // 요소의 추가, 삭제, 참조가 자유롭게 가능
    val mySet: HashSet<Char> = hashSetOf()
    val myList: ArrayList<Char> = arrayListOf()
    val myMap: HashMap<String, Char> = hashMapOf()

    mySet.add('A')  // Create
    myList.add('B')
    myMap["first"] = 'C'

    myList.set(0,'D')   // Update
    mySet.remove('A')   // Delete
    myMap.clear()

    println("mySet = ${mySet}, myList = ${if(myList.isEmpty()) "none" else myList[0]}, myMap = ${myMap}")
    println("myMap[\"first\"] = ${myMap["first"]}") // Read

    // 주어진 현금으로 티켓을 랜덤하게 발권하여, 그 발권 리스트를 출력
    println()
    println()
    randomTicket()
}

/**
 * 티켓
 */
fun randomTicket(){
    val eventTitles = listOf<String>("요리 축제", "장난감 전시회", "패션 런어웨이", "프로야구", "음악회")
    val eventRanks: HashMap<Char, Int> = hashMapOf<Char,Int>()
    eventRanks['N'] = 1000
    eventRanks['H'] = 3000
    eventRanks['F'] = 5000
    eventRanks['S'] = 10000

    println("eventTitles = ${eventTitles}")
    println("eventRanks = ${eventRanks}")

    // 티켓 발권
    val ticketList = arrayListOf<Map<String,Any?>>()
    var cash  = 20000
    while(cash >0){
        // 랜덤하게 이벤트 제목 0 ~ 4
        // Math.random() : 0.0 ~ 1.0 사이의 값을 랜덤하게 뽑아냄 (1.0은 안나옴)
        val rEvent: Int = (Math.random() * eventTitles.size).toInt()
        val rRankNumber: Int = (Math.random() * 100).toInt() + 1    // (0 ~ 99) + 1

        val rRank: Char = when(rRankNumber) {
            in 91..100 -> 'S'   // 10%
            in 71..90 -> 'F'    // 20%
            in 41..70 -> 'H'    // 30%
            else -> 'N'
        }

        println("eventRanks[rRank] = ${eventRanks[rRank]}")

        if(cash < eventRanks.getValue(rRank)) break

        // 티켓 맵 발권
        val ticket = mapOf("title" to eventTitles[rEvent],
            "rank" to rRank,
            "price" to eventRanks[rRank],
            "date" to Date())

        cash -= eventRanks.getValue(rRank)  // 예외가 날 수도 있음

        ticketList.add(ticket)
    }

    println()
    println("티켓 발권 리스트")
    for( (i,ticket) in ticketList.withIndex()) {
        printTicket(ticket, i)
    }
}

fun printTicket(ticket: Map<String, Any?>, num: Int) {
    val df = java.text.SimpleDateFormat("yyyy년 MM월 dd일")
    val printed = """ 
        ======================================
        *** ${if(ticket.getValue("rank")=='S') "VIP" else ""} 티켓  *** [00${num+1}]
        '${ticket.getValue("title")}' event
                rank ${ticket.getValue("rank")} / ${ticket.getValue("price")}원
        ${df.format(ticket.getValue("date"))} 까지
        ======================================
    """.trimIndent()
    println("$printed\n")
}