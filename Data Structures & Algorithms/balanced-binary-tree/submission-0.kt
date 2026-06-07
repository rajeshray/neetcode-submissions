/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    var isTreeBalanced = true
    fun isBalanced(root: TreeNode?): Boolean {
        depth(root)
        return isTreeBalanced
    }
    fun depth(root: TreeNode?): Int {
        if (root == null) return 0
        val left = depth(root?.left)
        val right = depth(root?.right)
        if (left - right > 1 || right - left > 1) {
            isTreeBalanced = false
        }
        return 1 + max(left, right)
    }
        
}
