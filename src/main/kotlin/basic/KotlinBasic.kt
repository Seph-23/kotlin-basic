package basic

import kotlin.math.max

class KotlinBasic {

    fun kotlinBasicPlayground() {
        // Var & Val
        println("Var & Val")
        println("----------------------------")
        val question: String = "Hello"
        println("$question?")

        val mutableList = mutableListOf("Java")
        mutableList.add("Kotlin")
        println(mutableList)

        val immutableList = listOf("Java")
        println(immutableList)
        println("----------------------------")

        // Functions
        println("\n\nFunctions")
        println("----------------------------")
        displayMax(5, 10)
        displaySeparator()
        displaySeparator('#', 15)
        displaySeparator(size = 5)
        // 이걸 Java에서 하려면 Method Overload를 해야함. Kotlin 에서는 Default Value를 활용하여 처리 가능.
        println("----------------------------")

        // Conditionals: if & when
        println("\n\nConditionals")
        println("----------------------------")
        println(getDescription(Color.BLUE))
        respondToInput("n")
        respondToInput("invalid")
        val temp = updateWeather(2)
        println(temp.first + " " + temp.second)
        println("----------------------------")

        // Loops
        println("\n\nLoops")
        println("----------------------------")
        // while and do-while loop are same as java
        forLoopEx()
        iterOverMap()
        iterListWithIndex()
        iterOverRange()
        iterWithStep()
        println("----------------------------")

        // Check In Range
        println("\n\nRange in Depth")
        println("----------------------------")
        println(isLetter('c'))
        println(isLetter('9'))
        println(isNotDigit('x'))
        // If a Class implements Comparable, you can compare it using comparison operator or using range notation
        println(elementInList("hello"))
        println("----------------------------")
    }

    fun displayMax(a: Int, b: Int) {
        println(max(a, b))
    }

    // default value
    @JvmOverloads       //When N parameter exists, M overloads are generated
    fun displaySeparator(character: Char = '*', size: Int = 10) {
        repeat(size) {
            print(character)
        }
        println()
    }

    // when
    fun getDescription(color: Color): String = when (color) {
        Color.BLUE -> "cold"
        Color.ORANGE -> "mild"
        Color.RED -> "hot"
    }

    // Checking Values
    fun respondToInput(input: String) = when (input) {
        "y", "yes" -> println("Agree")
        "n", "no" -> println("Disagree")
        else -> println("Invalid Input")
    }

    // when without argument
    fun updateWeather(degrees: Int): Pair<String, Color> {
        return when {
            degrees < 5 -> "cold" to Color.BLUE
            degrees < 23 -> "mild" to Color.ORANGE
            else -> "hot" to Color.RED
        }
    }

    fun forLoopEx() {
        val list = listOf("a", "b", "c")
        for (c in list) {
            print(c);
        }
        println()
    }

    fun iterOverMap() {
        val map = mapOf(1 to "one", 2 to "two", 3 to "three")
        for((key, value) in map) {
            println("$key = $value")
        }
    }

    fun iterListWithIndex() {
        val list = listOf("a", "b", "c")
        for ((index, element) in list.withIndex()) {
            println("$index: $element")
        }
    }

    fun iterOverRange() {
        for (i in 1..9) {
            print(i)
        }
        println()
        for (i in 1 until 9) {
            print(i)
        }
        println()
    }

    fun iterWithStep() {
        for (i in 9 downTo 1 step 2) {
            print(i)
        }
        println()
        for (i in 1 .. 10 step 2) {
            print(i)
        }
        println()
    }

    fun isLetter(c: Char): Boolean {
        return c in 'a'..'z' || c in 'A'..'Z'
    }

    fun isNotDigit(c: Char): Boolean {
        return c !in '0'..'9'
    }

    fun elementInList(s: String): Boolean {
        var dictionary = listOf("cat", "dog", "horse")
        return s in dictionary
    }
}