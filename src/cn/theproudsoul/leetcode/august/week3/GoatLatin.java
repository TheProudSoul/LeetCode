package cn.theproudsoul.leetcode.august.week3;

import java.util.HashSet;
import java.util.Set;

public class GoatLatin {
  private static final Set<Character> vowels =
      new HashSet<Character>() {
        {
          add('a');
          add('e');
          add('i');
          add('o');
          add('u');
          add('A');
          add('E');
          add('I');
          add('O');
          add('U');
        }
      };

  public String toGoatLatin(String S) {
    String suffix = "";
    StringBuilder stringBuilder = new StringBuilder();
    for (String word : S.split(" ")) {
      suffix += "a";
      if (!vowels.contains(word.charAt(0))) {
        word = word.substring(1) + word.charAt(0);
      }
      stringBuilder.append(word).append("ma").append(suffix).append(" ");
    }
    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    return stringBuilder.toString();
  }
}
