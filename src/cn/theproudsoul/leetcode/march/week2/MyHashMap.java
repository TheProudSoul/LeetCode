package cn.theproudsoul.leetcode.march.week2;

import java.util.LinkedList;

/**
 * @author : zhengyijing
 * Date    : 2021/3/14
 * Time    : 5:28 下午
 * ---------------------------------------
 * Desc    :
 */
public class MyHashMap {

  private static class Pair {
    int key;
    int value;

    public Pair(int key, int value) {
      this.key = key;
      this.value = value;
    }

    public int getKey() {
      return key;
    }

    public void setKey(int key) {
      this.key = key;
    }

    public int getValue() {
      return value;
    }

    public void setValue(int value) {
      this.value = value;
    }
  }

  private final LinkedList<Pair>[] map;
  private static final int BASE = 769;

  /**
   * Initialize your data structure here.
   */
  public MyHashMap() {
    map = new LinkedList[BASE];
    for (int i = 0; i < BASE; i++) {
      map[i] = new LinkedList<Pair>();
    }
  }

  /**
   * value will always be non-negative.
   */
  public void put(int key, int value) {
    int bucket = key % BASE;
    for (Pair current : map[bucket]) {
      if (current.getKey() == key) {
        current.setValue(value);
        return;
      }
    }
    map[bucket].offerLast(new Pair(key, value));
  }

  /**
   * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
   */
  public int get(int key) {
    int bucket = key % BASE;
    for (Pair current : map[bucket]) {
      if (current.getKey() == key) {
        return current.getValue();
      }
    }
    return -1;
  }

  /**
   * Removes the mapping of the specified value key if this map contains a mapping for the key
   */
  public void remove(int key) {
    int bucket = key % BASE;
    map[bucket].removeIf(cur -> cur.getKey() == key);
  }

  public static void main(String[] args) {
    MyHashMap obj = new MyHashMap();
    obj.put(1, 1);
    obj.put(2, 2);
    System.out.println(obj.get(1));
    System.out.println(obj.get(3));
    obj.put(2, 1);
    System.out.println(obj.get(2));
    obj.remove(2);
    System.out.println(obj.get(2));
  }
}
