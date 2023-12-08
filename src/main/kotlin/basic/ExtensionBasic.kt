package basic

class ExtensionBasic {

    fun extensionPlayground() {
        println("\n\nExtensions")
        println("----------------------------")
        // joinToString()
        println(listOf('a', 'b', 'c').joinToString(separator = "", prefix = "*", postfix = "*"))

        // getOrNull()
        var list = listOf("abc")
        println(list.getOrNull(0))
        println(list.getOrNull(1))

        // withIndex()
        list = listOf("a", "b", "c")
        for ((index, element) in list.withIndex()) {
            println("$index $element")
        }

        // "until" and "to" are also an Extension

        // Multiline Strings
        val q = """To code,
            |or not to code?""".trimMargin()
        println(q)

        // Conversions
        val n: Int = "123".toInt()
        println(n)
        val d: Double = "1e-10".toDouble()
        println(d)
        println("----------------------------")
    }
}