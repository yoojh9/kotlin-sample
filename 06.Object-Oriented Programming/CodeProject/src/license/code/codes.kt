package license.code

/**
 * internal, private, public은 패키지 수준(top-level 수준)의 선언과 정의에서 쓰일 수 있다
 * 단 protected는 패키지 탑 레벨의 수준에서는 상속이 없으므로 클래스 레벨 수준에서만 사용할 수 있다.
 */


fun getCode(pre: String?, len: Int?): String {
    return Code(pre ?: "", len ?: 8)._c
}

fun getCode2(pre: String?, len: Int?) = Code(pre ?: "", len ?: 8)._c

/**
 * internal : 모듈 안에서 사용 가능
    - 모듈
        - an intelliJ Idea module
        - a maven project
        - a gradle source set
        - a set of files compiled with one invocation of the ant task
 * protected: 부모 자식 클래스 안에서 사용
 */
internal fun getLicenseKey(lcpre: String? = "", count: Int = 4) : String {
    var str: String = ""
    for(i in (1..count)) {
        str += getCode("", 8)
    }
    return lcpre + str
}


// 주어진 길이만큼 영문 대문자와 숫자들로 이루어진 임의의 코드 문자열을 생성하는 클래스
// 디폴트로 (public) 클래스
// private class : license.code 패키지 안에서만 쓸 수 있음. 다른 패키지에서는 볼 수 없음.
private class Code(pre: String = "", len: Int = 8){
    // 프로퍼티도 디폴트는 public
    // publiv val _c: String
    val _c: String
    init {
        _c = pre + "_" + generateCode(len)
    }

    // private : 내부 클래스 내에서만 쓸 수 있음
    private fun generateCode(upto: Int): String {
        val chars = CharArray(upto) // 생성자 호출. 만들어진 코드 저장 용
        val nums = ('0'..'9').toList()  // 번호가 있는 문자 리스트 ['0','1','2', ... ,'9']
        val alphas = CharRange('A','Z').toList()    // ['A','B','C', ... ,'Z']

        for(i in 0 until upto) {
            val ran = (Math.random()*10).toInt()    // 0 ~ 9 까지 랜덤
            chars[i] = if(ran % 2 == 0) // even
                nums[(Math.random() * nums.size).toInt()]
            else
                alphas[(Math.random() * alphas.size).toInt()]
        }

        return chars.joinToString("")
    }
}

fun main(args: Array<String>) {
    println("Code()._c = ${Code()._c}")
    println("Code(\"good\")._c = ${Code("good")._c}")
    println("Code(\"long\", 16)._c = ${Code("long", 16)._c}")
}