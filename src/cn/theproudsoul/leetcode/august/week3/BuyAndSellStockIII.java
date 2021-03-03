package cn.theproudsoul.leetcode.august.week3;

import java.util.Arrays;

public class BuyAndSellStockIII {
  public int maxProfit(int[] prices) {
    if (prices.length<=1) return 0;
    int sum = Arrays.stream(prices).sum();
    // 第一维度表示天数
    // 第二维度表示之前总共交易股票的次数：0、1、2
    // 第三维度表示是否持有股票：0 不持有、1 持有
    int[][][] MP = new int[prices.length][3][2];
    MP[0][0][0] = 0; // 第一天不买
    MP[0][0][1] = -sum; // 不存在的状态
    MP[0][1][0] = -sum; // 不存在的状态
    MP[0][1][1] = -prices[0]; // 第一天买入
    MP[0][2][0] = -sum; // 不存在的状态
    MP[0][2][1] = -sum; // 不存在的状态

    for (int i = 1; i < prices.length; i++) {
      for (int j = 0; j < 3; j++) {
        // 在第 i 天持有股票：1. 前一天持有股票状态不变，前一天不持有股票在这天买入
        if (j == 0) {
          MP[i][j][1] = MP[i - 1][j][1];
        } else {
          MP[i][j][1] = Math.max(MP[i - 1][j][1], MP[i - 1][j - 1][0] - prices[i]);
        }
        // 在第 i 天不持有股票：1. 前一天不持有股票状态不变，前一天持有股票在这天卖出
        MP[i][j][0] = Math.max(MP[i - 1][j][0], MP[i - 1][j][1] + prices[i]);
      }
    }

    // 返回最后一天的最大利润，手上应该没有股票
    return Math.max(Math.max(MP[prices.length - 1][0][0], MP[prices.length - 1][1][0]), MP[prices.length - 1][2][0]);
  }

  public static void main(String[] args) {
    int[] test1 = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
    int[] test2 = new int[]{1,2,3,4,5};
    int[] test3 = new int[]{7,6,4,3,1};
    BuyAndSellStockIII obj = new BuyAndSellStockIII();
    assert obj.maxProfit(test1) == 6;
    assert obj.maxProfit(test2) == 4;
    assert obj.maxProfit(test3) == 0;
  }
}
