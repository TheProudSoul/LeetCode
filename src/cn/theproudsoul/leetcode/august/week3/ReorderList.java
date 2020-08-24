package cn.theproudsoul.leetcode.august.week3;

import java.util.Stack;

class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

public class ReorderList {

  public void reorderList(ListNode head) {

    if (head == null || head.next == null || head.next.next == null) return;

    Stack<ListNode> stack = new Stack();
    stack.push(head);

    ListNode pointer = head;
    while (pointer.next != null) {
      pointer = pointer.next;
      stack.push(pointer);
    }

    while (stack.peek() != head) {
      ListNode tmp = head.next;
      head.next = stack.pop();
      if (head.next == tmp) {
        head.next.next = null;
        return;
      }
      head.next.next = tmp;
      head = tmp;
    }
    head.next = null;
  }

  public static void main(String[] args) {
    ListNode test1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
    ListNode test2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

    ReorderList obj = new ReorderList();
    obj.reorderList(test1);
    obj.reorderList(test2);
    return;
  }
}
