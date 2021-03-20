package cn.theproudsoul.leetcode.march.week3;

public class EvalRPN {
  public int evalRPN(String[] tokens) {
    int cur = 0;
    int[] nums = new int[tokens.length / 2 + 1];
    for (String token : tokens) {
      if ("+".equals(token)) {
        int right = nums[--cur];
        int left = nums[--cur];
        nums[cur++] = left + right;
      } else if ("-".equals(token)) {
        int right = nums[--cur];
        int left = nums[--cur];
        nums[cur++] = left - right;
      } else if ("*".equals(token)) {
        int right = nums[--cur];
        int left = nums[--cur];
        nums[cur++] = left * right;
      } else if ("/".equals(token)) {
        int right = nums[--cur];
        int left = nums[--cur];
        nums[cur++] = left / right;
      } else {
        nums[cur++] = Integer.parseInt(token);
      }
    }
    return nums[0];
  }

  public static void main(String[] args) {
    String[] tokens = {"2", "1", "+", "3", "*"};
    EvalRPN testObj = new EvalRPN();
    int result = testObj.evalRPN(tokens);
    System.out.println(result);
  }
}
