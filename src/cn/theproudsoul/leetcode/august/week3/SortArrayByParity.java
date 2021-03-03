package cn.theproudsoul.leetcode.august.week3;

public class SortArrayByParity {
  public int[] sortArrayByParity(int[] A) {
    int tail = A.length - 1, head = 0;
    while (head < tail) {
//      if (A[head] % 2 != 0) {
//        int tmp = A[tail];
//        A[tail--]=A[head];
//        A[head]=tmp;
//      }else {
//        head++;
//      }

      // 改为使用快排
      if (A[head] % 2 > A[tail] % 2) {
        int tmp = A[tail];
        A[tail--] = A[head];
        A[head++] = tmp;
      }
      while (A[head] % 2 == 0) head++;
      while (A[tail] % 2 != 0) tail--;
    }
    return A;
  }
}
