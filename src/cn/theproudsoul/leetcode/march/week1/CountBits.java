package cn.theproudsoul.leetcode.march.week1;

/**
 * 338. 比特位计数
 * https://leetcode-cn.com/problems/counting-bits/
 */
public class CountBits {
  public int[] countBits(int num) {
    int[] result = new int[num + 1];
    for (int i = 1; i <= num - 1; i += 2) {
      result[i] = result[i - 1] + 1;
      result[i + 1] = result[(i + 1) / 2];
    }
    if (num % 2 == 0) {
      result[num] = result[num / 2];
    } else {
      result[num] = result[num - 1] + 1;
    }
    return result;
  }

  public static void main(String[] args) {
    CountBits testObj = new CountBits();
    testObj.countBits(5);
  }
}
