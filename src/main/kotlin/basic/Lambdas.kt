package basic

class Lambdas {

    fun lambdasPlayground() {
        val list = listOf(1, 2, 3, 4, 5, 6)
        val map = mapOf(
            Pair("Hello", "World"),
            Pair("Wee", "Mong"),
            Pair("Super", "Ball")
        )
        val map2 = mapOf(
            Pair("Bob", 29),
            Pair("Andrew", 31),
            Pair("Joseph", 29),
            Pair("Philip", 31),
            Pair("David", 27)
        )

        // In Kotlin, Lambda always go inside { }
        val any = list.any { i: Int -> i > 0 }
        println("any = $any")

        // If there is only one argument inside lambda, you can use 'it'
        val any2 = list.any { it > 0 }
        println("any2 = $any2")

        // Multi-line Lambda
        val any3 = list.any {
            println("processing $it")
            it > 0                                  // The last expression is the result
        }
        println("any3 = $any3")

        // Destructuring Declarations
        val mapValues = map.mapValues { (key, value) -> "$key -> $value!" }     // Basic Destructuring
        val mapValues2 =
            map.mapValues { (_, value) -> "$value!" }               // You can omit the parameter name with '_' if the parameter is unused
        println(mapValues)
        println(mapValues2)

        /**
         * Common Collection Operators
          */
        // filter
        val evenNumbers = list.filter { it % 2 == 0 }
        println("Even Numbers = $evenNumbers")
        // map
        val squaredNumbers = list.map { it * it }
        println("Squared Numbers = $squaredNumbers")
        // find, first, firstOrNull
        val oddNumber = list.find { it % 2 == 1 }
        println("Odd Number = $oddNumber")
        val oddNumber2 = list.firstOrNull { it % 2 == 1 }
        println("$oddNumber == $oddNumber2")
//        list.first { it == 200 }              // first will throw NoSuchElementException, when no element satisfies the condition
        // partition
        val (evenPartition, oddPartition) = list.partition { it % 2 == 0 }
        println("Even Partition = $evenPartition")
        println("Odd Partition = $oddPartition")
        // groupBy
        val groupList = list.groupBy { it > 3 }
        println("List Group = $groupList")
        // associateBy (duplicated removed)
        val associateList = list.associateBy { it > 3 }
        println("Associate List = $associateList")
        // zip - it zips two list like zippers
        val list1 = listOf(1, 2, 3, 4, 5, 6)
        val list2 = listOf(7, 8, 9, 10, 11, 12)
        val zipList = list1.zip(list2)
        println("Zipped List = $zipList")
        val zipWithNext = list1.zipWithNext()
        println("Zip With Next = $zipWithNext")
    }
}