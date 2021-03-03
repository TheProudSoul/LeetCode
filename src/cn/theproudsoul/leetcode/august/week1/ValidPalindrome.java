package cn.theproudsoul.leetcode.august.week1;

public class ValidPalindrome {
  public boolean isPalindrome(String s) {
    String lowCase = s.toLowerCase();
    int i = 0, j = lowCase.length() - 1;
    while (i < j) {
      char letterI = lowCase.charAt(i);
      char letterJ = lowCase.charAt(j);
      if (!Character.isDigit(letterI) && !Character.isLetter(letterI)) {
        i++;
        continue;
      }
      if (!Character.isDigit(letterJ) && !Character.isLetter(letterJ)) {
        j--;
        continue;
      }
      if (i < j && letterI != letterJ) return false;
      else {
        i++;
        j--;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String input = "race a car";
    ValidPalindrome palindrome = new ValidPalindrome();
    assert !palindrome.isPalindrome(input);
  }
}
