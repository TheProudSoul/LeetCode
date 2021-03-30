package cn.theproudsoul.leetcode.march.week4;

public class SearchMatrix {

  public boolean searchMatrix(int[][] matrix, int target) {
    int n = matrix.length;
    int m = matrix[0].length;

    if (matrix[0][0] > target || matrix[n - 1][m - 1] < target) return false;

    // 最后一个不大于
    int left = 0, right = n - 1;
    while (left < right) {
      int mid = (right - left) / 2 + left;
      if (matrix[mid][0] > target) {
        right = mid - 1;
      } else if (matrix[mid][0] <= target && (mid == (n - 1) || matrix[mid + 1][0] > target)) {
        left = mid;
        break;
      } else {
        left = mid + 1;
      }
    }

    int[] theRow = matrix[left];
    left = 0;
    right = m - 1;
    while (left <= right) {
      int mid = (right - left) / 2 + left;
      if (theRow[mid] > target) {
        right = mid - 1;
      } else if (theRow[mid] < target) {
        left = mid + 1;
      } else {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
//    int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
    int[][] matrix = new int[][]{{1}, {3}};
    SearchMatrix testObj = new SearchMatrix();
    boolean result = testObj.searchMatrix(matrix, 2);
    System.out.println(result);
  }
}
