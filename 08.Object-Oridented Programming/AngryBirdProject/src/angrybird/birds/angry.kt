package angrybird.birds

// 새: 이름 공격력 가중치 상태 컬러

enum class Color(var hexColor: String) // 0xFF => 255
{
    RED("FF0000"), GREEN("00FF00"), BLUE("0000FF"),
    BlACK("000000"), YELLOW("FFFF00"), WHITE("FFFFFF")
}

enum class Status(val exp: String){
    NONE("비행 시작 전의"), READY("새총 위에 준비된"), SHOT("발사된"),
    FLYING("날아가는"), CRASHED("충돌한"), END("비행을 완료")
}

private val LENGTH = 20

abstract class Flock {
    lateinit var name: String
    open val color: Color = Color.RED
    var power: Double = 10.0
    open val weight: Double = 1.1
    var status: Status = Status.NONE
    open val type: String = "Red"    // 신규 추가

    override fun toString(): String {
        return "${status.exp} '$name' ${type}새 (power=$power, weight=$weight)"
    }

    protected fun getRandom(max: Int = 10) = (Math.random() * max).toInt() + 1
    protected fun getDamage() = power * weight * getRandom()

    // 새총 위에 올려지다.
    fun readyForShoot(){
        println("step1: ${this}가 새총 위에 올려지다")
        this.status = Status.READY
    }

    // 고무줄을 당기다.
    fun adjustAngleLength(){
        println("step2: ${this}가 고무줄이 당겨져 발사되다")
        this.power += getRandom(LENGTH) * this.weight
        println("\t >> 결정된 power: $power")
        this.status = Status.SHOT
    }

    // 발사되어 날아가다
    // abstract : public open이 기본적으로 들어있음
    abstract fun flyAfterShoot()


    // 장애물에 부딪혀 충격을 주다.
    abstract fun crashWithDamage()


    // 비행을 마치다
    fun landingForEnd(){
        println("step5: ${this}가 비행을 마치다")
        println("-".repeat(80)+"\n")
        this.status = Status.END
    }
}

class Red(_name: String): Flock(){

    init{
        super.name = _name
    }

    override fun flyAfterShoot() {
        println("step3: ${this}가 공중으로 날아가다.")
        this.status = Status.FLYING
    }

    override fun crashWithDamage() {
        println("step4: ${this}가 장애물에 부딪혀 충격을 주다.")
        println("\t >> 입힌 총 대미지: ${java.lang.String.format("%.2f", getDamage())} 점")
        this.status = Status.CRASHED
    }
}

class Blues(_name: String): Flock(), Splitter {
    init {
        super.name = _name
        super.power = 8.0
        status = Status.NONE
    }

    override val color: Color = Color.RED

    override val weight: Double = 1.3

    override val type: String = "Blues"

    // interface Splitter 재정의
    override fun splitBirds(){
        println("\t >> 짐, 제이크, 제이 세마리 새들로 분리되어 날아간다")
    }

    // interface Splitter 재정의
    override fun splitDamage(vararg birds: String){
        for(bird in birds){
            println("\t >> '${bird}'가 장애물에 부딪혀 충격을 주다 ")
            println("\t >> 입힌 총 대미지: ${java.lang.String.format("%.2f", getDamage())} 점")
        }
    }

    // Flock() 재정의
    override fun flyAfterShoot() {
        println("step3: ${this}가 공중으로 날아가다.")
        splitBirds()
        this.status = Status.FLYING
    }

    // Flock() 재정의
    override fun crashWithDamage() {
        println("step4: ${this}")
        splitDamage("Jim Blue새","Jake Blue새", "Jay Blue새")
        this.status = Status.CRASHED
    }

}

interface Splitter {
    fun splitBirds()
    fun splitDamage(vararg birds: String)
}

fun main() {
//    val bird1 = Red("길동")
//    println("bird1 = ${bird1}")
//    bird1.readyForShoot()
//    bird1.adjustAngleLength()
//    bird1.flyAfterShoot()
//    bird1.crashWithDamage()
//    bird1.landingForEnd()

//    val bird2 = Flock() // err: 추상 클래스는 생성자가 있지만 호출할 음수는 없다. 인스턴스를 생성할 수 없다.
//    var t = Splitter()  // err: 인터페이스는 생성자가 없음

    println()
    listOf<Red>(Red("길동"), Red("영희"), Red("꺽정")).forEach{
        it.readyForShoot()
        it.adjustAngleLength()
        it.flyAfterShoot()
        it.crashWithDamage()
        it.landingForEnd()
    }

    listOf<Blues>(Blues("철수"), Blues("안나"), Blues("대신"))
        .forEach{
            with(it){
                readyForShoot()
                adjustAngleLength()
                flyAfterShoot()
                crashWithDamage()
                landingForEnd()
            }
    }
}