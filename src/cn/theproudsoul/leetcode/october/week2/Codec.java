package cn.theproudsoul.leetcode.october.week2;

import cn.theproudsoul.leetcode.common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : zhengyijing
 * Date    : 2020/10/9
 * Time    : 4:12 下午
 * ---------------------------------------
 * Desc    :
 */
public class Codec {
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    serialize(root, sb);
    return sb.toString();
  }

  public void serialize(TreeNode root, StringBuilder sb) {
    if (root == null) return;
    sb.append(root.val).append(",");
    serialize(root.left, sb);
    serialize(root.right, sb);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data.isEmpty()) return null;
    Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
    return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  public TreeNode deserialize(Queue<String> q, int lower, int upper) {
    if (q.isEmpty()) return null;
    String s = q.peek();
    int val = Integer.parseInt(s);
    if (val < lower || val > upper) return null;
    q.poll();
    TreeNode root = new TreeNode(val);
    root.left = deserialize(q, lower, val);
    root.right = deserialize(q, val, upper);
    return root;
  }

  public static void main(String[] args) {
    // Your Codec object will be instantiated and called as such:
    Codec ser = new Codec();
    TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
    // Codec deser = new Codec();
    String tree = ser.serialize(root);
    System.out.println(tree);
    // TreeNode ans = deser.deserialize(tree);
    // return ans;
  }
}
