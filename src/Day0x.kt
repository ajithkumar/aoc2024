import kotlin.math.absoluteValue

fun main() {
    fun part1(input: List<String>): Int {
        val list1 = mutableListOf<Int>()
        val list2 = mutableListOf<Int>()

        input.map { it.split(" ") }
            .forEach { list1.add(it.first().toInt()); list2.add(it.last().toInt()); }
        list1.sort()
        list2.sort()

        val result = mutableListOf<Int>()
        list1.forEachIndexed { index, _ -> val distance = (list1[index] - list2[index]).absoluteValue; result.add(distance) }
        return result.sum()
    }

    fun part2(input: List<String>): Int {
        val list1 = mutableListOf<Int>()
        val list2 = mutableListOf<Int>()

        input.map { it.split(" ") }
            .forEach { list1.add(it.first().toInt()); list2.add(it.last().toInt()); }
        val countMap = mutableMapOf<Int, Int>()
        list1.forEach { countMap[it] = 0 }
        list2.forEach { countMap[it] = countMap[it]?.plus(1) ?: 1 }

        val result = mutableListOf<Int>()
        list1.forEachIndexed { index, _ -> val sscore = (list1[index] * countMap[list1[index]]!!); result.add(sscore) }
        return result.sum()
    }

    // Test if implementation meets criteria from the description, like:
    check(part1(listOf("3 4","4 3","2 5","1 3","3 9","3 3")) == 11)
    check(part2(listOf("3 4","4 3","2 5","1 3","3 9","3 3")) == 31)

    // Or read a large test input from the `src/Day01.txt` file:
//    val testInput = readInput("Day01_test")
//    check(part1(testInput) == 1000)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
