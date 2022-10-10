package string

class FindAllAnagramInAStringKt {
    fun solve(s: String, p: String): Array<Int> {

        val result = ArrayList<Int>()

        for (i in 0 until s.length - (p.length - 1)) {
            val target = s.substring(i, i + p.length)

            if (p.filter { target.contains(it) }.length == p.length) {
                result.add(i)
            }
        }

        return result.toTypedArray()
    }
}

fun main() {

    val s = "bacdgabcda"
    val p = "abcd"

    FindAllAnagramInAStringKt().solve(s, p).forEach {
        println(it)
    }

}