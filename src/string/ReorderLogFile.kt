package string

import java.util.*

class ReorderLogFile {
    fun solve(logs: Array<String>): Array<String> {

        Arrays.sort(logs) { s1, s2 ->
            val split1 = s1.split(" ".toRegex(), 2)
            val split2 = s2.split(" ".toRegex(), 2)


            val isDist1 = Character.isDigit(split1[1][0])
            val isDist2 = Character.isDigit(split2[1][0])

            if (!isDist1 && !isDist2) {
                split1[1].compareTo(split2[1])
            } else if(isDist1 && isDist2) {
                split2[1].compareTo(split1[1])
            } else if (isDist1 && !isDist2) {
                1
            } else {
                -1
            }

        }

        return logs
    }
}

fun main() {
    val logs = arrayOf(
        "dig1 8 2 3 1", "let1 abc cat",
        "dig1 2 5",
        "let2 good dog book", "let3 abc zoo"
    )

    ReorderLogFile().solve(logs).forEach {
        println(it)
    }
}