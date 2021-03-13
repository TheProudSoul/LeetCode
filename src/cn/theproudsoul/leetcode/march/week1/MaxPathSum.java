package cn.theproudsoul.leetcode.march.week1;

import cn.theproudsoul.leetcode.common.TreeNode;

/**
 * @author : zhengyijing
 * Date    : 2021/3/1
 * Time    : 7:17 上午
 * ---------------------------------------
 * Desc    :
 */
public class MaxPathSum {
  public int maxPathSum(TreeNode root) {
    if (root.left == null && root.right == null) {
      return root.val;
    }
    return Math.max(root.val, root.val);
  }
}
