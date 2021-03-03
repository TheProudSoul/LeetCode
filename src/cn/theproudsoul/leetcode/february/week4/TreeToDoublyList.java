package cn.theproudsoul.leetcode.february.week4;

import cn.theproudsoul.leetcode.common.TreeNode;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 */
public class TreeToDoublyList {
  public TreeNode treeToDoublyList(TreeNode root) {
    if (root == null) return null;
    if (root.left != null) {
      root.left = buildLeftList(root.left);
      root.left.right = root;
    }
    if (root.right != null) {
      root.right = buildRightList(root.right);
      root.right.left = root;
    }
    TreeNode leftPointer = root;
    while (leftPointer.left != null) leftPointer = leftPointer.left;
    TreeNode rightPointer = root;
    while (rightPointer.right != null) rightPointer = rightPointer.right;
    leftPointer.left = rightPointer;
    rightPointer.right = leftPointer;
    return leftPointer;
  }

  private TreeNode buildRightList(TreeNode root) {
    if (root.right != null) {
      root.right = buildRightList(root.right);
      root.right.left = root;
    }
    if (root.left != null) {
      root.left = buildLeftList(root.left);
      root.left.right = root;
    } else {
      return root;
    }
    while (root.left != null) root = root.left;
    return root;
  }

  private TreeNode buildLeftList(TreeNode root) {
    if (root.left != null) {
      root.left = buildLeftList(root.left);
      root.left.right = root;
    }
    if (root.right != null) {
      root.right = buildRightList(root.right);
      root.right.left = root;
    } else {
      return root;
    }
    while (root.right != null) root = root.right;
    return root;
  }
}
