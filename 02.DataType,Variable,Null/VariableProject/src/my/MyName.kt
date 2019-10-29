package my

val familyName = "Hong"
var givenName: String = "GilDong"
// variable : var
// constant : val

fun printMyName(){
    println("My name is '${givenName} $familyName'")
}


fun main(args: Array<String>) {
    givenName = "Alice" // ìž¬í• ë‹¹ reassign var
    // familyName = "Kim"  // error: val cannot be reassigned
    printMyName()
}