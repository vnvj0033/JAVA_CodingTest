package string

class MoveZeroKt {

    fun solve(nums: Array<Int>): Array<Int> {
        val list = ArrayList<Int>()

        var zeroCount = 0

        nums.forEach {
            if (it == 0) {
                zeroCount++
            } else {
                list.add(it)
            }
        }

        for (i in 1..zeroCount) {
            list.add(0)
        }

        return list.toTypedArray()
    }
}

fun main() {
    val nums = arrayOf(0,3,2,0,8,5)

    MoveZeroKt().solve(nums).forEach {
        print("$it, ")
    }

}