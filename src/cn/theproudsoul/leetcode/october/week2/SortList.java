package cn.theproudsoul.leetcode.october.week2;


import cn.theproudsoul.leetcode.common.ListNode;

/**
 * @author : zhengyijing
 * Date    : 2020/10/14
 * Time    : 11:17 上午
 * ---------------------------------------
 * Desc    :
 */
public class SortList {
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode middle = getMid(head);
    ListNode left = sortList(head);
    ListNode right = sortList(middle);
    return merge(left, right);
  }

  private ListNode merge(ListNode left, ListNode right) {
    ListNode dummyHead = new ListNode();
    ListNode tail = dummyHead;
    while (left != null && right != null) {
      if (left.val > right.val) {
        tail.next = right;
        right = right.next;
      } else {
        tail.next = left;
        left = left.next;
      }
      tail = tail.next;
    }
    tail.next = left != null ? left : right;
    return dummyHead.next;
  }

  ListNode getMid(ListNode head) {
    ListNode midPrev = null;
    while (head != null && head.next != null) {
      midPrev = (midPrev == null) ? head : midPrev.next;
      head = head.next.next;
    }
    ListNode mid = midPrev.next;
    midPrev.next = null;
    return mid;
  }
}
