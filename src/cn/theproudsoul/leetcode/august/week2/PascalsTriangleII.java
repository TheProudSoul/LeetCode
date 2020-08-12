package cn.theproudsoul.leetcode.august.week2;

import cn.theproudsoul.leetcode.utils.ListGenerator;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
  public List<Integer> getRow(int rowIndex) {
    ArrayList<Integer> list = new ArrayList<>(rowIndex + 1);
    list.add(1);

    for (int i = 1; i <= rowIndex; i++) {
      list.add(0);
      for (int j = i; j > 0; j--) {
        list.set(j, list.get(j) + list.get(j - 1));
      }
    }
    return list;
  }

  public static void main(String[] args) {
    PascalsTriangleII obj = new PascalsTriangleII();
    assert ListGenerator.asList(1,3,3,1).equals(obj.getRow(3));
  }
}
