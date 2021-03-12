package cn.theproudsoul.leetcode.march.week1;

import java.util.Arrays;
import java.util.Stack;

/**
 * 503. 下一个更大元素 II<br>
 * https://leetcode-cn.com/problems/next-greater-element-ii/<br>
 * ---------------------------------------<br>
 * 输入: [1,2,1]<br>
 * 输出: [2,-1,2]<br>
 * 解释: 第一个 1 的下一个更大的数是 2；<br>
 * 数字 2 找不到下一个更大的数；<br>
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 */
public class NextGreaterElements {
  public int[] nextGreaterElements(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    Arrays.fill(result, -1);
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    for (int i = 1; i < n * 2 - 1; i++) {
      while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
        result[stack.pop()] = nums[i % n];
      }
      stack.push(i % n);
    }
    return result;
  }


  public int[] nextGreaterElementsII(int[] nums) {
    int[] ans = new int[nums.length];
    int[] stack = new int[nums.length + 1];
    stack[0] = -1;
    int top = 0;
    for (int i = nums.length - 1; i >= 0; i--) {
      while (top > 0 && stack[top] <= nums[i]) {
        top--;
      }
      stack[++top] = nums[i];
    }
    for (int i = nums.length - 1; i >= 0; i--) {
      while (top > 0 && stack[top] <= nums[i]) {
        top--;
      }
      ans[i] = stack[top];
      stack[++top] = nums[i];
    }
    return ans;
  }
}
