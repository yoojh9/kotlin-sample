package monsters

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

enum class Monster {
    WaterMon, FireMon, EarthMon, WindMon    // ordinal 0 ~ 3
}

enum class Clan {
    DarkSide, LightSide
}

class Player {

    /**
     * lateinit : 의도적으로 변수 초기화를 지연 시킴
     */
    // 프로퍼티 초기화는 var nick: String = ""이나 init{} 블록에서 해야되는데,
    // 하지 않게 되면 Property must be initialized or be abstract 에러가 뜸
    lateinit var nick: String
    lateinit var leadMonster: Monster

    // 처음 참조되는 순간에 초기화를 딱 한번만 실행하겠다. 이후에는 다시 실행되지 않음
    // val이므로 여러번 불려도 맨 처음에 결정된 값으로..
    val clan: Clan by lazy {
        // 클랜 결정 초기화 코드 블럭
        this.selectClan()
    }

    private fun selectClan(): Clan {
        var mySide: Clan = Clan.DarkSide

        Clan.values().forEach{
            println("${it.ordinal}: ${it.name} 진영 \t")
        }
        print("player 진영을 선택하세요 => ")

        try {
            val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
            val selection = br.readLine()
            if (selection == "1") mySide = Clan.LightSide
        } catch(e: IOException) {
            e.printStackTrace()
        }
        return mySide
    }

    override fun toString(): String {
        return "Player(nick='$nick', leadMonster=$leadMonster, clan=$clan)"
    }
}


fun main() {
    val p1: Player = Player()

    // lateinit은 초기화를 시키지 않고 호출하면 예외 발생
    // println(p1.nick) // UninitializedPropertyAccessException: lateinit property nick has not been initialized

    p1.nick = "guest" + (Math.random() * 1000000).toInt()
    p1.leadMonster = Monster.FireMon
    println(p1.nick)
    println(p1.leadMonster)
    println(p1.clan) // 참조 시점에 lazy 초기화 진행
    println(p1.clan) // 초기화 위임 블럭은 한번만 실행
    println(p1.clan)
    println(p1.clan)
    println("플레이어: ${p1}")
    // p1.clan = Clan.LightSide // err

}