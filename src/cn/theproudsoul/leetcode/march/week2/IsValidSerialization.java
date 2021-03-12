package cn.theproudsoul.leetcode.march.week2;

import java.util.Arrays;

/**
 * 331. 验证二叉树的前序序列化<br>
 * https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/<br>
 * ---------------------------------------<br>
 * 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"<br>
 * 输出: true<br>
 * ---------------------------------------<br>
 * 输入: "1,#"<br>
 * 输出: false<br>
 * ---------------------------------------<br>
 * 输入: "9,#,#,1"<br>
 * 输出: false<br>
 */
public class IsValidSerialization {
  String[] biArray;
  String nullValue = "#";

  public boolean isValidSerialization(String preorder) {
    biArray = preorder.split(",");
    return preorder(0) == biArray.length;
  }

  private int preorder(int rootIndex) {
    if (biArray[rootIndex].equals(nullValue)) {
      return rootIndex + 1;
    }
    if (rootIndex + 2 >= biArray.length)
      return -1;

    // both leaves
    if (biArray[rootIndex + 1].equals(nullValue) && biArray[rootIndex + 2].equals(nullValue)) {
      return rootIndex + 3;
    }
    // left child is leaf
    if (biArray[rootIndex + 1].equals(nullValue)) {
      return preorder(rootIndex + 2);
    }
    // get right child index
    int rightChildIndex = preorder(rootIndex + 1);
    if (rightChildIndex == -1 || rightChildIndex >= biArray.length) {
      return -1;
    }
    return preorder(rightChildIndex);
  }

  public static void main(String[] args) {
    IsValidSerialization testObj = new IsValidSerialization();
    System.out.println(testObj.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    System.out.println(testObj.isValidSerialization("1,#"));
    System.out.println(testObj.isValidSerialization("9,#,#,1"));
  }
}
