package cn.theproudsoul.leetcode.august.week5;

import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {
  public List<Integer> pancakeSort(int[] A) {
    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < A.length; i++) {
      /* 1. find max num from index 0 to (A.length - i) */
      int index = findMax(A, A.length - i);

      /* 2. flip to head */
      if (index != 0) {
        flip(A, index);
        result.add(index + 1);
      }

      /* 3. flip to tail */
      if (A.length - 1 - i != 0) {
        flip(A, A.length - 1 - i);
        result.add(A.length - i);
      }

    }
    return result;
  }

  private int findMax(int[] A, int index) {
    int indexOfMaxNum = 0;
    for (int i = 1; i < index; i++) {
      if (A[i] > A[indexOfMaxNum]) indexOfMaxNum = i;
    }
    return indexOfMaxNum;
  }

  private void flip(int[] A, int endIndex) {
    for (int i = 0; i <= endIndex / 2; i++) {
      int tmp = A[i];
      A[i] = A[endIndex-i];
      A[endIndex-i] = tmp;
    }
  }

  public static void main(String[] args) {
    PancakeSorting obj = new PancakeSorting();
    obj.pancakeSort(new int[]{3,2,4,1});
  }
}
