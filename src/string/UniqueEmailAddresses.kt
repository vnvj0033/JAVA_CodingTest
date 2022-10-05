package string

class UniqueEmailAddresses {
    fun solve(emails: Array<String>): Int {
        val set = HashSet<String>()

        for (email in emails) {

            val splitEmail = email.split("@")

            if(splitEmail.size != 2) continue

            val local = splitEmail[0].replace(".", "").split("+")[0]
            val domain = splitEmail[1]
            set.add("$local@$domain")
        }

        return set.size
    }

}

fun main() {
    val emails = arrayOf(
        "a@coding.com",
        "b@coding.com",
        "c@coding.com"
    )

    println(UniqueEmailAddresses().solve(emails))
}