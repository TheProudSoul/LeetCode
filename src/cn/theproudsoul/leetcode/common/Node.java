package cn.theproudsoul.leetcode.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zhengyijing
 * Date    : 2020/10/20
 * Time    : 8:40 下午
 * ---------------------------------------
 * Desc    :
 */
public class Node {
  public int val;
  public List<Node> neighbors;

  public Node() {
    val = 0;
    neighbors = new ArrayList<>();
  }

  public Node(int _val) {
    val = _val;
    neighbors = new ArrayList<>();
  }

  public Node(int _val, ArrayList<Node> _neighbors) {
    val = _val;
    neighbors = _neighbors;
  }
}
