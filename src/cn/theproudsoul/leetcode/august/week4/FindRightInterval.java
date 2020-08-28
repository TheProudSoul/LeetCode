package cn.theproudsoul.leetcode.august.week4;

import java.util.Arrays;
import java.util.Comparator;

public class FindRightInterval {

  private int[][] intervals;
  private Integer[] sortedIntervals;

  public int[] findRightInterval(int[][] intervals) {
    this.intervals = intervals;
    sortedIntervals = new Integer[intervals.length];
    for (int i = 0; i < intervals.length; i++) {
      sortedIntervals[i] = i;
    }

    Arrays.sort(sortedIntervals, new IntervalComparator());

    int[] result = new int[intervals.length];

    for (int i = 0; i < intervals.length; i++) {
      result[i] = find(intervals[i][1]);
    }

    return result;
  }

  // 查找第一个大于等于给定值的元素
  private int find(int value) {
    int lo = 0, hi = sortedIntervals.length - 1;

    while (lo <= hi) {
      int mid = ((hi - lo) >> 1) + lo;
      if (intervals[sortedIntervals[mid]][0] >= value) {
        if ((mid == 0) || (intervals[sortedIntervals[mid - 1]][0] < value)) return sortedIntervals[mid];
        else hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }
    return -1;
  }

  class IntervalComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
      return intervals[o1][0] - intervals[o2][0];
    }
  }

  public static void main(String[] args) {
    FindRightInterval obj = new FindRightInterval();
    int[][] test1 = new int[][]{new int[]{1, 2}};
    assert Arrays.equals(obj.findRightInterval(test1), new int[]{-1});
    int[][] test2 = new int[][]{new int[]{1, 4}, new int[]{2, 3}, new int[]{3, 4}};
    assert Arrays.equals(obj.findRightInterval(test2), new int[]{-1, 2, -1});
  }
}
