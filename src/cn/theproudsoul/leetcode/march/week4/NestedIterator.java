package cn.theproudsoul.leetcode.march.week4;

import java.util.Iterator;
import java.util.List;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

  // @return true if this NestedInteger holds a single integer, rather than a nested list.
  boolean isInteger();

  // @return the single integer that this NestedInteger holds, if it holds a single integer
  // Return null if this NestedInteger holds a nested list
  Integer getInteger();

  // @return the nested list that this NestedInteger holds, if it holds a nested list
  // Return null if this NestedInteger holds a single integer
  List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {
  private List<NestedInteger> nestedList;
  int current = 0;
  Iterator<Integer> tmp;

  public NestedIterator(List<NestedInteger> nestedList) {
    this.nestedList = nestedList;
  }

  @Override
  public Integer next() {
    if (!hasNext()) {
      return null;
    } else {
      if (tmp != null && tmp.hasNext()) {
        return tmp.next();
      } else {
        tmp = null;
        NestedInteger i = nestedList.get(current++);
        if (i.isInteger()) {
          return i.getInteger();
        } else {
          List<NestedInteger> nestedList = i.getList();
          if (nestedList.isEmpty()){

          }
          tmp = new NestedIterator(i.getList());
          return tmp.next();
        }
      }
    }
  }

  @Override
  public boolean hasNext() {
    return current != nestedList.size() || tmp != null;
  }
}
