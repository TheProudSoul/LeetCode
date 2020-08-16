package cn.theproudsoul.leetcode.august.week2;

import java.util.LinkedList;
import java.util.Queue;

public class CombinationIterator {
  private Queue<String> combinations;

  public CombinationIterator(String characters, int combinationLength) {
    combinations = new LinkedList();
    combine(characters, 0, "", combinationLength);
  }

  private void combine(String characters, int start, String soFar, int k) {
    if (k == 0) {
      combinations.add(soFar);
      return;
    }

    for(int i = start; i < characters.length(); i++) {
      combine(characters, i + 1, soFar + characters.charAt(i), k - 1);
    }
  }

  public String next() {
    return combinations.poll();
  }

  public boolean hasNext() {
    return !combinations.isEmpty();
  }

  public static void main(String[] args) {
    CombinationIterator obj = new CombinationIterator("abc", 2);
    String param_1 = obj.next();
    boolean param_2 = obj.hasNext();
  }
}
