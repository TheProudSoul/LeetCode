package cn.theproudsoul.leetcode.march.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 354. 俄罗斯套娃信封问题
 * https://leetcode-cn.com/problems/russian-doll-envelopes/
 * <p>
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 */
public class MaxEnvelopes {
//  int[][] envelopes;
//  int[][] status;

  public int maxEnvelopes(int[][] envelopes) {
    if (envelopes == null) return 0;
    if (envelopes.length < 2) return envelopes.length;

    Arrays.sort(envelopes, new Comparator<int[]>() {
      public int compare(int[] e1, int[] e2) {
        if (e1[0] != e2[0]) {
          return e1[0] - e2[0];
        } else {
          return e2[1] - e1[1];
        }
      }
    });
//    this.envelopes = envelopes;
//    this.status = new int[envelopes.length][2];
//    System.out.println(Arrays.deepToString(envelopes));

    List<Integer> f = new ArrayList<>();
    f.add(envelopes[0][1]);
    for (int i = 1; i < envelopes.length; ++i) {
      int num = envelopes[i][1];
      if (num > f.get(f.size() - 1)) {
        f.add(num);
      } else {
        int index = binarySearch(f, num);
        f.set(index, num);
      }
    }
    return f.size();

  }
  public int binarySearch(List<Integer> f, int target) {
    int low = 0, high = f.size() - 1;
    while (low < high) {
      int mid = (high - low) / 2 + low;
      if (f.get(mid) < target) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    return low;
  }

//  private int findLargest(int num, int left, int right) {
//    if (left >= right) return left;
//
//    int mid = left + ((right - left) >> 1);
//    if (status[mid][0] < num) {
//      return findLargest(num, mid + 1, right);
//    } else {
//      return findLargest(num, left, mid - 1);
//    }
//  }

//  private int getEnvelope(int w, int h, int currentNum, int nextIndex) {
//    if (nextIndex == envelopes.length) return currentNum;
//    if (envelopes[nextIndex][0] > w && envelopes[nextIndex][1] > h) {
//      return Math.max(getEnvelope(w, h, currentNum, nextIndex + 1),
//          getEnvelope(envelopes[nextIndex][0], envelopes[nextIndex][1], currentNum + 1, nextIndex + 1));
//    } else {
//      return getEnvelope(w, h, currentNum, nextIndex + 1);
//    }
//  }

  public static void main(String[] args) {
    MaxEnvelopes testObj = new MaxEnvelopes();
    int[][] envelopes = {{2, 100}, {3, 200}, {4, 300}, {5, 500}, {5, 400}, {5, 250}, {6, 370}, {6, 360}, {7, 380}};
    int[][] envelopes2 = {{1, 1}, {1, 1}, {1, 1}};
    int result = testObj.maxEnvelopes(envelopes2);
    System.out.println(result);
  }
}
