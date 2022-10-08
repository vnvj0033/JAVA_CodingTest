package string

class DailyTemperatureKt {
    fun solve(nums: Array<Int>): Array<Int> {
        val result = Array(nums.size) {0}

        nums.forEachIndexed { i1, n1 ->
            for (i2 in i1+1 until nums.size) {
                if (n1 <= nums[i2]) {
                    result[i1] = i2 - i1
                    break
                }
            }
        }

        return result
    }
}

fun main() {

    val nums = arrayOf(73, 74, 75, 71, 69, 72, 76, 73)
    val results = DailyTemperatureKt().solve(nums)

    for (result in results) print("$result ")
}