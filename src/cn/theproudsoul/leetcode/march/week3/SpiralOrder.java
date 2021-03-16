package cn.theproudsoul.leetcode.march.week3;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵<br>
 * https://leetcode-cn.com/problems/spiral-matrix/<br>
 * ---------------------------------------<br>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]<br>
 * 输出：[1,2,3,6,9,8,7,4,5]<br>
 */
public class SpiralOrder {
  public List<Integer> spiralOrder(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    List<Integer> result = new ArrayList<>();

    boolean goRow = n >= m;
    int limit = goRow ? m / 2 : n / 2;

    for (int i = 0; i < limit; i++) {
      // first row
      for (int j = i; j < n - i - 1; j++) {
        result.add(matrix[i][j]);
      }
      // last column
      for (int j = i; j < m - i - 1; j++) {
        result.add(matrix[j][n - 1 - i]);
      }
      // last row
      for (int j = n - i - 1; j > i; j--) {
        result.add(matrix[m - 1 - i][j]);
      }
      // first column
      for (int j = m - 1 - i; j > i; j--) {
        result.add(matrix[j][i]);
      }
    }
    if (goRow && m % 2 == 1) {
      for (int j = m / 2; j < n - m / 2; j++) {
        result.add(matrix[m / 2][j]);
      }
    } else if (!goRow && n % 2 == 1) {
      for (int j = n / 2; j < m - n / 2; j++) {
        result.add(matrix[j][n - 1 - n / 2]);
      }
    }

    return result;
  }

  public static void main(String[] args) {
    SpiralOrder testObj = new SpiralOrder();
    int[][] matrix = {{1, 2, 1}, {3, 4, 3}, {5, 6, 5}, {7, 8, 7}, {9, 10, 9}, {11, 12, 11}};
    List<Integer> result = testObj.spiralOrder(matrix);
    System.out.println(result);
  }
}
