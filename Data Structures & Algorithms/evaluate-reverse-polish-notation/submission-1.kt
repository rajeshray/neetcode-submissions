class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        var stack = ArrayDeque<Int>()

        for (token in tokens) {
            if (token.toIntOrNull() != null) {
                stack.addLast(token.toInt())
            } else {
                val numB = stack.removeLast()
                val numA = stack.removeLast()
                var result: Int = 0

                when(token) {
                    "+" -> result = numA+numB
                    "-" -> result = numA-numB
                    "*" -> result = numA * numB
                    "/" -> result = numA / numB
                }

                 stack.addLast(result)
            }
        }

        return stack.removeLast()

    }
}
