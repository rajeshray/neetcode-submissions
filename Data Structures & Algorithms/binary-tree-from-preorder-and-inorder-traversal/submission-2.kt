/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    val inMap = mutableMapOf<Int, Int>()
    var preIndex = 0
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        for (i in inorder.indices) {
            inMap[inorder[i]] = i
        }
        return build(preorder, inorder, 0, preorder.size)

    }


    fun build(preorder: IntArray, inorder: IntArray, start: Int, end: Int): TreeNode? {
        if (preIndex >= preorder.size) return null
        if (start > end) return null

        val rootVal = preorder[preIndex++]

        val root = TreeNode(rootVal)
        val newIndex = inMap[rootVal]!!
        root?.left = build(preorder, inorder, start, newIndex - 1)
        root?.right = build(preorder, inorder, newIndex+1, end)

        return root

    }
}
