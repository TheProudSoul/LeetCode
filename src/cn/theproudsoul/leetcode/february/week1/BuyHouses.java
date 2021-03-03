package cn.theproudsoul.leetcode.february.week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author : zhengyijing
 * Date    : 2021/2/1
 * Time    : 9:48 下午
 * ---------------------------------------
 * Desc    :
 */
public class BuyHouses {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int cases = in.nextInt();

    for (int i = 1; i <= cases; i++) {
      int n = in.nextInt();
      int b = in.nextInt();
      int[] costs = new int[n];
      for (int j = 0; j < n; j++) {
        costs[j] = in.nextInt();
      }
      System.out.println("Case #" + i + ": " + maxNumberOfHouse(b, costs));
    }
  }

  private static int maxNumberOfHouse(int money, int[] costs) {
    int[] prices = new int[1001];
    for (int cost : costs) {
      prices[cost]++;
    }
    int n = 0;
    for (int j = 0; j < 1001; j++) {
      while (prices[j] > 0 && (money -= j) >= 0) {
        n++;
        prices[j]--;
      }
      if (money < 0) {
        return n;
      }
    }
    return n;
  }
}
