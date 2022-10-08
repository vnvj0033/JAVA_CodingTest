package string

import java.util.*
import kotlin.collections.ArrayList

class IntervalKt {
    fun solve(intervals: Array<Array<Int>>): Array<Array<Int>> {

        Arrays.sort(intervals) { o1, o2 -> o1[0] - o2[0] }
        val list = ArrayList<Array<Int>>()

        var st = intervals[0][0]
        var en = intervals[0][1]

        intervals.forEach {
            if (it[0] in st..en) {
                if (it[1] > en) {
                    en = it[1]
                }
            } else {
                list.add(arrayOf(st, en))
                st = it[0]
                en = it[1]
            }
        }
        list.add(arrayOf(st, en))



        return list.toTypedArray()
    }
}

fun main() {
//    val intervals = arrayOf(arrayOf(1,4), arrayOf(2,6), arrayOf(8,10), arrayOf(15,18))
    val intervals = arrayOf(arrayOf(1,4), arrayOf(4,6), arrayOf(6,10), arrayOf(10,18))
    IntervalKt().solve(intervals).forEach {
        println("${it.get(0)}, ${it.get(1)}")
    }
}