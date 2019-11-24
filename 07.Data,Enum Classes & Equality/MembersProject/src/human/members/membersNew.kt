package human.members

/**
 * data class
  - data class는 반드시 하나 이상의 주요 생성자 property가 선언되어 있어야 된다.
  - 이렇게만 해도 Member() 클래스와 거의 동일한 기능을 제공한다.
  - 필드, 세터/게터, 생성자, toString(), equals(), hashCode(), copy()
  - Pair(), Tuple()도 data class이
 */
data class MemberNew( var id: Int = 0,
                      var name: String  = "no name",
                      var activityPoints: Double = 1.0,
                      var age: Int = 20,
                      var premiumLevel: Boolean = false,
                      var loginName: String = "guest",
                      var password: String = "1234",
                      var ms: Membership =  Membership.BASIC)

enum class Membership(var aPoint: Double = 0.0, val desc: String = "기본 회원 등급"){
    BASIC, FAMILY(3000.0, "가족 회원 등급"),
    PREMIUM(5000.0, "프리미엄 회원 등급"),
    VIP(10000.0, "최고 회원 등급");   // ※ 세미콜론 넣어서 함수랑 분리해야 함

    fun showCard(){
        println("""
            =============================================
                ${this.name} Membership
                $desc
                point: $aPoint, ${this.ordinal+1} of ${Membership.values().size}
            =============================================
        """.trimIndent())
    }
}

/**
 * 회원 데이터를 관리하는 클래스
 */
class MemberManager {
    private val memberList = ArrayList<MemberNew>()

    // 회원 가입 함수
    fun joinMember(memberNew: MemberNew) {
        when {
            memberNew.loginName.isEmpty() -> {
                println("error: 로그인 아이디가 빈문자열")
                return
            }
            memberNew.loginName.isBlank() -> {
                println("error: 로그인 아이디가 공백문자열")
                return
            }
            memberNew.loginName.length < 4 || memberNew.loginName.length > 10 -> {
                println("error: 로그인 아이디 길이는 4~10만 가능")
                return
            }
            memberNew.loginName == "guest" -> {
                println("error: 로그인 아이디가 guest")
                return
            }
            else -> {
                println("정상 로그인 아이디: ${memberNew.loginName} - ${memberNew.hashCode()}")
            }
        }
        memberNew.id = memberList.size + 1
        this.memberList.add(memberNew)
    }

    // 회원 리스트 출력 함수
    fun showAllMembers() {
        println("=".repeat(110))
        println("   회원 리스트(총 ${memberList.size}명)")
        this.memberList.forEach {
            println(it) // it.toString() 자동 호출
        }
        println("=".repeat(110))
    }


    // 로그인 결과 상수 정의
    private val LOGIN_SUCCESS: Int = 1
    private val LOGIN_PASSWORD_MISMATCH: Int = 11
    private val LOGIN_MEMBER_NOT_FOUND: Int = 13
    private val LOGIN_NAME_EMPTY : Int = 15
    private val LOGIN_PASSWORD_EMPTY : Int = 17


    // 회원 로그인 인증 함수
    fun loginMember(loginName: String, password: String): Int {
        if(loginName.isEmpty() || loginName.isBlank()){
            println("로그인 이름이 비워져 있음")
            return LOGIN_NAME_EMPTY
        }
        if(password.isEmpty() || password.isBlank()) {
            println("로그인 암호가 비워져 있음")
            return LOGIN_PASSWORD_EMPTY
        }

        for(mb in this.memberList){
            if(mb.loginName == loginName) { // 내용만 일치되면 OK
                if(mb.password == password) {
                    println("$loginName 회원님 인증 성공")
                    return LOGIN_SUCCESS
                } else {
                    println("$loginName 회원님 암호 불일치")
                    return LOGIN_PASSWORD_MISMATCH
                }
            }
        }
        println("$loginName 회원을 찾을 수 없음")
        return LOGIN_MEMBER_NOT_FOUND
    }
}

fun findMembership(ap: Double){
    if( ap < 0.0) return
    val ms: Membership = Membership.values().filter{ it.aPoint <= ap }.last()
    println("$ap => $ms , ${ms.desc}")
}

fun findMembership(ap: Double, mb: MemberNew? = null){
    if( ap < 0.0) return
    val ms: Membership = Membership.values().filter{ it.aPoint <= ap }.last()
    println("$ap => $ms , ${ms.desc}")

    // let 안에서의 this는 mb 자체
    // ?.는 safe call이므로  mb가 null일 때는 null pointer exception 에러도 아니고 함수가 실행되지도 않음
    mb?.let {
        it.activityPoints = ap
        it.ms = ms
        it.premiumLevel = (ms == Membership.PREMIUM || ms == Membership.VIP)
        println("\n 회원 : $it \n")

    }
}

fun main(args: Array<String>) {

    // tuples
    val backpack = Pair(10, "검정색 백팩") // 간단한 vo, dto 클래
    println("backpack.toString() = ${backpack.toString()}")
    println("backpack.javaClass = ${backpack.javaClass}")
    println("backpack.first = ${backpack.first}")
    println("backpack.second = ${backpack.second}")

    val backpack2 = Triple(20, "분홍색 숄더백", 200.99f)
    println("backpack.toString() = ${backpack2.toString()}")
    println("backpack.javaClass = ${backpack2.javaClass}")
    println("backpack.first = ${backpack2.first}")
    println("backpack.second = ${backpack2.second}")
    println("backpack2.third = ${backpack2.third}")
    
    /**
     * 7-2. data class
     */
    println()
    val mb0 = MemberNew()
    val mb1 = MemberNew(2,"안나",2.0,21,
        false,"anna","abcd")
    val mb2 = MemberNew(name = "길동", loginName="gildong", activityPoints = 99.9)
    mb2.age = mb2.age + 1 // getter/setter
    mb2.password = "password"

    val mb3 = mb2.copy()
    val mb4 = mb2.copy(name="손오공", loginName="son", password="abcd")

    // 회원가입, 리스트 출력
    println()
    val memberMgr = MemberManager()
    memberMgr.joinMember(mb0)
    memberMgr.joinMember(mb1)
    memberMgr.joinMember(mb2)
    memberMgr.joinMember(mb3)
    memberMgr.joinMember(mb4)

    println()
    memberMgr.showAllMembers()

    /**
     * 7-4. enum
     */
    println()
    Membership.values().forEach { it.showCard() }
    println()
    findMembership(3800.0)
    findMembership(1400.0)
    findMembership(500.0)
    findMembership(5000.0)
    findMembership(9999.0)
    findMembership(10001.0)

    println()
    val mem1 = MemberNew(name = "앨리스", loginName = "alice")
    println("${mem1.name}의 멤버십 ${mem1.ms}")
    findMembership(3100.0, mem1)
    findMembership(5500.0, mem1)
    mem1.ms.showCard()
}