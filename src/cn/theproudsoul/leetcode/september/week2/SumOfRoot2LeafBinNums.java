package cn.theproudsoul.leetcode.september.week2;

import cn.theproudsoul.leetcode.common.TreeNode;

public class SumOfRoot2LeafBinNums {
  int sum = 0;

  public int sumRootToLeaf(TreeNode root) {
    if (root == null) return 0;
    if (root.left == null && root.right == null) return root.val;

    if (root.left != null) {
      travelHelper(root.val, root.left);
    }
    if (root.right != null) {
      travelHelper(root.val, root.right);
    }

    return sum;
  }

  private void travelHelper(int val, TreeNode root) {
    int currentNum = (val << 1) | root.val;
    if (root.left == null && root.right == null) {
      sum += currentNum;
      return;
    }
    if (root.left != null) {
      travelHelper(currentNum, root.left);
    }
    if (root.right != null) {
      travelHelper(currentNum, root.right);
    }
  }

  public static void main(String[] args) {
    SumOfRoot2LeafBinNums obj = new SumOfRoot2LeafBinNums();
    obj.sumRootToLeaf(new TreeNode(1,
        new TreeNode(0, new TreeNode(0), new TreeNode(1)),
        new TreeNode(1, new TreeNode(0), new TreeNode(1))));
  }
}
