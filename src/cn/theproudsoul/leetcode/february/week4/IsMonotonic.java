package cn.theproudsoul.leetcode.february.week4;

/**
 * @author : zhengyijing
 * Date    : 2021/2/28
 * Time    : 5:03 下午
 * ---------------------------------------
 * Desc    :
 */
public class IsMonotonic {
  public boolean isMonotonic(int[] A) {
    if (A.length <= 2) return true;
    return check(A, true) && check(A, false);

//    boolean negative = false, positive = false;
//    for (int i = 1; i < A.length; i++) {
//      if (A[i] - A[i - 1] < 0)
//        negative = true;
//      else if (A[i] - A[i - 1] > 0) positive = true;
//    }
//    return !negative || !positive;
  }

  boolean check(int[] A, boolean flag) {
    if (flag) {
      for (int i = 1; i < A.length; i++) {
        if (A[i] - A[i - 1] < 0) return false;

      }
    } else {
      for (int i = 1; i < A.length; i++) {
        if (A[i] - A[i - 1] > 0) return false;
      }
    }
    return true;
  }
}
