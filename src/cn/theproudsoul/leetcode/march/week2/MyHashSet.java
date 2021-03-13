package cn.theproudsoul.leetcode.march.week2;

/**
 * 705. 设计哈希集合<br>
 * https://leetcode-cn.com/problems/design-hashset/<br>
 * ---------------------------------------
 * Desc    :
 */
public class MyHashSet {
  boolean[] set;

  /**
   * Initialize your data structure here.
   */
  public MyHashSet() {
    set = new boolean[1000001];
  }

  public void add(int key) {
    set[key] = true;
  }

  public void remove(int key) {
    set[key] = false;
  }

  /**
   * Returns true if this set contains the specified element
   */
  public boolean contains(int key) {
    return set[key];
  }

  public static void main(String[] args) {

    MyHashSet myHashSet = new MyHashSet();

    System.out.println(myHashSet.contains(88)); // false
    myHashSet.remove(130);
    System.out.println(myHashSet.contains(3)); // false
    myHashSet.add(952);

    myHashSet.remove(767);
    myHashSet.add(206);
    System.out.println(myHashSet.contains(268)); // false
    myHashSet.add(658);

    myHashSet.add(918);
    myHashSet.add(709);
    myHashSet.remove(965);
    System.out.println(myHashSet.contains(558)); // false

    myHashSet.remove(645);
    myHashSet.add(667);      // set = [1]
    System.out.println(myHashSet.contains(206)); // true
    myHashSet.remove(404);
  }
}
