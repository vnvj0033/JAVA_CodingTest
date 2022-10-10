package string

class LongestSubMostTwoDistKt {
    fun solve(s: String): Int {
        if (s.isEmpty()) return 0

        var result = s[0].toString()

        for (i in 1 until s.length) {
            val target = s[i]

            if (result.contains(target)) {
                result = target.toString()
            } else {
                result += target
            }

        }
        return result.length
    }
}

fun main() {

    val s = ""

    println(LongestSubMostTwoDistKt().solve(s))
}