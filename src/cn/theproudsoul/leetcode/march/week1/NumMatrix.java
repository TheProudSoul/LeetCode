package cn.theproudsoul.leetcode.march.week1;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 * https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
 */
public class NumMatrix {

  int[][] matrixSum;

  public NumMatrix(int[][] matrix) {
    int rowLength = matrix.length;
    if (rowLength == 0) return;
    int colLength = matrix[0].length;
    if (colLength == 0) return;
    matrixSum = new int[rowLength + 1][colLength + 1];

    for (int i = 0; i < rowLength; i++) {
      for (int j = 0; j < colLength; j++) {
        matrixSum[i + 1][j + 1] = matrixSum[i][j + 1] + matrixSum[i + 1][j] - matrixSum[i][j] + matrix[i][j];
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    return matrixSum[row2 + 1][col2 + 1] - matrixSum[row1][col2 + 1] - matrixSum[row2 + 1][col1] + matrixSum[row1][col1];
  }

  public static void main(String[] args) {
    int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
    NumMatrix testObj = new NumMatrix(matrix);
    System.out.println(testObj.sumRegion(2, 1, 4, 3));
    System.out.println(testObj.sumRegion(1, 1, 2, 2));
    System.out.println(testObj.sumRegion(1, 2, 2, 4));
  }
}
