package basic

class Nullability {

    fun nullabilityPlayground() {
        // Nullable Types in Kotlin
        val s1: String = "always not null"      // Always not null
        val s2: String? = null                  // Add ? to make type nullable
//        val s3: String = null                 // Compile Error

        dealingWithNullableTypes()

        val list1: List<Int?> = listOf(1, 2, 3)
        val list2: List<Int> = listOf(4, 5, 6)
        nullabilityExample(list1, list2)
    }

    fun dealingWithNullableTypes() {
        val s: String? = "hello"
        val s1: String? = null

        if (s != null) {
            println(s.length)
        }

        // Safe Access Expression
        println(s?.length)
        println(s1?.length)
//        println(s1.length)                         // Compile Error, nullable type must be accessed using ? or !!

        // Therefore
        val length = if (s != null) s.length else 0
        // can be replaced as
        val length2 = s?.length ?: 0                 // Type of length2 is 'Int?' (nullable Int)

//        s1!!                                       // !! (assertion operator) will throw NPE if s1 is null
    }

    fun nullabilityExample(list1: List<Int?>, list2: List<Int>?) {
        list1.size
        list2?.size

        // Watch where ? are used
        val i: Int? = list1.get(0)
        val j: Int? = list2?.get(0)

        println(i.toString() + " " + j.toString())
    }
}
