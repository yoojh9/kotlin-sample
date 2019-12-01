package units

val DEF_DATA_UNIT = "kb"
val DEF_LENGTH_UNIT = "m"
val DEF_WEIGHT_UNIT ="kg"

/**
 * 확장 프로퍼티
 */
// val Double.x get() = y *  this
/* 컴퓨터 data size (1 kb)
    8,192   비트(bit)
    1,024   바이트(B)
    1       킬로바이트(KB)
    0.000977    메가바이트(MB)
    9.536743e-7 기가바이트(GB)
    9.313226e-10    테라바이트(TB)
    9.094947e-13    페타바이트(PB)
    8.881784e-16    엑사바이트(EB)
*/
val Double.bit get() = 8192 * this
val Double.b get() = 1024 *  this
val Double.kb get() = 1 *  this
val Double.mb get() = 0.000977 *  this
val Double.gb get() = 9.536743e-7 *  this
val Double.tb get() = 9.313226e-10 *  this
val Double.pb get() = 9.094947e-13 *  this
val Double.eb get() = 8.881784e-16  *  this

/*
길이 length (1m)
1,000   밀리미터(mm)
100     센치미터(cm)
1       미터(m)
0.001   킬로미터(km)
39.370079   인치(inch)
3.28084     피트(ft)
1.093613    야드(yd)
0.000621    마일(mile)
*/
val Double.mm get() = 1000 *  this
val Double.cm get() = 100 *  this
val Double.m get() = 1 *  this
val Double.km get() = 0.001 *  this
val Double.inch get() = 39.370079 *  this
val Double.ft get() = 3.28084 *  this
val Double.yd get() = 1.093613 *  this
val Double.mile get() = 0.000621 *  this

/*
질량 weight(1kg)
1,000,000   밀리그램(mg)
1,000       그램(g)
1           킬로그램(kg)
0.001       톤(ton)
15,432.3584 그레인(grain)
35.273962   온스(oz)
2.204623    파운드(lb)
*/

val Double.mg get() = 1000000 *  this
val Double.g get() = 1000 *  this
val Double.kg get() = 1 *  this
val Double.ton get() = 0.001 *  this
val Double.grain get() = 15432.3584 *  this
val Double.oz get() = 35.273962 *  this
val Double.lb get() = 2.204623 *  this

// 공통 변환 구조 정의
interface Conv {
    fun conv(from: Double): String
}

// String extension func.. Pair ?
fun String.toUC(): Pair<Double, String> {
    val data: Double = this.split(" ").first().toDouble()
    val unit: String = this.split(" ").last()
    return Pair(data, unit)
}


// 유닛 변환 래퍼 클래스
class UnitConverter(val input: String) {
    lateinit var uc: Conv   // interface 구현한 객체

    fun showConvertedTable() {
        val(inputValue, inputUnit) = input.toUC()

        when(inputUnit){
            DEF_DATA_UNIT -> {this.uc = DataUnit()}
            DEF_LENGTH_UNIT -> {this.uc = LengthUnit()}
            DEF_WEIGHT_UNIT -> {this.uc = WeightUnit()}
            // "new unit" -> {변환처리}
            else -> {
                println("변환 안되는 단위 unavailable unit yet..")
                return
            }
        }

        println(this.uc.conv(inputValue))    // 인터페이스 다형성 메소드 호출
    }

    // Data
    inner class DataUnit: Conv {
        override fun conv(from: Double): String {   // "100.0m", "100.33kg"
            return """
                ================================
                    Data $from  kb =>
                --------------------------------
                    ${from.bit} bit
                    ${from.b} byte
                    ${from.mb} mb
                    ${from.gb} gb
                    ${from.tb} tb
                    ${from.pb} peta byte
                    ${from.eb} exa byte
                ================================
            """.trimIndent()
        }
    }

    // Length
    inner class LengthUnit: Conv {
        override fun conv(from: Double): String {
            return """
                ================================
                    Data $from  m =>
                --------------------------------
                    ${from.mm} mm
                    ${from.cm} cm
                    ${from.km} km
                    ${from.inch} inch
                    ${from.ft} ft
                    ${from.yd} yd
                    ${from.mile} mile
                ================================
            """.trimIndent()
        }
    }

    // Weight
    inner class WeightUnit: Conv {
        override fun conv(from: Double): String {
            return """
                ================================
                    Weight $from kg =>
                --------------------------------
                    ${from.mg} mg
                    ${from.g} g
                    ${from.ton} ton
                    ${from.grain} grain
                    ${from.oz} oz
                    ${from.lb} lb
                ================================
            """.trimIndent()
        }
    }
}

fun main() {
    val l : List<Int> = listOf(1,2,3)
    l.lastIndex    // lastIndex: 확장 프로퍼티

    UnitConverter("2048.0 kb").showConvertedTable()
    UnitConverter("1234.0 m").showConvertedTable()
    UnitConverter("98765432.0 kg").showConvertedTable()
}

