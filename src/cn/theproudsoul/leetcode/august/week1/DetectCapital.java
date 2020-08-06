package cn.theproudsoul.leetcode.august.week1;

public class DetectCapital {
  public boolean detectCapitalUse(String word) {
    String reg = "[A-Z]*[a-z]+|[A-Z]+";
    return word.matches(reg);
  }

  public static void main(String[] args) {
    DetectCapital detectCapital = new DetectCapital();
    assert detectCapital.detectCapitalUse("USA");
    assert detectCapital.detectCapitalUse("leetcode");
    assert detectCapital.detectCapitalUse("Google");
    assert !detectCapital.detectCapitalUse("FlaG");
  }
}
