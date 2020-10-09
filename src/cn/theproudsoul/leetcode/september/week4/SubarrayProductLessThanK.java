package cn.theproudsoul.leetcode.september.week4;

/**
 * @author : zhengyijing
 * Date    : 2020/9/29
 * Time    : 2:18 下午
 * ---------------------------------------
 * Desc    :
 */
public class SubarrayProductLessThanK {
  public int numSubarrayProductLessThanK(int[] nums, int k) {
    if (k <= 1) return 0;
    int prod = 1, ans = 0, left = 0;
    for (int right = 0; right < nums.length; right++) {
      prod *= nums[right];
      while (prod >= k) prod /= nums[left++];
      ans += right - left + 1;
    }
    return ans;
  }
}
