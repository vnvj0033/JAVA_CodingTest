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

    fun solve2(nums: Array<Int>): Array<Int> {
        val array = Array(nums.size) { 0 }
        var count = 0

        nums.forEach {
            if (it != 0) array[count++] = it
        }

        return array
    }
}

fun main() {
    val nums = arrayOf(0,3,2,0,8,5)

    MoveZeroKt().solve2(nums).forEach {
        print("$it, ")
    }

}