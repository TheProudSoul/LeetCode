package cn.theproudsoul.leetcode.august.week1;

import java.util.*;
import java.util.stream.Collectors;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

public class VerticalOrderTraversalOfABinaryTree {
  class Point {
    int x;
    int y;
    int val;

    public Point(int x, int y, int val) {
      this.x = x;
      this.y = y;
      this.val = val;
    }
  }

  public List<List<Integer>> verticalTraversal(TreeNode root) {
    // Key: x
    TreeMap<Integer, List<Point>> map = new TreeMap<>();
    List<List<Integer>> result = new ArrayList<>();

    // 遍历 root
    travelTreeHelper(map, root, 0, 0);

    map.forEach((e, v) -> {
      if (v.size() != 1) {
        v.sort((p1, p2) -> p1.x == p2.x ? p1.y == p2.y ? p1.val - p2.val : p2.y - p1.y : p1.x - p2.x);
      }
      List<Integer> tmp = v.stream().map((l) -> l.val).collect(Collectors.toList());
      result.add(tmp);
    });
    return result;
  }

  private void travelTreeHelper(TreeMap<Integer, List<Point>> map, TreeNode root, int x, int y) {
    if (root == null) return;
    travelTreeHelper(map, root.left, x - 1, y - 1);
    travelTreeHelper(map, root.right, x + 1, y - 1);
    if (!map.containsKey(x)) {
      map.put(x, new ArrayList<>());
    }
    map.get(x).add(new Point(x, y, root.val));
  }

  public static void main(String[] args) {
    VerticalOrderTraversalOfABinaryTree obj = new VerticalOrderTraversalOfABinaryTree();
    TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
        new TreeNode(3, new TreeNode(6), new TreeNode(7)));
    List<List<Integer>> tmp = obj.verticalTraversal(root);
    System.out.println(tmp);
  }
}
