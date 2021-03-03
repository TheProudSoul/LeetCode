package cn.theproudsoul.leetcode.february.week4;

import java.util.HashMap;
import java.util.Map;

/**
 * 395. 至少有 K 个重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
 */
public class LongestSubstring {

  public int longestSubstring(String s, int k) {
    char[] ss = s.toCharArray();
    if (ss.length < k) return 0;
    return check(ss, 0, ss.length - 1, k);
  }

  private int check(char[] arr, int L, int R, int k) {
    if (R - L < k - 1) return 0;

    int[] letters = new int[26];
    for (int i = L; i <= R; i++) {
      letters[arr[i] - 'a']++;
    }

    char split = 0;
    for (int i = 0; i < 26; i++) {
      if (letters[i] > 0 && letters[i] < k) {
        split = (char) (i + 'a');
        break;
      }
    }
    if (split == 0) return R - L + 1;

    int end = L;
    int res = 0;
    while (end <= R) {
      while (end <= R && arr[end] == split) {
        end++;
      }
      if (end > R) break;
      int begin = end;
      while (end <= R && arr[end] != split) {
        end++;
      }

      res = Math.max(res, check(arr, begin, end - 1, k));
    }
    return res;
  }

  public static void main(String[] args) {
    LongestSubstring testObj = new LongestSubstring();
    System.out.println(testObj.longestSubstring("ababbc", 2));
  }
}
