package string

class JewelsAndStonesKt {

    fun solve(jew: String, stones: String): Int {

        val set = HashSet<Char>()
        var count = 0

        for (jewel in jew.toCharArray()) {
            set.add(jewel)
        }

        for (stone in stones) {
            if (set.contains(stone)) {
                count++
            }
        }

        return count
    }
}

fun main() {

    val J = "aaA!"
    val S = "aAAbacsgbAbAf!@#ba"

    println(JewelsAndStonesKt().solve(J, S))

}