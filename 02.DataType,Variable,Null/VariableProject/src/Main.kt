import my.givenName

fun main(args: Array<String>) {
    val favNumber: Int = 7
    // favNumber = 3    // err
    var myAge = 11
    myAge = 12
    myAge++
    myAge = myAge + 1
    myAge += 1

    println("myAge = $myAge")
    println("favNumber. = ${favNumber.inc()}")
    println("favNumber = $favNumber")

    givenName = "John"
    my.givenName = "Alice"
    my.printMyName()
}
