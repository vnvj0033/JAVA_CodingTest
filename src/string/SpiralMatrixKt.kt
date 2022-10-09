package string

class SpiralMatrixKt {
    fun solve(matrix: Array<Array<Int>>): Array<Int> {

        val list = ArrayList<ArrayList<Int>>()

        matrix.forEach {
            list.add(ArrayList(it.toList()))
        }

        var move = Move.RIGHT
        val result = ArrayList<Int>()

        for (i in 0..matrix.size + matrix[0].size - 2) {

            when (move) {
                Move.RIGHT -> {
                    result.addAll(list.first())
                    list.removeFirst()
                    move = Move.DOWN
                }
                Move.DOWN -> {
                    list.forEach {
                        result.add(it.last())
                        it.removeLast()
                    }
                    move = Move.LEFT
                }
                Move.LEFT -> {
                    result.addAll(list.last().reversed())
                    list.removeLast()
                    move = Move.UP
                }
                Move.UP -> {
                    for (i2 in list.size-1 downTo 0) {
                        result.add(list[i2].first())
                        list[i2].removeFirst()
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

    println()
    SpiralMatrixKt().solve(matrix).forEach {
        print("$it, ")
    }
}