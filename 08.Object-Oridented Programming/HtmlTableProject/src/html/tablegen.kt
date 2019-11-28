package html

/**
 * singleton : 하나의 인스턴스만 존재
 */
object MyRecord {
    private var _count = 0
    private val _tables = hashMapOf<String, MyHtml>()

    fun gen(table: MyHtml){
        _tables.put(table.name, table)
        _count++
    }

    fun showTableCount() = _count
    fun showTable() : Map<String,MyHtml> = _tables  // 불변 맵 (view)
}

// n x m HTML table 만들기
class MyHtml {
    val name: String
    val row: Int
    val col: Int
    private val HEAD = "<table border='1' cell-spacing='10' cell-padding='10'>"
    private val TAIL = "</table>"
    private lateinit var comment: String
    private val tableColumns = ArrayList<String>()  // 열 제목

    private constructor(_name: String, row: Int, col: Int){
        this.name = _name
        this.row = row
        this.col = col
    }

    fun setColumnHeaders(vararg colNames: String){
        this.tableColumns.addAll(colNames)
    }

    // java의 static 개념과 흡사
    // 클래스 레벨에서 동작 가능, inner 객체
    // 클래스의 자원에 접근할 수 있고 클래스의 타입처럼 존재
    // 팩토리 패턴처럼 MyHtml 객체를 만듦
    // MyHtml.generateHtmlObject()
    companion object _GenTable {
        fun generateHtmlObject(_name: String, row: Int = 3, col: Int = 4) : MyHtml{
            val mh = MyHtml(_name, row, col)
            mh.comment = "<!-- auto-generated table by MyHtml v1.0 -->"
            // 테이블 객체 기록
            MyRecord.gen(mh)
            return mh
        }
    }

    private inner class Tr {
       val rowHtml = """
        |<tr>
        |   ${"<td> - </td> ".repeat(col)}
        |</tr>${"\n"}
       """.trimMargin()
    }

    private inner class Th(val wpx: Int = 40) { // table header row
        val headers = tableColumns.map {
            "<th width='$wpx'> $it </th>"
        }
        val rowHtml = """
            |<tr>
            |   ${headers.joinToString("")}
            |</tr>
       """.trimMargin()
    }

    // 테이블 생성 실행
    fun generateTable() =
        """
        |$comment
        |$HEAD
        |${Th().rowHtml}
        |${Tr().rowHtml.repeat(row)}
        |$TAIL
        """.trimMargin()

}

fun main() {
    // MyRecord()  // err
    MyRecord.showTableCount()
    MyRecord.showTable()

    // MyHtml("first", 2, 2)    // err : constuctor가 private이라 error
    val first = MyHtml.generateHtmlObject("first")
    first.setColumnHeaders("1일","2일","3일","4일")

    val second = MyHtml.generateHtmlObject("second",5,5)
    second.setColumnHeaders("월","화","수","목","금")

    val third = MyHtml.generateHtmlObject("third", 2, 7)
    third.setColumnHeaders("Red","Orannge","Yellow","Green","Blue","Navy","Purple")

    println("생성된 table 개수 : ${MyRecord.showTableCount()}")

    for( (k,v) in MyRecord.showTable()) {
        println("\n <!-- $k table (${v.row} x ${v.col})-->")
        println(v.generateTable())
        println()
    }
}