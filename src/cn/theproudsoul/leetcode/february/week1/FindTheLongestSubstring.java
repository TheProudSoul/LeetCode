package cn.theproudsoul.leetcode.february.week1;

import java.util.Arrays;

/**
 * @author : zhengyijing
 * Date    : 2021/2/5
 * Time    : 9:33 下午
 * ---------------------------------------
 * Desc    :
 */
public class FindTheLongestSubstring {
  public int findTheLongestSubstring(String s) {
    int[] shift = new int[26];
    shift['a' - 97] = 1;
    shift['e' - 97] = 2;
    shift['i' - 97] = 4;
    shift['o' - 97] = 8;
    shift['u' - 97] = 16;

    char[] str = s.toCharArray();
    int len = str.length;

    int[] preSum = new int[32];
    Arrays.fill(preSum, -2);

    preSum[0] = -1;
    int current = 0;
    int result = 0;
    for (int i = 0; i < len; i++) {
      current ^= shift[str[i] - 97];
      if (preSum[current] != -2) {
        result = Math.max(result, (i - preSum[current]));
      } else {
        preSum[current] = i;
      }
    }
    return result;
  }
}
