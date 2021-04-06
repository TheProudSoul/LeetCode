package cn.theproudsoul.leetcode.april.week2;

public class RemoveDuplicatesII {
  public int removeDuplicates(int[] nums) {
    int cur = nums[0], count = 0, navCount = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == cur) {
        count++;
        if (count > 2) {
          nums[i] = 10001;
          navCount++;
        }
      } else {
        cur = nums[i];
        count = 1;
      }
    }
    int j = 0;
    for (int i = 2; i < nums.length - navCount; i++) {
      if (nums[i] == 10001) {
        if (j == 0) j = i + 1;
        while (nums[j] == 10001) j++;
        nums[i] = nums[j];
        nums[j] = 10001;
        j++;
      }
    }
    return nums.length - navCount;
  }
}
