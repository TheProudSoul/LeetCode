package cn.theproudsoul.leetcode.august.week4;

import java.util.Random;

public class RandomPointInNonOverlappingRectangles {
  private final int[] sums;
  private final int[][] rects;
  private final Random rand = new Random();

  public RandomPointInNonOverlappingRectangles(int[][] rects) {
    this.rects = rects;
    sums = new int[rects.length];
    int sum = 0;
    for (int i = 0; i < rects.length; i++) {
      sum += (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
      sums[i] = sum;
    }
  }

  public int[] pick() {
    int target = rand.nextInt(sums[sums.length - 1]);
    // 二分查找
    int lo = 0, hi = sums.length - 1;
    while (lo < hi) {
      int mid = (hi - lo) / 2 + lo;
      if (target < sums[mid]) hi = mid;
      else lo = mid + 1;
    }
    int[] rect = rects[lo];
    int width = rect[2] - rect[0] + 1;
    int height = rect[3] - rect[1] + 1;
    int base = sums[lo] - width * height;
    return new int[]{rect[0] + (target - base) % width, rect[1] + (target - base) / width};
  }

  public static void main(String[] args) {
    int[][] rects = {{35330199, -46858448, 35330694, -46856950}};
    RandomPointInNonOverlappingRectangles obj = new RandomPointInNonOverlappingRectangles(rects);
    int[] param_1 = obj.pick();
    System.out.println(param_1);
  }
}
