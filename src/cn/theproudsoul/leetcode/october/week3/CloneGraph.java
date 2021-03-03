package cn.theproudsoul.leetcode.october.week3;

import cn.theproudsoul.leetcode.common.Node;

import java.util.*;

/**
 * @author : zhengyijing
 * Date    : 2020/10/20
 * Time    : 8:39 下午
 * ---------------------------------------
 * Desc    :
 */
public class CloneGraph {
  private final Map<Node, Node> visited = new HashMap<>();

  public Node cloneGraph(Node node) {
    if (node == null)
      return null;

    Node newGraph = new Node(node.val);
    visitANode(node, newGraph);
    return newGraph;
  }

  private void visitANode(Node node, Node newNode) {
    if (node.neighbors.isEmpty() || !newNode.neighbors.isEmpty()) return;
    visited.put(node, newNode);
    node.neighbors.forEach(neighbor -> {
      Node temp = visited.getOrDefault(neighbor, new Node(neighbor.val));
      newNode.neighbors.add(temp);
      visitANode(neighbor, temp);
    });
  }

  public static void main(String[] args) {
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);

    node1.neighbors = Arrays.asList(node2, node4);
    node2.neighbors = Arrays.asList(node1, node3);
    node3.neighbors = Arrays.asList(node2, node4);
    node4.neighbors = Arrays.asList(node1, node3);

    CloneGraph obj = new CloneGraph();
    Node newGraph = obj.cloneGraph(node1);
  }
}
