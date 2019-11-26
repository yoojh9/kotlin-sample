package angrybird.birds

interface Sing {
    fun singASong(sub: String = "")
}

// 인터페이스는 구체화 함수와 추상 함수를 둘다 가질 수 있다 (java 8 ~)
interface SingWell: Sing {
    fun singASongVeryWell(sub: String = "Very Well"){
        singASong(sub)
    }
}

interface SingPro: Sing, SingWell {
    fun singASongLikePro(){
        singASongVeryWell("Very Well Like a Pro!")
    }
}

class Singer: SingPro {
    override fun singASong(sub: String) {
        println("I sing a song $sub")
    }
}

fun main() {
    Singer().singASong()
    Singer().singASongVeryWell()
    Singer().singASongLikePro()
}