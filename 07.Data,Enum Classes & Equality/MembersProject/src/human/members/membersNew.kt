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
                      var password: String = "1234")


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

}