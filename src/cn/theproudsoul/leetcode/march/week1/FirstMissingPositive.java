package cn.theproudsoul.leetcode.march.week1;

/**
 * 41. 缺失的第一个正数
 * https://leetcode-cn.com/problems/first-missing-positive/
 */
public class FirstMissingPositive {
  public int firstMissingPositive(int[] nums) {
    int[] positivePositions = new int[301];
    for (int num : nums) {
      if (num > 0 && num < 301)
        positivePositions[num] = 1;
    }
    for (int i = 1; i < 301; i++) {
      if (positivePositions[i] < 1) return i;
    }
    return 0;
  }
}
