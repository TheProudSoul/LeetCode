package cn.theproudsoul.leetcode.august.week2;

public class LongestPalindrome {
  public int longestPalindrome(String s) {
    int[] characters = new int[58];
    for (int i = 0; i < s.length(); i++) {
      characters[s.charAt(i) - 'A']++;
    }

    int result = 0;
    boolean hasSingle = false;

    for (int i = 0; i < 58; i++) {
      result += characters[i] / 2;
      if (characters[i] % 2 != 0) hasSingle = true;
    }

    return hasSingle ? result * 2 + 1 : result * 2;
  }

  public static void main(String[] args) {
    LongestPalindrome obj = new LongestPalindrome();
    assert obj.longestPalindrome("abccccdd") == 7;
  }
}
