class Solution {
    fun isHappy(n: Int): Boolean {
        val hashSet = HashSet<Int>()
        var newN = n
        while(true) {
            var temp = newN
            var sum = 0
            while(temp > 0) {
                val dig = temp%10
                sum += (dig * dig)
                temp/=10
            }

            if (sum == 1) return true
            if (hashSet.contains(sum)) {
                return false
            }
            hashSet.add(sum)
            newN = sum  
            
        }

        return true

    }
}
