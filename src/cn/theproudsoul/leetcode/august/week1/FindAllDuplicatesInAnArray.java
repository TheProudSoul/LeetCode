package cn.theproudsoul.leetcode.august.week1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindAllDuplicatesInAnArray {
  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> result = new LinkedList<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] <= 0 || nums[i] - 1 == i) continue;
      int index = nums[i] - 1;
      if (nums[index] == nums[i]) {
        nums[index] = 0;
        result.add(nums[i]);
      } else {
        int tmp = nums[index];
        nums[index] = nums[i];
        nums[i] = tmp;
        i--;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    FindAllDuplicatesInAnArray obj = new FindAllDuplicatesInAnArray();
    int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
    assert obj.findDuplicates(nums).equals(Arrays.asList(2, 3));
  }
}
