package string

import java.util.*

class PlusOneKt {

    fun solve(k: Array<Int>): Array<Int> {

        val stack = Stack<Int>()
        var isUp = false

        k.reversed().forEachIndexed { index, i ->
            var input = i
            if (index == 0) {
                input++
            }
            if (isUp) {
                input++
            }
            if (input == 10) {
                isUp = true
                stack.add(0)
            } else {
                isUp = false
                stack.add(input)
            }
        }

        if (isUp) stack.add(1)

        return stack.toTypedArray().reversedArray()
    }
}

fun main() {
    val input = arrayOf(9,9,9)

    PlusOneKt().solve(input).forEach { print(it) }
}