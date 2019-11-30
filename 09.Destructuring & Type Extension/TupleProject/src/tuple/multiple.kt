package tuple

fun main() {
    /**
     * 다중 선언, Destuctured 선언
     */
    // tuple, (x,y,z)  mixed type
    // destructuring : 분리 해체 기반 선언, 객체가 쪼개짐, data class는 기본적으로 destructuring 제공

    /**
     * Pair
     */
    // Pair는 data class 이므로 first는 사실 component1() 메소드를 호출한 것과 같음
    Pair(1,'A').first // 1
    Pair(1,'A').second // 'A'
    Pair(1,'A').component2() //'A'

    val(num, char) = Pair<Int,Char>(1,'A')
    val(num2: Int, char2: Char) = Pair<Int,Char>(1,'A')
    println("num = ${num}, char = ${char}")


    /**
     * Triple
     */
    val(i, you, we) = Triple("my","your","our")
    val t3 = Triple("my","your","our").third  // component3()
    println("i = ${i}, you = ${you}, we = ${we}, $t3")


    /**
     * IndexedValue destuctured
     */
    for((i, c) in ('A'..'Z').withIndex()) // (i,c) -> tuple 객체를 의미, IndexedValue
        println("$i => $c \t")
    println()


    /**
     * map destuctured
     */
    val planets = mapOf<Int, String>(0 to "earth", Pair(1, "mars"),
        2.to("jupiter"), 3 to "saturn", 4 to "pluto")

    for((k,v) in planets) // 다중선언, Map.Entry<K,V>, K:component1(), V: component2()
        println("$k => $v")
    println()
    // Map.Entry<K, V>.component1(): K = key
    // Map.Entry<K, V>.component2(): V = value

    // 맵에 특정한 함수를 적용시키는데, key와 value에 함수의 공식이 적용됨. 변환된(transform) 키와 값을 묶어서 맵으로 리턴
    planets.mapValues { (k, v) -> "solar system $k: $v" }
    planets.mapValues { (_,v) -> "solar system: $v"}
        .forEach{ println(it.value) } // it: Map.Entry  // k 가 쓰이지 않을때는 _ 사용


    /**
     * data class
     */
    val cr1 = MyColor("556B2F", "DarkOliveGreen", 50.0, true)
    val (hex, name) = cr1   // cr1.component1(), cr1.component2()번이 자동으로 호출됨
    //val used = cr1.component4()
    val (_,_,_,used) = cr1  // 앞에 3개는 사용하지 않음
    val (R,G,B) = cr1.getEachHex()

    println("cr1: $cr1")
    println("hex: 0x$hex, name: $name, fav: ${cr1.component3()}, used: $used")
    println("R: 0x$R, G: 0x$G, B: 0x$B")
    // println("${cr1.component5()}")  // err

    val (crR, crG, crB, crA) = cr1.getRGBA()

    for( (a,b,c,d) in listOf( RGBA(255,0,0, 128),
                    RGBA(0,0,255, 64),
                    RGBA(255, 255, 255, 200)))
        println("color => R: $a, G: $b, B: $c, alpha: $d")

}

/**
 * Data class
 */
// RGB, HSI/V
val BLACK = "000000" // hexadecimal

// data class 는 componentN() 메소드를 구현하고 있기 때문에 분리 해체가 가능하다
// DarkOliveGreen      55 6B 2F     85 107 45
data class MyColor(val hexCode: String = BLACK, val name: String = "Black",
                    val fav: Double = 0.0, val used: Boolean = false){

    private val r: String = hexCode.slice(0..1)
    private val g: String = hexCode.slice(2..3)
    private val b: String = hexCode.slice(4..5)

//    fun getEachHex() = Triple(hexCode.slice(0..1),
//                        hexCode.slice(2..3),
//                        hexCode.slice(4..5))

    fun getEachHex() = Triple(this.r, this.g, this.b)

    fun getRGBA() = RGBA(r.toInt(16), g.toInt(16), b.toInt(16), 0)
}

data class RGBA(val r: Int, val g: Int, val b: Int, val a: Int)