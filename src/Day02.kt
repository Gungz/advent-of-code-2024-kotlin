import kotlin.math.abs

enum class INCREMENT { UP, DOWN }

fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    fun checkIsReportSafe(numbers: List<String>): Boolean {
        var isSafe = true
        var increment = ""
        var prevNumber = Int.MIN_VALUE
        var currNumber = Int.MAX_VALUE
        for (i in numbers.indices) {
            if (i == 0) {
                currNumber = numbers[i].toInt()
            } else {
                prevNumber = numbers[i-1].toInt()
                currNumber = numbers[i].toInt()
                val diff = currNumber - prevNumber
                if (diff > 0 && diff <= 3) {
                    if (increment.isEmpty()) {
                        increment = INCREMENT.UP.toString()
                    } else {
                        if (increment == INCREMENT.DOWN.toString()) {
                            isSafe = false
                            break
                        }
                    }
                } else if (diff < 0 && diff >= -3) {
                    if (increment.isEmpty()) {
                        increment = INCREMENT.DOWN.toString()
                    } else {
                        if (increment == INCREMENT.UP.toString()) {
                            isSafe = false
                            break
                        }
                    }
                } else {
                    isSafe = false
                    break
                }
            }
        }
        return isSafe
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val sampleInput = readInput(
        //"day02_sample")
        "day02_input")

    //val inputLineRegex = """(\d+) (\d+) (\d+) (\d+) (\d+)""".toRegex()
    var results = emptyArray<Boolean>()

    for (line in sampleInput) {
        results += checkIsReportSafe(line.split(" "))
    }
    val safeNumber = results.count { it == true }
    safeNumber.println()

    // Part 2
    for (x in results.indices) {
        if (!results[x]) {
            val line = sampleInput[x]

            val numbers = line.split(" ")

            for (i in numbers.indices) {
                val newNumbers = numbers.toMutableList()
                newNumbers.removeAt(i)
                if (checkIsReportSafe(newNumbers)) {
                    results[x] = true
                    break
                }
            }
        }
    }

    val dampenedSafeNumber = results.count { it == true }
    dampenedSafeNumber.println()
}
