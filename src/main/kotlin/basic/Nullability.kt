package basic

class Nullability {

    fun nullabilityPlayground() {
        // Nullable Types in Kotlin
        val s1: String = "always not null"      // Always not null
        val s2: String? = null                  // Add ? to make type nullable
//        val s3: String = null                 // Compile Error

        dealingWithNullableTypes()
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

        // Therefore
        val length = if (s != null) s.length else 0
        // can be replaced as
        val length2 = s?.length ?: 0                 // Type of length2 is Int? - nullable Int
    }
}
