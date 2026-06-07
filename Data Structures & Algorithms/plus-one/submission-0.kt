class Solution {
    fun plusOne(digits: IntArray): IntArray {
        val result = mutableListOf<Int>()
        var carry = 1
        for (i in digits.size-1 downTo 0) {
            val sum = digits[i] + carry
            val dig = sum%10
            result.add(dig)
            carry = sum/10
        }
        if (carry == 1) {
            result.add(1)
        }

        return result.reversed().toIntArray()
    }
}
