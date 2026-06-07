/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
  
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        if (root == null) return emptyList()
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val level = queue.size
            val levelList = mutableListOf<Int>()
            for (i in 0 until level) {
                val node = queue.removeLast()
                levelList.add(node.`val`)
                node.left?.let {
                    queue.addFirst(it)
                }
                node.right?.let {
                    queue.addFirst(it)
                } 
            }
            result.add(levelList)
        }

        return result
           
    }
}
