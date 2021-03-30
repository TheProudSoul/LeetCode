package cn.theproudsoul.leetcode.march.week4;

import cn.theproudsoul.leetcode.common.ListNode;

public class RotateRight {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null || k == 0) {
      return head;
    }
    ListNode front = head;
    ListNode back = head;
    int kk = k;
    while (front.next != null && kk-- > 0) {
      front = front.next;
    }
    if (kk > 0) {
      int len = k - kk + 1;
      k = len - k % len;
      if (k==len) {
        return head;
      }
      front.next = head;
      back = front;
      front = head;
      while (k-- > 0) {
        front = front.next;
        back = back.next;
      }
    } else {
      while (front.next != null) {
        front = front.next;
        back = back.next;
      }
      front.next = head;
      front = back.next;
    }
    back.next = null;
    return front;
  }

  public static void main(String[] args) {
    RotateRight rotateRight = new RotateRight();
    ListNode listNode = rotateRight.rotateRight(new ListNode(0, new ListNode(1, new ListNode(2))), 4);
    System.out.println(listNode.val);
//    ListNode listNode = rotateRight.rotateRight(new ListNode(1, new ListNode(2)), 2);
//    System.out.println(listNode.val);
  }
}
