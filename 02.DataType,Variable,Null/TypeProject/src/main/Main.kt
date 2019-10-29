package main


fun main(args: Array<String>) {
    val a: Byte = 127
    val b: Short = 30000
    val c: Int = 2000
    val d: Long = 2303000000L   // long형의 리터럴
    val f1: Float = 3.14f
    val f2: Float = 3.14F
    val g: Double = 32.341421545
    val h1: Boolean = true
    val h2 = false
    val a2 = 1234

    val i = 'A' // Char
    val i2: Char = 'B'
    val i3: Char
    i3 = 'C'

    val str: String = "ABC"

    println("Basic Types::")
    println("a = ${a} ${a.javaClass}")
    println("b = ${b} ${b.javaClass}")
    println("c = ${c} ${c.javaClass}")
    println("d = ${d} ${d.javaClass}")
    println("f = ${f1} ${f1.javaClass}")
    println("g = ${g} ${g.javaClass}")
    println("h = ${h1} ${h1.javaClass}")
    println("i = ${i} ${i.javaClass}")
    println("str = ${str} ${str.javaClass}")
}