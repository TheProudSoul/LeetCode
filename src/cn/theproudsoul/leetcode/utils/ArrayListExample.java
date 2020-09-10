package cn.theproudsoul.leetcode.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListExample {
  public static void main(String[] args) {
    ArrayList<String> listOne = new ArrayList<>(Arrays.asList("a", "f", "b", "c", "d"));

    ArrayList<String> listTwo = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));
    List<List<Integer>> manualIdsList = new ArrayList<>();
    manualIdsList.add(Arrays.asList(1,2,3,4,5));
    manualIdsList.add(Arrays.asList(1,2,3,4,5));
    manualIdsList.add(Arrays.asList(1,2,3,4,5));
    manualIdsList.add(Arrays.asList(1,2,3,4,5));
    // remove all elements of second list
    listOne.removeAll(listTwo);

    System.out.println(manualIdsList);
  }
}
