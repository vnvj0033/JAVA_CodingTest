package string

class LicenseKeyFormattingKt {
    fun solve(s: String, k: Int): String {

        val sb = StringBuffer()
        val str = s.replace("-", "").uppercase()

        str.reversed().forEachIndexed { index, c ->
            if (index % k == 0) {
                sb.append("-")
            }
            sb.append(c)
        }

        if (sb[0] == '-') {
            sb.deleteCharAt(0)
        }

        return sb.toString().reversed()
    }
}

fun main() {

    val J = "8F3Z-2e-9-w"
    val S = 4

    println(LicenseKeyFormattingKt().solve(J, S))

}