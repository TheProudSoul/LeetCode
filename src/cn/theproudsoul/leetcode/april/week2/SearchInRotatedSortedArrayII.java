package cn.theproudsoul.leetcode.april.week2;

/**
 * 81. 搜索旋转排序数组 II
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii
 */
public class SearchInRotatedSortedArrayII {
  public boolean search(int[] nums, int target) {
    return searchHelperI(nums, target, 0, nums.length - 1);
  }

  private boolean searchHelperI(int[] nums, int target, int left, int right) {
    if (left > right) return false;
    int mid = left + (right - left) / 2;
    if (nums[mid] == target) return true;
    int forLeft = mid - 1, forRight = mid + 1;
    while (forLeft >= left && nums[forLeft] == nums[mid]) forLeft--;
    while (forRight <= right && nums[forRight] == nums[mid]) forRight++;
    boolean leftResult = false, rightResult = false;
    if (forLeft >= left) {
      if (nums[forLeft] < nums[left])
        leftResult = searchHelperIII(nums, target, left, forLeft);
      else leftResult = searchHelperI(nums, target, left, forLeft);
    }

    if (forRight <= right) {
      if (nums[forRight] > nums[right]) {
        rightResult = searchHelperI(nums, target, forRight, right);
      } else rightResult = searchHelperII(nums, target, forRight, right);
    }
    return leftResult || rightResult;
//    // mid 要么在左边，要么在右边，分别讨论
//    if (nums[mid] > left) {
//      return searchHelperI(nums, target, forRight, right)
//          || searchHelperII(nums, target, left, mid - 1);
//    } else {
//      return searchHelperII(nums, target, mid + 1, right)
//          || searchHelperI(nums, target, left, mid - 1);
//    }
  }

  private boolean searchHelperII(int[] nums, int target, int left, int right) {
    if (left > right) return false;
    int mid = left + (right - left) / 2;
    if (nums[mid] == target) return true;
    if (nums[mid] > target) {
      while (mid > left && nums[mid - 1] == nums[mid]) mid--;
      return searchHelperII(nums, target, left, mid - 1);
    } else {
      while (mid < right && nums[mid + 1] == nums[mid]) mid++;
      return searchHelperII(nums, target, mid + 1, right);
    }
  }

  private boolean searchHelperIII(int[] nums, int target, int left, int right) {
    if (left > right) return false;
    int mid = left + (right - left) / 2;
    if (nums[mid] == target) return true;
    if (nums[mid] > target) {
      while (mid < right && nums[mid + 1] == nums[mid]) mid++;
      return searchHelperIII(nums, target, mid + 1, right);
    } else {
      while (mid > left && nums[mid - 1] == nums[mid]) mid--;
      return searchHelperIII(nums, target, left, mid - 1);
    }
  }

  public static void main(String[] args) {
    SearchInRotatedSortedArrayII testObj = new SearchInRotatedSortedArrayII();
//    int[] nums = new int[]{2, 5, 6, 0, 0, 1, 2};
    int[] nums = new int[]{10, 10, 10, -10, -10, -10, -10, -9, -9, -9, -9, -9, -9, -9, -8, -8, -8, -8, -8, -8, -8, -8, -7, -7, -7, -7, -6, -6, -6, -5, -5, -5, -4, -4, -4, -4, -3, -3, -2, -2, -2, -2, -2, -2, -2, -2, -1, -1, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 10, 10};
    System.out.println(testObj.search(nums, 13));
  }
}
