package cn.theproudsoul.leetcode.february.week4;

import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 */
public class LongestSubarray {
  public int longestSubarray(int[] nums, int limit) {
    int len = nums.length;
    int result = 1;
    if (len <= 1) {
      return result;
    }

    TreeMap<Integer, Integer> set = new TreeMap<>();
    int leftIndex = 0;
    int rightIndex = 0;

    while (rightIndex < len) {
      set.put(nums[rightIndex], set.getOrDefault(nums[rightIndex], 0) + 1);

      while (set.lastKey() - set.firstKey() > limit) {
        int leftRemain = set.get(nums[leftIndex]);
        if (leftRemain == 1)
          set.remove(nums[leftIndex]);
        else set.put(nums[leftIndex], leftRemain - 1);
        leftIndex++;
      }

      result = Math.max(result,rightIndex - leftIndex + 1);
      rightIndex++;
    }

    return result;
  }

  // TODO: https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/solution/javashuang-zhi-zhen-6ms-yong-yi-ge-shu-z-33th/

  public static void main(String[] args) {
    LongestSubarray testObj = new LongestSubarray();
    int[] nums = {4, 2, 2, 2, 4, 4, 2, 2};
    System.out.println(testObj.longestSubarray(nums, 0));
  }
}
