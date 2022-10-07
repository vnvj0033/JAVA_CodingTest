package string

class KthLargestElementInAnArray {

    fun solve(nums: Array<Int>, k: Int): Int {
        return nums.sorted()[nums.size - k]
    }
}

fun main() {
    val nums = arrayOf(3,2,3,1,2,4,5,5,6)
    val k = 4

    println(KthLargestElementInAnArray().solve(nums, k))
}