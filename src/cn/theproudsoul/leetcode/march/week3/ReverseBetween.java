package cn.theproudsoul.leetcode.march.week3;

import cn.theproudsoul.leetcode.common.ListNode;

/**
 * 92. 反转链表 II
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 */
public class ReverseBetween {
  public ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode dummyNode = new ListNode(-1);
    dummyNode.next = head;
    int curIndex = 1;
    ListNode curNode = head;
    ListNode prevNode = dummyNode;
    while (curNode.next != null && curIndex != left) {
      prevNode = curNode;
      curNode = curNode.next;
      curIndex++;
    }
    ListNode anotherHead = curNode;
    ListNode anotherTail = curNode;
    for (int i = left; i <= right; i++) {
      prevNode.next = curNode.next;
      curNode.next = anotherHead;
      anotherHead = curNode;
      curNode = prevNode.next;
    }
    anotherTail.next = curNode;
    prevNode.next = anotherHead;
    return dummyNode.next;
  }

  public static void main(String[] args) {
    ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    ReverseBetween testObj = new ReverseBetween();
    ListNode result = testObj.reverseBetween(root, 2, 4);
    while (result != null) {
      System.out.print(result.val + "->");
      result = result.next;
    }
    System.out.println("NULL");
  }
}
