package cn.theproudsoul.leetcode.august.week4;

import java.util.HashSet;
import java.util.Set;

public class MinimumCostForTickets {
  // dp(i)=min(dp(i+1)+costs[0],dp(i+7)+costs[1],dp(i+30)+costs[2])
  Integer[] memo;
  Set<Integer> daySet;
  int[] costs, days;

  public int mincostTickets(int[] days, int[] costs) {
    this.costs = costs;
    memo = new Integer[366];
    daySet = new HashSet<>();
    for (int i = 0; i < days.length; i++) {
      daySet.add(days[i]);
    }
    return helper(1);

  }

  private int helper(int day) {
    if (day > 365) return 0;
    if (memo[day] != null) return memo[day];

    if (daySet.contains(day)) {
      memo[day] = Math.min(helper(day + 1) + costs[0], helper(day + 7) + costs[1]);
      memo[day] = Math.min(memo[day], helper(day + 30) + costs[2]);
    } else {
      memo[day] = helper(day + 1);
    }

    return memo[day];
  }

  int[] durations = new int[]{1, 7, 30};

  public int mincostTickets2(int[] days, int[] costs) {
    this.days = days;
    this.costs = costs;
    memo = new Integer[days.length];

    return dp(0);
  }

  public int dp(int i) {
    if (i >= days.length)
      return 0;
    if (memo[i] != null)
      return memo[i];

    int ans = Integer.MAX_VALUE;
    int j = i;
    for (int k = 0; k < 3; ++k) {
      while (j < days.length && days[j] < days[i] + durations[k])
        j++;
      ans = Math.min(ans, dp(j) + costs[k]);
    }

    memo[i] = ans;
    return ans;
  }

  public static void main(String[] args) {
    MinimumCostForTickets obj = new MinimumCostForTickets();
    assert obj.mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}) == 11;
    assert obj.mincostTickets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[]{2, 7, 15}) == 17;
  }
}
