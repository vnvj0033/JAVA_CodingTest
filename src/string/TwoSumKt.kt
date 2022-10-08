package string

class TwoSumKt {
    fun solve(nums: Array<Int>, target: Int): Array<Int> {

        nums.forEachIndexed { i1, n1 ->
            for (i2 in i1 + 1 until nums.size) {
                val n2 = nums[i2]

                if (n1 + n2 == target) return arrayOf(i1 + 1, i2 + 1)
            }
        }

        return arrayOf(0, 0)
    }
}

fun main() {
    val nums = arrayOf(3, 2, 4)

    val target = 6

    TwoSumKt().solve(nums, target).forEach {
        println(it)
    }

}