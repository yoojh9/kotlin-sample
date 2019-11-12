package network.url

class UrlChecker {
    private val DEF_URL = "http://www.human.com"
    var url: String = initMyUrl()

    /**
     * custom setter, getter
     */
    // field: field 그 자체를 의미. custom getter, setter에서 사용
    var description: String? = null
        get() = field ?: "설명이 아직 없네요."
        set(value) {
            if(!value.isNullOrEmpty())
                field = value
        }

    // 코틀린 1.1부터는 get()으로 추론하여 타입 생략 가능
    // val 프로퍼티이므로 setter 생성 불가
    val isHttp get() = url.startsWith("http")

    fun showUrl(){
        println("""
            ---------------------------
                URL : $url
                설명: $description
                http 프로토콜: ${if(this.isHttp) "YES" else "NO"}
            ---------------------------
        """.trimIndent())
    }

    private fun initMyUrl(): String {
        println("url 필드 선언 시 초기화 ")
        return "";
    }

    // 2차 생성자
    constructor(_url: String?){
        this.url = _url ?: DEF_URL
        println("2차 생성자 실행")
    }

    init {
        println("초기화 블록 init 실행")
    }
}

fun main(args: Array<String>) {
    val url1 = UrlChecker("http://www.google.com") // 2차 생성자만 지원
    //println("url1.url = ${url1.url}")   // getter
    url1.description = "검색 엔진 구글입니다" // custom setter 호출
    url1.showUrl()
    println()

    val url2 = UrlChecker(null)
    //println("url2.url = ${url2.url}")   // getter
    url2.description = "휴먼 데이터 센터입니다"
    url2.showUrl()
    println()

    val url3 = UrlChecker("ftp://www.naver.com")
    url3.description = null
    url3.showUrl()
}