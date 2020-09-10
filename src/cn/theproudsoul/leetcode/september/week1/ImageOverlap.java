package cn.theproudsoul.leetcode.september.week1;

public class ImageOverlap {
  private int shiftAndCount(int xShift, int yShift, int[][] A, int[][] B) {
    // A 动 B 不动
    int len = A.length;
    int count = 0;
    for (int i = xShift; i < len; i++) {
      for (int j = yShift; j < len; j++) {
        count += (B[i - xShift][j - yShift] & A[i][j]);
      }
    }
    return count;
  }

  public int largestOverlap(int[][] A, int[][] B) {
    int maxOverlaps = 0;

    for (int yShift = 0; yShift < A.length; ++yShift)
      for (int xShift = 0; xShift < A.length; ++xShift) {
        // move one of the matrice up and left and vice versa.
        // (equivalent to move the other matrix down and right)
        maxOverlaps = Math.max(maxOverlaps, shiftAndCount(xShift, yShift, A, B));
        maxOverlaps = Math.max(maxOverlaps, shiftAndCount(xShift, yShift, B, A));
      }

    return maxOverlaps;
  }

  public static void main(String[] args) {
    int[][] A = new int[][]{{1, 1, 0}, {0, 1, 0}, {0, 1, 0}};
    int[][] B = new int[][]{{0, 0, 0}, {0, 1, 1}, {0, 0, 1}};
    ImageOverlap obj = new ImageOverlap();
    System.out.println(obj.largestOverlap(A, B));
  }
}
