package cn.theproudsoul.leetcode.august.week3;

import java.util.Arrays;

public class DistributeCandies {
  public int[] distributeCandies(int candies, int num_people) {
    int turn;
    int[] result = new int[num_people];
    for (turn = 1; candies >= turn * num_people * (turn * num_people + 1) >> 1; turn++) ;
    turn--;
    candies -= turn * num_people * (turn * num_people + 1) >> 1;
    for (int i = 0; i < num_people; i++) {
      // 等差数列 1,4,7,..., Sn = n(a1+an)/2
      int nextNeededCandies = turn * num_people + i + 1;
      if (candies >= nextNeededCandies) {
        result[i] = (turn + 1) * (i + nextNeededCandies + 1) / 2;
        candies -= nextNeededCandies;
      } else {
        result[i] = turn * (i + 2 + (turn - 1) * num_people + i) / 2 + candies;
        candies = 0;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    DistributeCandies obj = new DistributeCandies();
    assert Arrays.equals(obj.distributeCandies(10, 3), new int[]{5, 2, 3});
    assert Arrays.equals(obj.distributeCandies(7, 4), new int[]{1, 2, 3, 1});
  }
}
