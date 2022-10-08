package string

import kotlin.math.max

class SubArray {
    fun solve(nums: Array<Int>): Int {

        var max = 0
        for (count in nums.size downTo 1) {
            for (i in 0 until count + 1) {
                var sum = 0

                for (i2 in i until nums.size - count + i) {
                    sum += nums[i2]
                }
                if (max < sum) max = sum
            }
        }
     return max
    }

    fun solve2(nums: Array<Int>): Int {
        var max = nums[0]
        var curMax = nums[0]

        for (i in 1 until nums.size) {
            curMax = max(nums[i], nums[i] + curMax)
            max = max(max, curMax)
        }

        return max
    }
}

fun main() {
    val nums = arrayOf(-2,1,-3,4,-1,2,1,-5,4)
    println( SubArray().solve2(nums) )
}