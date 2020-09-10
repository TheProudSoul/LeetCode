package cn.theproudsoul.leetcode.august.week4;

import cn.theproudsoul.leetcode.utils.TreeNode;

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
