package cn.theproudsoul.leetcode.february.week4;

import cn.theproudsoul.leetcode.common.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 */
public class RemoveNthFromEnd {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    int position = 0;
    ListNode frontPointer = head, backPointer = head;
    while (frontPointer.next != null && position < n) {
      frontPointer = frontPointer.next;
      position++;
    }

    if (position == n - 1 && frontPointer.next == null)
      return head.next;

    while (frontPointer.next != null) {
      frontPointer = frontPointer.next;
      backPointer = backPointer.next;
    }
    backPointer.next = backPointer.next.next;
    return head;
  }
}
