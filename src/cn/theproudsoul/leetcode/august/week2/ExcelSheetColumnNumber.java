package cn.theproudsoul.leetcode.august.week2;

import java.util.stream.IntStream;

public class ExcelSheetColumnNumber {
  public int titleToNumber(String s) {
    int result = 0;
    for (int i = s.length() - 1, factor = 1; i >= 0; i--, factor *= 26)
      result += (s.charAt(i) - 'A' + 1) * factor;
    return result;
  }

  public int titleToNumberI(String s) {
    return s.chars().reduce(0, (result, ch) -> result * 26 + (ch - 'A' + 1));
  }

  public int titleToNumberII(String s) {
    return IntStream.range(0, s.length()).reduce(0, (result, i) -> result * 26 + (s.charAt(i) - 'A' + 1));
  }

  public static void main(String[] args) {
    ExcelSheetColumnNumber obj = new ExcelSheetColumnNumber();
    assert obj.titleToNumber("A") == 1;
    assert obj.titleToNumber("AB") == 28;
    assert obj.titleToNumber("ZY") == 701;
  }
}
