package easy

class Solution125 {
    fun isPalindrome(s: String): Boolean {
        val source = s.toCharArray()
            .filter { it.isLetterOrDigit() }
            .map { it.toLowerCase() }
            .joinToString()

        return source.equals(source.reversed())
    }
}