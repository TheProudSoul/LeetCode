package cn.theproudsoul.leetcode.march.week2;

import java.util.Stack;

/**
 * 224. 基本计算器<br>
 * https://leetcode-cn.com/problems/basic-calculator/<br>
 * ---------------------------------------<br>
 * 输入：s = "1 + 1"<br>
 * 输出：2
 */
public class Calculate {
  Stack<Integer> numberStack = new Stack<>();
  Stack<Character> operatorStack = new Stack<>();


  public int calculate(String s) {
    if (s == null || s.length() < 1) return 0;
    if (s.length() <= 2) return Integer.parseInt(s);

    int i = 0;
    while (i < s.length()) {
      char ch = s.charAt(i);
      if (ch == ' ') {
        i++;
      } else if (ch == '+') {

      } else if (ch == '-') {

      } else if (ch == ')') {

      } else if (ch == '(') {

      } else {
        int num = 0;
        while (Character.isDigit(ch)) {
          num += num * 10 + (ch - '0');
          ch = s.charAt(++i);
        }
        numberStack.push(num);
      }
    }
    return 1;
  }

  public static void main(String[] args) {
    Calculate testObj = new Calculate();
    int result = testObj.calculate("(1+(4+5+2)-3)+(6+8)");
    System.out.println(result);
  }
}
