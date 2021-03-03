package cn.theproudsoul.leetcode.february.week1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : zhengyijing
 * Date    : 2021/2/3
 * Time    : 11:01 下午
 * ---------------------------------------
 * Desc    :
 */
public class FindMaxLength {
  public int findMaxLength(int[] nums) {
    Map<Integer, Integer> count2index = new HashMap<>();
    count2index.put(0, -1);
    int[] adder = {-1, 1};
    int count = 0, result = 0;
    for (int i = 0; i < nums.length; i++) {
      count += adder[nums[i]];
      if (count2index.containsKey(count)) {
        result = Math.max(result, (i - count2index.get(count)));
      } else {
        count2index.put(count, i);
      }
    }
    return result;
  }
}
