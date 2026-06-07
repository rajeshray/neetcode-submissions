/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    var maxDiameter = 0
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        depth(root)
        return maxDiameter
    }

    fun depth(root: TreeNode?): Int {
        if (root == null) return 0
        val left = depth(root?.left)
        val right = depth(root?.right)
        maxDiameter = max(maxDiameter, left + right)
        return 1 + max(left, right)
    }
}
