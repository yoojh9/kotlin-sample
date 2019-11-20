package human.members

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val mb5 = MemberNew() // data class, DTO
    val mb6 = MemberNew() // 그 내용은 일치하나 주소가 다른 두 개의 멤버 객체

    if(mb5.equals(mb6)) println("mb5와 mb6는 내용이 equals() 같습니다 ")
    if(mb5 == mb6) println("mb5와 mb6는 내용이  == 같습니다")
    if(mb5 != mb6) println("mb5와 mb6는 내용이  != 같지 않습니다")

    if(mb5 === mb6) println("mb5와 mb6는 내용과 주소도 === identical 같습니다")
    if(mb5 !== mb6) println("mb5와 mb6는 내용이나 주소 !== identical 같지 않습니다")

    // 문자열 객체 메모리 비교
    println()
    val str0 = "xyz"
    val str1: String = "ABCDE"
    val str2 = str1
    val str3 = ('A'..'E').joinToString("")
    val str4 = "ABCDE"
    val str5 = String("ABCDE".toCharArray()) // charArrayOf('A','B','C','D','E')

    println("내용 str0 = ${str0} str1 = ${str1} str2 = ${str2} str3 = ${str3} str4 = ${str4} str5 = ${str5}")

    println()
    println("equal: str1 == str0 => ${str1 == str0}")
    println("identical: str1 === str0 => ${str1 === str0}")
    println()
    println("equal: str1 == str2 => ${str1 == str2}")
    println("identical: str1 === str2 => ${str1 === str2}")
    println()
    println("equal: str1 == str3 => ${str1 == str3}")
    println("identical: str1 === str3 => ${str1 === str3}")
    println()
    println("equal: str1 == str4 => ${str1 == str4}")
    println("identical: str1 === str4 => ${str1 === str4}") // 같은 상수 객체를 가리키므로 true
    println()
    println("equal: str1 == str5 => ${str1 == str5}")
    println("identical: str1 === str5 => ${str1 === str5}")

    val str6a = String(charArrayOf('A','B','C','D','E'))
    val str6b = String(charArrayOf('A','B','C','D','E'))
    println()
    println("equal: str6a == str6b => ${str6a == str6b}")
    println("identical: str6a === str6b => ${str6a === str6b}")


    val memberMgr = MemberManager()
    memberMgr.joinMember(MemberNew(name="손오공", loginName = "son1", password = "1234"))
    memberMgr.joinMember(MemberNew(name="앨리스", loginName = "alice", password = "1234"))
    memberMgr.joinMember(MemberNew(name="홍길동", loginName = "hong", password = "1234"))

    val br: BufferedReader = BufferedReader(
        InputStreamReader(System.`in`)
    )

    println("** 로그인 체크 **")
    print(" >> login:")
    val login = br.readLine()   // 개행 문자 만나기 전까지 입력된 모든 문자
    print(" >> password:")
    val password = br.readLine()

    println("\n\n 로그인 결과 => " + memberMgr.loginMember(login, password) )
}
