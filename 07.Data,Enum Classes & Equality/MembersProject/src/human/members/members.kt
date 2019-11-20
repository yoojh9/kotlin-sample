package human.members

// 데이터 단위 클래스 (VO / DTO)
// => 필드, 세터/게터, 생성자, toString(), equals(), hashCode(), 복제(copy)
class Member() { // : Any
    var id: Int = 0
    var name: String  = "no name"
    var activityPoints: Double = 1.0
    var age: Int = 20
    var premiumLevel: Boolean = false
    var loginName: String = "guest"
    var password: String = "1234"

    // 복사, 복제
    fun copy(id: Int = this.id, name: String = this.name,
             activityPoints: Double = this.activityPoints,
             age: Int = this.age,
             premiumLevel: Boolean = this.premiumLevel,
             loginName: String = this.loginName,
             password: String = this.password)
    = Member(id, name, activityPoints, age, premiumLevel, loginName, password)

    // 자바스러운..
    constructor(id: Int, name: String,
                activityPoints: Double, age: Int,
                premiumLevel: Boolean,
                loginName: String, password: String):this(){
        this.id = id
        this.name = name
        this.activityPoints = activityPoints
        this.age = age
        this.premiumLevel = premiumLevel
        this.loginName = loginName
        this.password = password
    }

    constructor(name: String, age: Int,
                loginName: String, password: String):this(){
        this.name = name
        this.age = age
        this.loginName = loginName
        this.password = password
    }



    override fun toString(): String {
        return "Member(id=$id, name='$name', activityPoints=$activityPoints, age=$age, premiumLevel=$premiumLevel, loginName='$loginName', password='$password')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Member

        if (id != other.id) return false
        if (name != other.name) return false
        if (activityPoints != other.activityPoints) return false
        if (age != other.age) return false
        if (premiumLevel != other.premiumLevel) return false
        if (loginName != other.loginName) return false
        if (password != other.password) return false

        return true
    }

//    override fun hashCode(): Int {
//        var result = id
//        result = 31 * result + name.hashCode()
//        result = 31 * result + activityPoints.hashCode()
//        result = 31 * result + age
//        result = 31 * result + premiumLevel.hashCode()
//        result = 31 * result + loginName.hashCode()
//        result = 31 * result + password.hashCode()
//        return result
//    }
}


// 회원 데이터 ------- schema 스키마 정의
// 번호
// 이름
// 나이
// 로그인 아이디
// 암호(패스워드)
// 프리미엄 회원 유무
// 활동 포인트
fun main(args: Array<String>) {
    val humanMembers = arrayListOf<Member>(
        Member(), Member("홍길동",22,"hong","1111")
    )
    humanMembers[1].id = 1

    val mb2 = Member(2,"안나",2.0,21,true,"anna","aabb")

    val mb3 = mb2.copy()
    val mb4 = mb2.copy(name="안나동생", age=19, loginName = "anna2")

    humanMembers.add(mb2)
    humanMembers.add(mb3)
    humanMembers.add(mb4)

    humanMembers.forEach{ println("member : $it") }
}