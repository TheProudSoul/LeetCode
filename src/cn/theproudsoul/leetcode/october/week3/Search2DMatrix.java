package cn.theproudsoul.leetcode.october.week3;

/**
 * @author : zhengyijing
 * Date    : 2020/10/17
 * Time    : 11:12 上午
 * ---------------------------------------
 * Desc    :
 */
public class Search2DMatrix {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0) return false;
    int[] row = search1stDimension(matrix, target);
    return search2stDimension(row, target);
  }

  private boolean search2stDimension(int[] row, int target) {
    int lo = 0, hi = row.length - 1;
    while (lo <= hi) {
      int mid = (hi - lo) / 2 + lo;
      if (row[mid] > target) hi = mid - 1;
      else if (row[mid] < target) lo = mid + 1;
      else return true;
    }
    return false;
  }

  private int[] search1stDimension(int[][] matrix, int target) {
    int lo = 0, hi = matrix.length - 1;
    while (lo < hi) {
      int mid = (hi - lo) / 2 + lo;
      if (matrix[mid][0] > target) hi = mid - 1;
      else if (matrix[mid][0] <= target && mid + 1 < matrix.length && matrix[mid + 1][0] > target) return matrix[mid];
      else lo = mid + 1;
    }
    return matrix[lo];
  }

  public static void main(String[] args) {
    int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}};
    Search2DMatrix object = new Search2DMatrix();
    object.searchMatrix(matrix, 20);
  }
}
