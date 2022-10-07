package string

import java.util.Arrays

class KClosestPointstoOrigin {
    fun solve(points: Array<Array<Int>>, k: Int): Array<Array<Int>> {
        Arrays.sort(points) { o1, o2 ->
            o1[0] * o1[0] + o1[1] * o1[1] - o2[0] * o2[0] - o2[1] * o2[1]
        }

        return points.copyOfRange(0, k)
    }
}

fun main() {
    val points = arrayOf(arrayOf(3, 3), arrayOf(5, -1), arrayOf(-2, 4))
    val k = 2

    KClosestPointstoOrigin().solve(points, k).forEach {
        print("[${it[0]}, ${it[1]}] ")
    }
}