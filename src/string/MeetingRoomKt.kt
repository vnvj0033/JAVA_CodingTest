package string

import java.util.Arrays

class MeetingRoomKt {
    fun solve(intervals: Array<Array<Int>>): Boolean {

        Arrays.sort(intervals) { o1, o2 ->
            o1[0] - o2[0]
        }
        var lastEn = 0

        intervals.forEach {
            val st = it[0]
            val en = it[1]

            if (lastEn > st) {
                return false
            } else {
                lastEn = en
            }
        }

        return true
    }
}

fun main() {

//    val intervals = arrayOf(arrayOf(5, 10), arrayOf(16, 20), arrayOf(0, 30))
    val intervals = arrayOf(arrayOf(6, 10), arrayOf(16, 20), arrayOf(1, 3))

    println(MeetingRoomKt().solve(intervals))
}