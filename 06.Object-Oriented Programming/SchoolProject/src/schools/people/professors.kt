package schools.people

// 교수님 클래스 init block
class Professor(_name: String, _age: Int = 30) {
    var name: String? = null
    val age: Int = _age

    // 주요 생성자의 초기화 블럭
    // init 안의 코드는 모든 객체가 만들어질 때 반드시 실행됨
    init {
        name = if(_name.isNotEmpty() && _name.isNotBlank())
                    _name.toUpperCase()
                else "Guest"
        println("$name 교수님($age) 인스턴스")
    }
}


// 교수님 클래스 2nd constructors
// 클래스에 body 안쪽에 정의된 생성자(자바와 같이)
class Professor2(_name: String, _age: Int = 30) {
    var name: String? = null
    val age: Int = _age

    // 주요 생성자의 초기화 블럭
    // init 안의 코드는 모든 객체가 만들어질 때 반드시 실행됨
    init {
        name = if(_name.isNotEmpty() && _name.isNotBlank())
            _name.toUpperCase()
        else "Guest"
        // this.fav = 1.0  // can not be initialized before declaration. 선언 되기 전에는 초기화 할 수 없음
        println("$name 교수님($age) 인스턴스")
    }

    var major: String ="인문학"
    var fav: Double = 0.0

    // 2차 생성자가 이름과 나이는 주요 생성자에게 위임하고 ->  init 실행 -> 2차 생성자의 major 초기화 시킴 -> 메모리에 객체 만들어짐
    constructor(_name: String, _age: Int, _major: String)
            : this(_name, _age){
        this.major = _major
    }

    // 위의 2차 생성자에게 위임
    constructor(_name: String, _age: Int, _major: String, _fav: Double)
            : this(_name, _age, _major){
        this.fav = _fav
    }

    fun showStatus(num: Int) {
        val status = """
            === $num 교수 재직 증명 ===
            이름: $name   ${if(fav > 30.0) "** 우수교수 **" else ""}
            나이: $age 세
            전공: ${this.major} 
            평가: ${fav} pt
        """.trimIndent()
        println(status)
    }
}

fun main(args: Array<String>) {
    val p1 = Professor2("david", 39) // primary constuctor
    val p2 = Professor2("alice")    // primary constuctor
    val p3 = Professor2("park", 45, "경제학")  // secondary constuctor
    val p4 = Professor2("susan", 22, "법학", 50.0) // secondary constructor

    val pfs: List<Professor2> = arrayListOf<Professor2>(
        p1,p2,p3,p4
    )

    val piter = pfs.iterator()
    var num = 1
    while(piter.hasNext() == true){
        val pf: Professor2 = piter.next()
        pf.showStatus(num++)
    }
}