import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val sampleInput = readInput(
        //"day01_sample")
        "day01_input")

    val inputLineRegex = """(\d+) {3}(\d+)""".toRegex()

    var leftList = intArrayOf()
    var rightList = intArrayOf()
    for (line in sampleInput) {
        val (left, right) = inputLineRegex
            .matchEntire(line)
            ?.destructured
            ?: throw IllegalArgumentException("Incorrect input line $line")
        leftList += left.toInt()
        rightList += right.toInt()
    }

    val differ = rightList.sorted().zip(leftList.sorted()).map { (el1, el2) -> abs(el1 - el2) }
    val diffTotal = differ.sum()
    diffTotal.println()

    // Read the input from the `src/day01_sample.txt` file.
    //val input = readInput("day01_sample")
    //part1(input).println()
    //part2(input).println()
    val occurrence = leftList.map { el -> rightList.count{it == el} }
    val similarities = leftList.zip(occurrence).map { (el1, el2) -> el1 * el2 }
    val simTotal = similarities.sum()
    simTotal.println()
}
