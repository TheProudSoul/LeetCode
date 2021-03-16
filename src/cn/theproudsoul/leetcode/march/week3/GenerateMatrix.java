package cn.theproudsoul.leetcode.march.week3;

import java.util.Arrays;

/**
 * 59. 螺旋矩阵 II<br>
 * https://leetcode-cn.com/problems/spiral-matrix-ii/<br>
 */
public class GenerateMatrix {
  public int[][] generateMatrix(int n) {
    int[][] matrix = new int[n][n];

    int cur = 1;

    for (int i = 0; i < n; i++) {
      // first row
      for (int j = i; j < n - i - 1; j++) {
        matrix[i][j] = cur++;
      }
      // last column
      for (int j = i; j < n - i - 1; j++) {
        matrix[j][n - 1 - i] = cur++;
      }
      // last row
      for (int j = n - i - 1; j > i; j--) {
        matrix[n - 1 - i][j] = cur++;
      }
      // first column
      for (int j = n - 1 - i; j > i; j--) {
        matrix[j][i] = cur++;
      }
    }
    if (n % 2 == 1) {
      matrix[n / 2][n / 2] = cur;
    }

    return matrix;
  }

  public static void main(String[] args) {
    GenerateMatrix testObject = new GenerateMatrix();
    int[][] result = testObject.generateMatrix(3);
    System.out.println(Arrays.deepToString(result));
  }
}
