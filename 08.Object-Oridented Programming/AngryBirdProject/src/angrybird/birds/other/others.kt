package angrybird.birds.other

import angrybird.birds.*
import java.lang.Math.random

interface SonicAttack {
    val SONIC_POWER get() = 100.0
    fun getPowerWithSonicAttack(br: Flock): Double {
        println("\t >> ${br}가 음파 공격으로 추가 파워 ${SONIC_POWER}를 얻다.")
        return SONIC_POWER
    }
}

interface  AcceleratorII: AcceleratorI {
    override val MORE_POWER_WEIGHT: Double
        get() = random() * 20 + 1.0

    fun getLuckyBonusPower(): Double {
        val lucky = (random() * 2).toInt()  // 0 or 1
        return if (lucky == 1) 100.0 else 10.0
    }
}

interface HeroBadge {
    fun showBadge(bird: Flock){
        println("${bird}의 (((((( HERO )))))) badge! ")
    }
}

// Outer 외부 클래스
class SuperHeroes: HeroBadge {
    private val title: String
    init {
        title = "<< Super Hero >>"
    }

    /**
     * nested class 중첩 클래스
     */
    // SuperHeroes.Red2
    class Red2(_name: String): Red(_name), SonicAttack{
        // $title : 중첩 클래스는 안쪽에 있다고 하더라도 외부 클래스의 어떠한 자원도 쓸 수 없다
        override val type: String = "Red2"

        override fun flyAfterShoot() {
            println("step3: ${this}가 공중으로 날아가다.")
            this.power += getPowerWithSonicAttack(this)
            this.status = Status.FLYING
        }

        override fun crashWithDamage() {
            println("step4: ${this}가 장애물에 부딪혀 충격을 주다.")
            println("\t >> 입힌 총 대미지: ${java.lang.String.format("%.2f", getDamage())} 점")
            this.status = Status.CRASHED

            // showBadge()  // err 접근할 수 없음.
        }
    }

    /**
     * inner class 내부 클래스
     */
    inner class Nova(_name: String): Flock(), SonicAttack, AcceleratorII {
        override val color: Color = Color.WHITE
        override val weight: Double = 10.0

        // nested class에서는 outer class의 리소스가 접근이 안됐는데, inner class에서는 가능하
        override val type: String = "${title} Nova"

        init {
            super.name = _name
        }

        override fun flyAfterShoot() {
            println("step3: ${this}가 공중으로 날아가다.")
            accelatorSpeed()
            this.status = Status.FLYING
        }

        override fun crashWithDamage() {
            println("step4: ${this}가 장애물에 부딪혀 충격을 주다.")
            println("\t >> 입힌 총 대미지: ${java.lang.String.format("%.2f", getDamage())} 점")
            this.status = Status.CRASHED
        }

        override fun accelatorSpeed() {
            val sonic = getPowerWithSonicAttack(this)
            this.power += MORE_POWER_WEIGHT * (power + sonic + getLuckyBonusPower())
            println("\t >> ${this}가 비행 가속도를 받아서 파워가 ${String.format("%.2f", power)}로 증가하다")
        }

        fun showMyBadge(){
            super@SuperHeroes.showBadge(this)
        }
    }
}

fun play(bird: Flock){
    println()
    with(bird){
        readyForShoot()
        adjustAngleLength()
        flyAfterShoot() // override call
        crashWithDamage()  // override call
        landingForEnd()
    }
}

fun main() {
    val r2: SuperHeroes.Red2 = SuperHeroes.Red2("오공") // 중첩클래스. 중첩클래스의 outer 클래스는 패키지에 불과..
    val nv: SuperHeroes.Nova = SuperHeroes().Nova("팔계") // inner class Nova의 생성자는 클래스의 리시버 안에서 불릴 수 있다.
    println("nested class r2 => ${r2.javaClass}")   // class angrybird.birds.other.SuperHeroes$Red2
    println("nested class r2 => ${nv.javaClass}")   // class angrybird.birds.other.SuperHeroes$Nova

    play(r2)
    play(nv)

    nv.showMyBadge()

}