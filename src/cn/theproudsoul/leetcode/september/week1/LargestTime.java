package cn.theproudsoul.leetcode.september.week1;

public class LargestTime {
  private int[] result;

  public String largestTimeFromDigits(int[] nums) {
    permutate(nums, 0);
    return format(result);
  }

  private void permutate(int[] nums, int offset) {
    if (offset == nums.length - 1) {
      if (isValid(nums) && isBetter(result, nums)) {
        if (result == null) {
          result = new int[4];
        }
        System.arraycopy(nums, 0, result, 0, 4);
      }
      return;
    }

    for (int i = offset; i < nums.length; i++) {
      int tmp = nums[offset];
      nums[offset] = nums[i];
      nums[i] = tmp;
      permutate(nums, offset + 1);
      nums[i] = nums[offset];
      nums[offset] = tmp;
    }

  }

  private boolean isValid(int[] nums) {
    return nums[0] <= 2
        && (nums[0] != 2 || nums[1] <= 3)
        && nums[2] <= 5;


  }

  private boolean isBetter(int[] result, int[] nums) {
    if (result == null) {
      return true;
    }
    for (int i = 0; i < 3; i++) {
      if (result[i] == nums[i]) {
        continue;
      }
      return result[i] < nums[i];
    }
    return false;
  }

  private String format(int[] nums) {
    if (nums == null) {
      return "";
    } else {
      return String.valueOf(nums[0]) + nums[1] + ':' + nums[2] + nums[3];
    }
  }

  public static void main(String[] args) {
    LargestTime obj = new LargestTime();
    obj.largestTimeFromDigits(new int[]{1, 2, 3, 4});
  }
}
