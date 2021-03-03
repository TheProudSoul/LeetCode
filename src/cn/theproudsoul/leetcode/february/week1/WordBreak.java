package cn.theproudsoul.leetcode.february.week1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : zhengyijing
 * Date    : 2021/2/5
 * Time    : 11:08 下午
 * ---------------------------------------
 * Desc    :
 */
public class WordBreak {
  public boolean wordBreak(String s, List<String> wordDict) {
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] && wordDict.contains(s.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[s.length()];
  }

  public static void main(String[] args) {
    WordBreak testObj = new WordBreak();
    List<String> wordDict = new ArrayList<>();
    wordDict.add("leet");
    wordDict.add("code");
    System.out.println(testObj.wordBreak("leetcode", wordDict));
  }
}
