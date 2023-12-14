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

        /**
         * Function Types
         */
        println()
        println("*** Function Types ***")
        functionTypes()
    }

    private fun functionTypes() {
        // Function that accepts two (Int, Int) as an argument and returns Int.
        val sum: (Int, Int) -> Int = { x, y -> x + y }
        println("sum = $sum")
        val isEven: (Int) -> Boolean = { i: Int -> i % 2 == 0 }
        println("isEven = $isEven")

        // Passing a variable of function type as an argument
        val list = listOf(1, 2, 3, 4)
        println("list.any = " + list.any(isEven))
        println("list.filter = " + list.filter(isEven))

        // Member References
        val people = listOf(
            Person("Joseph", 23),
            Person("David", 35),
            Person("Jack", 14),
            Person("Weemong", 33)
        )
        println("maxBy member reference = " + people.maxBy(Person::age).name)

        // You can store Lambda as a variable, but you cannot store function as a variable.
        // However, you can use function reference like below:
        fun isOdd(i: Int): Boolean = i % 2 == 1
        val predicate = ::isOdd
        println("predicate = " + predicate(3))

        // Non-bound Reference
        val agePredicate: (Person, Int) -> Boolean = {
            person, ageLimit -> person.isOlder(ageLimit)
        }
        val alice = Person("Alice", 29)
        println("Non-bound Reference = " + agePredicate(alice, 21))

        // Bound Reference
        val agePredicateBound = alice::isOlder
        println("Bound Reference = " + agePredicateBound(30))
    }

    private class Person(val name: String, val age: Int) {

        fun isOlder(ageLimit: Int) = age > ageLimit
    }
}
