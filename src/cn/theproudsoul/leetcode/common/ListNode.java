package cn.theproudsoul.leetcode.common;

/**
 * @author : zhengyijing
 * Date    : 2020/10/14
 * Time    : 11:18 上午
 * ---------------------------------------
 * Desc    :
 */
public class ListNode {
  public int val;
  public ListNode next;

  public ListNode() {
  }

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}
