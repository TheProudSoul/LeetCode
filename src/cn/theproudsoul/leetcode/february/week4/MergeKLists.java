package cn.theproudsoul.leetcode.february.week4;

import cn.theproudsoul.leetcode.common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 */
public class MergeKLists {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) return null;
    PriorityQueue<ListNode> minQueue = new PriorityQueue<>(lists.length, new ListNodeComparator());
    for (int i = 0; i < lists.length; i++) {
      if (lists[i] != null)
        minQueue.add(lists[i]);
    }
    ListNode root = new ListNode();
    ListNode currentRoot = root;
    while (!minQueue.isEmpty()) {
      ListNode current = minQueue.poll();
      currentRoot.next = current;
      currentRoot = current;
      if (current.next != null)
        minQueue.add(current.next);
    }
    return root.next;
  }

  class ListNodeComparator implements Comparator<ListNode> {

    @Override
    public int compare(ListNode o1, ListNode o2) {
      return o1.val - o2.val;
    }
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(5);
    ListNode l2 = new ListNode(1);
    l2.next = new ListNode(3);
    l2.next.next = new ListNode(4);
    ListNode l3 = new ListNode(2);
    l3.next = new ListNode(6);
    ListNode[] lists = {l1, l2, l3};
    MergeKLists testObj = new MergeKLists();
    testObj.mergeKLists(lists);
  }
}
