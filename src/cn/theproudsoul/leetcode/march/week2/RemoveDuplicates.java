package cn.theproudsoul.leetcode.march.week2;

import java.util.Arrays;

/**
 * 1047. 删除字符串中的所有相邻重复项
 * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 * 输入："abbaca"
 * 输出："ca"
 */
public class RemoveDuplicates {
  public String removeDuplicates(String S) {
    if (S == null || S.length() <= 1) return S;

    char[] charStack = new char[S.length()];
    int position = -1;
    for (char c : S.toCharArray()) {
      if (position > -1 && charStack[position] == c) position--;
      else charStack[++position] = c;
    }

    return new String(charStack, 0, position + 1);
  }

  public static void main(String[] args) {
    RemoveDuplicates testObj = new RemoveDuplicates();
    String result = testObj.removeDuplicates("abbaca");
    System.out.println(result);
  }
}
