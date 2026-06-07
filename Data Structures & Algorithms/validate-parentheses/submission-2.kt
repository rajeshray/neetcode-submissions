class Solution {
    fun isValid(s: String): Boolean {

        val stack = ArrayDeque<Char>()

        for (char in s) {
            if (char == '[' || char == '(' || char == '{') {
                stack.addLast(char)
            } else {
                if (stack.isEmpty()) return false
                when(char) {
                    ']' -> {
                        if(stack.last() == '[') stack.removeLast() else return false
                    }
                    '}' -> {
                        if(stack.last() == '{') stack.removeLast() else return false
                    }
                    ')' -> {
                        if(stack.last() == '(') stack.removeLast() else return false
                    }
                }
            }
        }

        return stack.isEmpty()

    }
}
