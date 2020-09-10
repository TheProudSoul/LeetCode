package cn.theproudsoul.leetcode.september.week1;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
  Map<Character, String> map = new HashMap<>();

  public boolean wordPattern(String pattern, String str) {
    String[] words = str.split(" ");
    if (pattern.length()!= words.length) return false;
    for (int i = 0; i < words.length; i++) {
      if (map.get(pattern.charAt(i)) == null) {
        if (map.containsValue(words[i])) return false;
        map.put(pattern.charAt(i), words[i]);
      } else if (!map.get(pattern.charAt(i)).equals(words[i])) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    WordPattern obj = new WordPattern();
    assert obj.wordPattern("abba", "dog cat cat dog");
  }
}
