package schools.people


/**
 * 기본 default 주요 생성자가 생략된 것
 */
// class Student
// class Student {}
// class Student() {}
// class Student public constructor(){}    // 주요 생성자
// class Student private constructor(){}   // 클래스 안에서만 생성자를 혼자 씀 (자바 static)


/**
 * 1. 주요 생성자 - 인자 사용
 *  - 인자를 이용해서 필드 초기화
 *  - 주요 생성자는 클래스에서 단 하나만 정의할 수 있음
 */
class Student(name: String?, age: Int, score: Float = 1.0f){
    val realName: String = name?: "guest"    // read-only property
    val email: String = "$realName@schools.org"
    val joinedAge: Int = age
    var realScore: Float = score            // read-write property

    fun showStatus(){
        // this: 클래스의 객체 자기 자신
        val status = """
           ===      학생 재학증명     ===
                이름: $realName
                나이: $joinedAge 세
                학점: $realScore pt
                이메일: ${this.email}
           ==============================
        """.trimIndent()
        println(status)
    }
}

/**
 * 2. 주요 생성자 - 인자를 필드로 사용
 *  - 주요 생성자는 인자인 동시에 필드화 시킬 수 있음
 *  - 예시에서 score는 인자이며 필드는 아
 */
class Student2(val name: String?, val age: Int, score: Float = 1.0f) {
    val email: String = "$name@schools.org"
    val realScore: Float = score
    private val scholarship: Boolean = (this.age <= 20) && (realScore >= 3.8f)  // 외부에서 접근할 수 없음

    fun showStatus(){
        // this: 클래스의 객체 자기 자신
        val status = """
           ===      학생 재학증명     ===
                이름: $name   ${if(scholarship) "*장학생*" else ""}
                나이: $age 세
                학점: ${this.realScore} pt
                이메일: ${this.email}
           ==============================
        """.trimIndent()
        println(status)
    }
}

fun main(args: Array<String>) {
    // val s: Student = Student() // 객체가 인스턴스화
    val s1: Student = Student("Amy", 22)
    val s2: Student = Student(null, 10, 2.0f)
    val s3: Student2 = Student2("Yui", 19, 4.0f)
    val s4: Student2 = Student2("John", 20, 3.3f)

    // s1.email = "king@scholl.org" // 외부에서 호출해서 set할 수 없
    s1.realScore = 2.9f // set 설정
    // s3.scholarship : private 접근제한자라 밖에서 접근할 수 없음

    s1.showStatus()
    s2.showStatus()
    s3.showStatus()
    s4.showStatus()

}