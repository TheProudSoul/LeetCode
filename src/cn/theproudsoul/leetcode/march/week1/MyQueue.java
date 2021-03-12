package cn.theproudsoul.leetcode.march.week1;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 */
public class MyQueue {

  private Stack<Integer> stackI;
  private Stack<Integer> stackII;

  /**
   * Initialize your data structure here.
   */
  public MyQueue() {
    stackI = new Stack<>();
    stackII = new Stack<>();
  }

  /**
   * Push element x to the back of queue.
   */
  public void push(int x) {
    stackI.push(x);
  }

  /**
   * Removes the element from in front of queue and returns that element.
   */
  public int pop() {
    if (stackII.isEmpty()) {
      while (!stackI.isEmpty()) {
        stackII.push(stackI.pop());
      }
    }
    return stackII.pop();
  }

  /**
   * Get the front element.
   */
  public int peek() {
    if (stackII.isEmpty()) {
      while (!stackI.isEmpty()) {
        stackII.push(stackI.pop());
      }
    }
    return stackII.peek();
  }

  /**
   * Returns whether the queue is empty.
   */
  public boolean empty() {
    return stackI.isEmpty() && stackII.isEmpty();
  }

  public static void main(String[] args) {
    MyQueue myQueue = new MyQueue();
    myQueue.push(1);
    myQueue.push(2);
    myQueue.push(3);
    myQueue.push(4);
    myQueue.pop();
    myQueue.push(5);
    myQueue.pop();
    myQueue.pop();
    myQueue.pop();
    myQueue.pop();
//    System.out.println("myQueue.push(1): ");
//    myQueue.push(1); // queue is: [1]
//    System.out.println("myQueue.push(2): "); // queue is: [1, 2] (leftmost is front of the queue)
//    myQueue.push(2);
//    System.out.println("myQueue.peek(): " + (myQueue.peek() == 1)); // return 1
//    System.out.println("myQueue.pop(): " + (myQueue.pop() == 1)); // return 1, queue is [2]
//    System.out.println("myQueue.empty(): " + (!myQueue.empty())); // return false
  }
}
