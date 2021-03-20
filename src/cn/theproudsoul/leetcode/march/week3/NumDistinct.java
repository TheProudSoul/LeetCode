package cn.theproudsoul.leetcode.march.week3;

import java.util.Arrays;

/**
 * 115. 不同的子序列
 * https://leetcode-cn.com/problems/distinct-subsequences/
 * ---------------------------------------
 * Desc    :
 */
public class NumDistinct {
  public int numDistinct(String s, String t) {
    int[][] dp = new int[s.length() + 1][t.length() + 1];
    Arrays.fill(dp[s.length()], 0);
    for (int i = 0; i < s.length() + 1; i++) {
      dp[i][t.length()] = 1;
    }

    for (int i = s.length() - 1; i >= 0; i--) {
      for (int j = t.length() - 1; j >= 0; j--) {
        if (s.charAt(i) == t.charAt(j)) {
          dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
        } else {
          dp[i][j] = dp[i + 1][j];
        }
      }
    }
    return dp[0][0];
  }

  public int numDistinct0(String s, String t) {
    if (s.length() < t.length()) return 0;
    int m = s.length(), n = t.length();
    char[] ss = s.toCharArray();
    char[] tt = t.toCharArray();
    int[] bucket = new int[128];
    Arrays.fill(bucket, -1);
    int[] lastIndex = new int[n];
    for (int i = 0; i < n; i++) {
      lastIndex[i] = bucket[tt[i]];
      bucket[tt[i]] = i;
    }
    int[] dp = new int[n + 1];
    dp[0] = 1;
    for (int i = 1; i <= m; i++) {
      for (int j = bucket[ss[i - 1]]; j >= 0; j = lastIndex[j]) {
        dp[j + 1] += dp[j];
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {
    NumDistinct testObj = new NumDistinct();
    int result = testObj.numDistinct("rabbbit", "rabbit");
    System.out.println(result);
  }
}
