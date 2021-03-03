package cn.theproudsoul.leetcode.march.week1;

/**
 * @author : zhengyijing
 * Date    : 2021/3/1
 * Time    : 7:01 上午
 * ---------------------------------------
 * Desc    :
 */
public class NumArray {
  int[] numsSum;

  public NumArray(int[] nums) {
    numsSum = new int[nums.length + 1];
    numsSum[0] = 0;
    for (int i = 0; i < nums.length; i++) {
      numsSum[i + 1] = nums[i] + numsSum[i];
    }
  }

  public int sumRange(int i, int j) {
    return numsSum[j + 1] - numsSum[i];
  }
}
