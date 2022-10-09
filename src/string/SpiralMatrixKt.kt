package string

class SpiralMatrixKt {
    fun solve(matrix: ArrayList<ArrayList<Int>>): Array<Int> {



        var move = Move.RIGHT
        val result = ArrayList<Int>()

        for (i in 0..matrix.size + matrix[0].size - 2) {

            when (move) {
                Move.RIGHT -> {
                    result.addAll(matrix.first())
                    matrix.removeFirst()
                    move = Move.DOWN
                }
                Move.DOWN -> {
                    matrix.forEach {
                        result.add(it.last())
                        it.removeLast()
                    }
                    move = Move.LEFT
                }
                Move.LEFT -> {
                    result.addAll(matrix.last().reversed())
                    matrix.removeLast()
                    move = Move.UP
                }
                Move.UP -> {
                    for (i2 in matrix.size-1 downTo 0) {
                        result.add(matrix[i2].first())
                        matrix[i2].removeFirst()
                    }
                    move = Move.RIGHT
                }
            }

        }


        return result.toTypedArray()
    }
}

enum class Move {
    RIGHT,
    DOWN,
    LEFT,
    UP
}

fun main() {
    val matrix = arrayOf(
        arrayOf(1, 2, 3, 4),
        arrayOf(5, 6, 7, 8),
        arrayOf(9, 10, 11, 12),
        arrayOf(13,14,15,16))

val list = ArrayList<ArrayList<Int>>()
    matrix.forEach {
        list.add(ArrayList(it.toList()))
    }

    val st = System.currentTimeMillis()
    SpiralMatrixKt().solve(list).forEach {
        print("$it, ")
    }
    println()
    println(System.currentTimeMillis() - st)
}