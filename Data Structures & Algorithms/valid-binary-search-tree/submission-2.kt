/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
         return depth(root,Int.MIN_VALUE,Int.MAX_VALUE)
    }

    fun depth(root: TreeNode?, lo: Int, hi: Int): Boolean {
        if (root == null) return true
        if (root.`val` <= lo || root.`val` >= hi) return false
        return depth(root?.left, lo, root.`val`) && depth(root?.right, root.`val`, hi)
    }
}
