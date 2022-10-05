package string

class JewelsAndStonesKt {

    fun solve(jew: String, stones: String): Int {

        val set = HashSet<Char>()
        var count = 0

        for (jewel in jew.toCharArray()) {
            set.add(jewel)
        }

        for (jewel in set) {
            count += stones.count { jewel == it }
        }

        return count
    }
}

fun main() {

    val jewels = "z"
    val stones = "ZZ"

    println(JewelsAndStonesKt().solve(jewels, stones))

}