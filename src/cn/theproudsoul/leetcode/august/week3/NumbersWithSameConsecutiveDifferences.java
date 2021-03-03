package cn.theproudsoul.leetcode.august.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersWithSameConsecutiveDifferences {

  public int[] numsSameConsecDiff(int N, int K) {
    // N 是 digits，K 是 digits 相差
    if (N == 1) return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    if (K == 0) {
      int[] result = new int[9];
      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < N; j++) {
          result[i] += Math.pow(10, j) * (i + 1);
        }
      }
      return result;
    }

    List<Integer> result = new ArrayList<>();
    for (int i = 1; i < 10; i++) {
      helper(i, 1, N, K, result);
    }
    return result.stream().mapToInt(i -> i).toArray();
  }

  private void helper(int num, int digit, int digits, int diff, List<Integer> result) {
    if (digit == digits) result.add(num);
    else {
      int lastDigit = num % 10;
      if (lastDigit - diff >= 0) helper(num * 10 + lastDigit - diff, digit + 1, digits, diff, result);
      if (9 - lastDigit >= diff) helper(num * 10 + lastDigit + diff, digit + 1, digits, diff, result);
    }
  }

  public static void main(String[] args) {
    NumbersWithSameConsecutiveDifferences obj = new NumbersWithSameConsecutiveDifferences();
    assert Arrays.equals(obj.numsSameConsecDiff(3, 7), new int[]{181, 292, 707, 818, 929});
    assert Arrays.equals(obj.numsSameConsecDiff(3, 0), new int[]{111, 222, 333, 444, 555, 666, 777, 888, 999});
  }
}
