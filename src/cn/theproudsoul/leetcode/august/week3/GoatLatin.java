package cn.theproudsoul.leetcode.august.week3;

public class GoatLatin {
  public String toGoatLatin(String S) {
    final String vowels = "aeiouAEIOU";
    String[] words = S.split(" ");
    String suffix = "";
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < words.length; i++) {
      suffix += "a";
      if (vowels.contains(words[i].substring(0, 1))) {
        stringBuilder.append(words[i]).append("ma").append(suffix);
      } else {
        if (words[i].length() < 1) {
          stringBuilder.append(words[i]).append("ma").append(suffix);
        } else {
          stringBuilder.append(words[i].substring(1)).append(words[i].charAt(0)).append("ma").append(suffix);
        }
      }
    }
    return stringBuilder.toString();
  }
}
