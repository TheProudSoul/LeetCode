package cn.theproudsoul.leetcode.october.week2;

/**
 * @author : zhengyijing
 * Date    : 2020/10/9
 * Time    : 2:59 下午
 * ---------------------------------------
 * Desc    :
 */
public class BinarySearch {
  public int search(int[] nums, int target) {
    int lo = 0, hi = nums.length - 1;

    while (hi >= lo) {
      int mid = (hi - lo) / 2 + lo;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }
    return -1;
  }
}
