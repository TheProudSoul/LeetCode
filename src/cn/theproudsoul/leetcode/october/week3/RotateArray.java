package cn.theproudsoul.leetcode.october.week3;

import java.io.RandomAccessFile;

/**
 * @author : zhengyijing
 * Date    : 2020/10/17
 * Time    : 11:49 上午
 * ---------------------------------------
 * Desc    :
 */
public class RotateArray {
  public void rotate(int[] nums, int k) {
    int len = nums.length;
    k %= nums.length;
    reverse(nums, 0, len - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, len - 1);
  }

  public void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int tmp = nums[start];
      nums[start] = nums[end];
      nums[end] = tmp;
      start++;
      end--;
    }
  }

  public static void main(String[] args) {
    RotateArray object = new RotateArray();
    object.rotate(new int[]{-1, -100, 3, 99}, 2);
  }
}
