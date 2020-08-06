package cn.theproudsoul.leetcode.august.week1;

class SetNode {
  SetNode(int v) {
    this.data = v;
  }

  int data;
  SetNode leftChild;
  SetNode rightChild;
}

public class MyHashSet {
  SetNode root;

  public MyHashSet() {

  }

  public void add(int key) {
    if (root == null) {
      root = new SetNode(key);
      return;
    }

    SetNode n = root;
    while (n.data != key) {
      if (n.data > key) {
        if (n.leftChild == null) {
          n.leftChild = new SetNode(key);
          return;
        }
        n = n.leftChild;
      } else if (n.data < key) {
        if (n.rightChild == null) {
          n.rightChild = new SetNode(key);
          return;
        }
        n = n.rightChild;
      }
    }
  }

  public void remove(int key) {
    SetNode n = root;
    SetNode nn = null;
    while (n != null && n.data != key) {
      nn = n;
      if (key > n.data) n = n.rightChild;
      else n = n.leftChild;
    }
    // 没找到
    if (n == null) return;
    // 有两个叶子节点
    if (n.leftChild != null && n.rightChild != null) {
      // 找到右子树最小节点
      SetNode rightMinParent = n;
      SetNode rightMin = n.rightChild;
      while (rightMin.leftChild != null) {
        rightMinParent = rightMin;
        rightMin = rightMin.leftChild;
      }
      n.data = rightMin.data;
      n = rightMin;
      nn = rightMinParent;
    }

    // 一个叶子节点或者无叶子节点
    SetNode child;
    if (n.rightChild != null) child = n.rightChild;
    else child = n.leftChild;

    // 删除
    if (nn == null) root = child;
    else if (nn.leftChild == n) nn.leftChild = child;
    else nn.rightChild = child;
  }

  /**
   * Returns true if this set contains the specified element
   */
  public boolean contains(int key) {
    SetNode n = root;
    while (n != null) {
      if (key > n.data) n = n.rightChild;
      else if (key < n.data) n = n.leftChild;
      else return true;
    }
    return false;
  }

  public static void main(String[] args) {
    MyHashSet hashSet = new MyHashSet();
    hashSet.add(9);
    hashSet.remove(19);
    hashSet.add(14);
    hashSet.remove(19);
    hashSet.remove(9);
    hashSet.add(0);
    hashSet.add(3);
    hashSet.add(4);
    hashSet.add(0);
    hashSet.remove(9);
  }
}
