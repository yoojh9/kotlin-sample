package jhpub.books

// 코틀린에서는 Body가 없는 클래스도 가능
// class Book {}   // 새로운 자료형 타입 정의

// 자바와는 다르게 파일명과 클래스 이름이 일치하지 않아도 됨
// 1번 방법
/*
class Book {
    /**
     * 내용
     *  - 프로퍼티: 외부에서 내부 데이터를 조작하거나 접근할 수 있음
     */
    val publisher: String = "JH출판사" // 초기화된 값이 타입을 inference 해주므로 타입 명시 안해도 됨
    var title: String? = null

    /**
     * 행위
     *  - 메소드
     */
    fun showBook() {
        println("'${title ?: "no name"}' 책. $publisher 발행")
    }
}
*/


/**
 * Primary 생성자(주 생성자) 이용
 *  - 값을 바로 받아서 인자처럼 쓸 수도 있고 필드로도 사용할 수 있음
 */
// 2번 방법
// 보라색 변수는 필드라는 의미
// 주요 생성자는 ()안에 var 또는 val로 인자들을 나열하면 필드로도 사용할 수 있다
// 기본 인자 적용 => named parameter 적용하여 호출도 가능
class Book(var title: String? = null, var author: String? = "작자미상") {
    val publisher: String = "JH출판사"

    fun showBook(){
        println("'${title ?: "no name"}' 책. $author 지음,  $publisher 발행")
    }
}


fun main(args: Array<String>) {

    // 1번 방법
    /*
    val myBook : Book = Book()  // contructor 생성자 호출, 객체 생성(인스턴스 화), jvm 힙 공간에 생
    myBook.publisher    // 필드 내용 참조
    // myBook.publisher = "xyz"    // err val read only
    myBook.title = "코틀린의 등장"

    println("myBook = ${myBook} ${myBook.javaClass.name}")
    println("myBook.publisher = ${myBook.publisher}")
    println("myBook.title = ${myBook.title}")
    println()
    myBook.showBook()
    */

    // 2번 방법: 주요 생성자
    // val myBook = Book("코틀린의 등장", "홍길동")
    val myBook = Book()
    val myBook2 = Book("코틀린의 등장")
    val myBook3 = Book(author = "홍길동")

    println("myBook = ${myBook} ${myBook.javaClass.name}")
    println("myBook.publisher = ${myBook.publisher}")
    println("myBook.title = ${myBook.title}")
    myBook.showBook()
}