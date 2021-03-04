package cn.theproudsoul.leetcode.march.week1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 354. 俄罗斯套娃信封问题
 * https://leetcode-cn.com/problems/russian-doll-envelopes/
 * <p>
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 */
public class MaxEnvelopes {
  int[][] envelopes;
  int[] status;

  public int maxEnvelopes(int[][] envelopes) {
    if (envelopes == null) return 0;
    if (envelopes.length < 2) return envelopes.length;

    Arrays.sort(envelopes, (o1, o2) -> o2[1] - o1[1]);
    Arrays.sort(envelopes, Comparator.comparingInt(o -> o[0]));
    this.envelopes = envelopes;
    this.status = new int[envelopes.length];
    System.out.println(Arrays.deepToString(envelopes));

    status[0] = envelopes
    for (int i = 1; i < envelopes.length; i++) {

    }

    return result;
  }

  private int getEnvelope(int w, int h, int currentNum, int nextIndex) {
    if (nextIndex == envelopes.length) return currentNum;
    if (envelopes[nextIndex][0] > w && envelopes[nextIndex][1] > h) {
      return Math.max(getEnvelope(w, h, currentNum, nextIndex + 1),
          getEnvelope(envelopes[nextIndex][0], envelopes[nextIndex][1], currentNum + 1, nextIndex + 1));
    } else {
      return getEnvelope(w, h, currentNum, nextIndex + 1);
    }
  }

  public static void main(String[] args) {
    MaxEnvelopes testObj = new MaxEnvelopes();
    int[][] envelopes = {{2, 100}, {3, 200}, {4, 300}, {5, 500}, {5, 400}, {5, 250}, {6, 370}, {6, 360}, {7, 380}};
    int result = testObj.maxEnvelopes(envelopes);
    System.out.println(result);
  }
}
