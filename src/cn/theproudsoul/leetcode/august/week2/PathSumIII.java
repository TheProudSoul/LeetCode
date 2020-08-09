package cn.theproudsoul.leetcode.august.week2;

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

public class PathSumIII {

  int paths = 0;

  private void helper (TreeNode root, int sum) {

    if (root != null && root.val == sum) {
      ++paths;
    }
    if (root != null) {
      sum -= root.val;
      helper (root.left, sum);
      helper (root.right, sum);
    }
  }

  public int pathSum (TreeNode root, int sum) {

    if (root == null) {
      return 0;
    }
    helper (root, sum);
    pathSum (root.left, sum);
    pathSum (root.right, sum);
    return paths;
  }

  public static void main(String[] args) {
    // 这道题是抄的
    PathSumIII obj = new PathSumIII();
    int result = obj.pathSum(new TreeNode(10, new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)),
        new TreeNode(2, null, new TreeNode(1))),
        new TreeNode(-3, null, new TreeNode(11))), 8);
    System.out.println(result);
  }
}
