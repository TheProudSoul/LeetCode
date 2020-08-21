package cn.theproudsoul.leetcode.august.week3;

public class SortArrayByParity {
  public int[] sortArrayByParity(int[] A) {
    int tail = A.length - 1, head = 0;
    while (head < tail) {
      if (A[head] % 2 != 0) {
        int tmp = A[tail];
        A[tail--]=A[head];
        A[head]=tmp;
      }else {
        head++;
      }
    }
    return A;
  }
}
