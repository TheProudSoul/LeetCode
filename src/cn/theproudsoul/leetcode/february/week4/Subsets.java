package cn.theproudsoul.leetcode.february.week4;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * https://leetcode-cn.com/problems/subsets/
 */
public class Subsets {
  public List<List<Integer>> subsets(int[] nums) {
    int bitMask = 0;
    for (int num : nums) {
      bitMask |= (1 << (num - (-10)));
    }
    List<List<Integer>> result = new ArrayList<>();
    int subset = bitMask;
    do {
      result.add(getSubset(subset));
      subset = (subset - 1) & bitMask;
    } while (subset != bitMask);
    return result;
  }

  private List<Integer> getSubset(int num) {
    List<Integer> subset = new ArrayList<>();
    for (int i = 0; i <= 20; i++) {
      if ((num | (1 << i)) == num)
        subset.add(i - 10);
    }
    return subset;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    Subsets testObj = new Subsets();
    System.out.println(testObj.subsets(nums));
  }
}
