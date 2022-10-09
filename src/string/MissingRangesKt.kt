package string

class MissingRangesKt {
    fun solve(nums: Array<Int>, lower: Int, upper: Int): Array<String> {

        var count = 0
        val result = ArrayList<String>()
        for (i in lower..upper) {
            if (nums.contains(i)) {
                if (count > 1) {
                    result.add("${i - count}->${i - 1}")
                } else if (count == 1) {
                    result.add("${i-count}")
                }
                count = 0
            } else {
                count++
            }
        }


        if (count > 1) {
            result.add("${upper - count + 1}->$upper")
        } else if (count == 1) {
            result.add("$upper")
        }

        return result.toTypedArray()
    }
}

fun main() {
    val nums = arrayOf(2,3,5,50,75)
    val lower = 0
    val upper = 99

    MissingRangesKt().solve(nums, lower, upper).forEach {
        println(it)
    }


}