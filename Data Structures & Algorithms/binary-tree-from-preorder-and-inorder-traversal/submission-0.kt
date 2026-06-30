/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    val inMap = mutableMapOf<Int, Int>()
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        for (i in inorder.indices) {
            inMap[inorder[i]] = i
        }
        return build(preorder, inorder, 0, preorder.size, 0)

    }


    fun build(preorder: IntArray, inorder: IntArray, start: Int, end: Int, preIndex: Int): TreeNode? {
        if (preIndex >= preorder.size) return null
        if (start > end) return null

        val root = TreeNode(preorder[preIndex])
        val newIndex = inMap[preorder[preIndex]]!!
        root?.left = build(preorder, inorder, start, newIndex - 1, preIndex+1)
        root?.right = build(preorder, inorder, newIndex+1, end, preIndex + newIndex - start + 1)

        return root

    }
}
