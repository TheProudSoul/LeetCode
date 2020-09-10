package cn.theproudsoul.leetcode.september.week1;

import cn.theproudsoul.leetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;


public class AllElementsIn2BST {
  public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

    LinkedList<Integer> list1 = new LinkedList<>();
    LinkedList<Integer> list2 = new LinkedList<>();

    // inorder travel the first tree
    inorderTravel(root1, list1);
    // merge the second tree
    inorderTravel(root2, list2);

    // merge list2 into list1
    int pointer1 = 0, pointer2 = 0;
    while (pointer2 < list2.size()) {
      if (pointer1 >= list1.size()) break;
      if (list1.get(pointer1) < list2.get(pointer2)) {
        pointer1++;
      } else {
        list1.add(pointer1, list2.get(pointer2));
        pointer1++;
        pointer2++;
      }
    }
    if (pointer2 < list2.size()) list1.addAll(list2.subList(pointer2, list2.size()));

    return list1;
  }

  private void inorderTravel(TreeNode root, List<Integer> list) {
    if (root == null) return;
    inorderTravel(root.left, list);
    list.add(root.val);
    inorderTravel(root.right, list);
  }

  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(2, new TreeNode(1), new TreeNode(4));
    TreeNode root2 = new TreeNode(1, new TreeNode(0), new TreeNode(3));
    AllElementsIn2BST obj = new AllElementsIn2BST();
    obj.getAllElements(root1, root2);
  }
}
