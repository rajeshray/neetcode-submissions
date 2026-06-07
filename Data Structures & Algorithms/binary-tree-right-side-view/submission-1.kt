/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        val queue = ArrayDeque<TreeNode>()
        if (root == null) return emptyList()
        queue.addFirst(root) 

        while(queue.isNotEmpty()) {
            val level = queue.size
            for (i in 0 until level) {
                val node = queue.removeLast()
                if (i == level - 1) result.add(node.`val`)
                node?.left?.let {
                    queue.addFirst(it)
                }
                node?.right?.let {
                    queue.addFirst(it)
                }
            }
        }

        return result

    }
}
