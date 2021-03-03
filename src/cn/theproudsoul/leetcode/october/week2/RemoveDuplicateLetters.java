package cn.theproudsoul.leetcode.october.week2;

import java.util.Stack;

public class RemoveDuplicateLetters {
  public String removeDuplicateLetters(String s) {
    Stack<Integer> stack = new Stack<>();
    if (s == null || s.length() <= 1) return s;
    int[] last = new int[26], seen = new int[26];
    // Find the index of last occurrence for each character.
    for (int i = 0; i < s.length(); ++i)
      last[s.charAt(i) - 'a'] = i;

    for (int i = 0; i < s.length(); ++i) {
      int c = s.charAt(i) - 'a';
      if (seen[c]++ > 0) continue;
      while (!stack.isEmpty() && stack.peek() > c && i < last[stack.peek()])
        seen[stack.pop()] = 0;
      stack.push(c);
    }
    StringBuilder sb = new StringBuilder();
    for (int i : stack) sb.append((char) ('a' + i));
    return sb.toString();
  }
}
