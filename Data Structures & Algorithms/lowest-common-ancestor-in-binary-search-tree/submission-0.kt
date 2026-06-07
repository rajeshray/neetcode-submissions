/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    var lca: TreeNode? = null
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        depth(root, p, q)
        return lca
    }

    fun depth(root: TreeNode?, p: TreeNode?, q: TreeNode?) {
        if (root == null) return
        if (p == null || q == null) return

        if (p.`val` < root.`val` && q.`val` < root.`val`) depth(root?.left, p, q)
        else if (p.`val` > root.`val` && q.`val` > root.`val`)  depth(root?.right, p, q)
        else {
            lca = root
            return
        }
    }
}
