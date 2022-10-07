package string

import java.util.*

class MeetingRoom2Kt {
    fun solve(intervals: Array<Array<Int>>): Int {

        Arrays.sort(intervals) { o1, o2 ->
            o1[0] - o2[0]
        }

        // 0 30
        // 5 10
        // 16 20
        // 30 32

        val pq: Queue<Array<Int>> = PriorityQueue { o1, o2 -> o1[1] - o2[1] }
        pq.add(intervals[0])

        for (i in 1 until intervals.size) {
            if (pq.peek()[1] <= intervals[i][0]) {
                pq.poll()
            }
            pq.add(intervals[i])

            pq.forEach {
                println("${it[0]} ${it[1]}")
            }
            println()
        }


        return pq.size
    }
}

fun main() {

    val intervals = arrayOf(arrayOf(5, 10), arrayOf(16, 20), arrayOf(0, 30), arrayOf(30, 100), arrayOf(32, 33), arrayOf(31, 40))

    println(MeetingRoom2Kt().solve(intervals))
}