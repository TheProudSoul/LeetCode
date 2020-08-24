package cn.theproudsoul.leetcode.august.week4;

import java.util.Queue;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

public class SumOfLeftLeaves {
  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) return 0;
    int sum = 0;
    if (root.left != null) {
      if (root.left.left == null && root.left.right == null) sum+= root.left.val;
      else sum += sumOfLeftLeaves(root.left);
    }
    if (root.right != null) sum += sumOfLeftLeaves(root.right);
    return sum;
  }


  public static void main(String[] args) {
    TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
    SumOfLeftLeaves obj = new SumOfLeftLeaves();
    assert obj.sumOfLeftLeaves(root) == 24;
  }
}
