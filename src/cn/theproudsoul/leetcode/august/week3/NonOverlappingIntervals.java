package cn.theproudsoul.leetcode.august.week3;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
  public int eraseOverlapIntervals(int[][] intervals) {

    if (intervals.length <= 1)  return 0;

    // https://en.wikipedia.org/wiki/Interval_scheduling#Interval_Scheduling_Maximization
    Arrays.sort(intervals, new IntervalComparator());
    int end = intervals[0][1], count = 0;

    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] < end) count++;
      else end = intervals[i][1];
    }
    return count;
  }
  class IntervalComparator implements Comparator<int[]> {

    @Override
    public int compare(int[] o1, int[] o2) {
      return o1[1] - o2[1];
    }
  }

  public static void main(String[] args) {
    int[][] test1 = new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}, new int[]{1, 3}};
    NonOverlappingIntervals obj1 = new NonOverlappingIntervals();
    assert obj1.eraseOverlapIntervals(test1)==1;

    int[][] test2 = new int[][]{new int[]{1, 2}, new int[]{1, 2}, new int[]{1, 2}};
    NonOverlappingIntervals obj2 = new NonOverlappingIntervals();
    assert obj2.eraseOverlapIntervals(test2)==2;
  }
}
