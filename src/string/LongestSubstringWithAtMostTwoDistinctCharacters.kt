package string

class LongestSubstringWithAtMostTwoDistinctCharacters {
    fun solve(s: String): Int {
        if (s.isEmpty()) return 0

        var result = ""

        for (i in s.indices) {
            var table = s[i].toString()
            for (i2 in i+1 until s.length) {
                table += s[i2]
                if (table.toSet().size > 2) {
                    table = table.substring(0, table.length-1)
                    break
                }
            }

            if (result.length < table.length) {
                result = table
            }
        }

        return result.length
    }
}

fun main() {
    val s = "eceba"

    println(LongestSubstringWithAtMostTwoDistinctCharacters().solve(s))

}