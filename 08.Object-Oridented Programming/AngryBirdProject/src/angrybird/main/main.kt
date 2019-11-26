package angrybird.main

import angrybird.birds.*

class GameStage1 {

    fun run() {
        // 클래스 상속 다형성 Flock => Red, Blues, Chuck
        println()
        listOf<Flock>(Red("길동"), Red("영희"),
            Blues("안나"), Blues("대산"),
            Chuck("Elle"), Chuck("Mike"))
            .forEach {
                with(it) {
                    readyForShoot() // Flock
                    adjustAngleLength() // Flock
                    flyAfterShoot() // 각 하위 클래스마다 고유하게 재정의된 함수가 호출 override 된게 먼저 우선
                    crashWithDamage() // 각 하위 클래스마다 고유하게 재정의된 함수가 호출 override 된게 먼저 우선
                    landingForEnd() // Flock
                }
            }
    }

}

fun main() {
    GameStage1().run()
}