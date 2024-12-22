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
        //"day03_sample")
        "day03_input")

    val inputLineRegex = """mul\((\d{1,3}),(\d{1,3})\)""".toRegex()

    val line = sampleInput.joinToString()
    inputLineRegex.findAll(line).toList().map {
        it.groupValues[0]
    }.sumOf {
        val (left, right) = inputLineRegex
            .matchEntire(it)
            ?.destructured
            ?: throw IllegalArgumentException("Incorrect input line $it")
        left.toInt() * right.toInt()
    }.println()


    // Part 2
    val cleanRegex = """don't\(\).*?(do\(\)|$)""".toRegex()
    val cleanLine = line.replace(cleanRegex, "")
    inputLineRegex.findAll(cleanLine).toList().map {
        it.groupValues[0]
    }.sumOf {
        val (left, right) = inputLineRegex
            .matchEntire(it)
            ?.destructured
            ?: throw IllegalArgumentException("Incorrect input line $it")
        left.toInt() * right.toInt()
    }.println()
}
