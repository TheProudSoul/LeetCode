package cn.theproudsoul.leetcode.september.week1;

import java.util.*;

public class ContainsDuplicateIII {

  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    Integer[] manualMap = new Integer[nums.length];

    for (int i = 0; i < nums.length; i++) manualMap[i] = i;

    Arrays.sort(manualMap, Comparator.comparingInt(i -> nums[i]));
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 1; i++) {
      int j = i + 1;
      while (j < nums.length && nums[j] - nums[i] <= t) {
        if (Math.abs(manualMap[i] - manualMap[j]) <= k) return true;
        j++;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    ContainsDuplicateIII obj = new ContainsDuplicateIII();
    System.out.println(obj.containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
  }
}
