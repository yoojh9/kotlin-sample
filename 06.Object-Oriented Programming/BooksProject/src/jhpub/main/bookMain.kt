package jhpub.main

import jhpub.books.Book // 클래스 임포트

fun main() {
    val myBook1 = Book("코틀린의 등장","홍길동")
    val myBook2 = Book()
    val myBook3 = Book("안드로이드 10")
    val myBook4 = Book(author = "구글편집부")
    val myBook5 = myBook1
    myBook5.author = "돌아온 홍길동"

//    myBook1.showBook()
//    myBook2.showBook()
//    myBook3.showBook()
//    myBook4.showBook()
//    myBook5.showBook()

    // 배열 요소의 타입으로서의 클래스
    val myBooks: Array<Book> = arrayOf(myBook1,myBook2,myBook3,myBook4,myBook5)

    for( (i, book) in myBooks.withIndex()) {
        print("book[$i] =" )
        book.showBook()
    }
}