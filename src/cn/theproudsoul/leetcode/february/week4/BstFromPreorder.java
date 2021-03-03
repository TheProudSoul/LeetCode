package cn.theproudsoul.leetcode.february.week4;

import cn.theproudsoul.leetcode.common.TreeNode;

/**
 * 1008. 先序遍历构造二叉树
 */
public class BstFromPreorder {
  public TreeNode bstFromPreorder(int[] preorder) {
    return buildTree(preorder, 0, preorder.length - 1);
  }

  private TreeNode buildTree(int[] preorder, int leftIndex, int rightIndex) {
    if (rightIndex < leftIndex) return null;

    TreeNode root = new TreeNode(preorder[leftIndex]);
    int rightChild = leftIndex + 1;
    while (rightChild <= rightIndex && preorder[rightChild] < root.val) rightChild++;
    root.left = buildTree(preorder, leftIndex + 1, rightChild - 1);
    root.right = buildTree(preorder, rightChild, rightIndex);
    return root;
  }
}
