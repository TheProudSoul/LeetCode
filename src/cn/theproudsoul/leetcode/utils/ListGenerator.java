package cn.theproudsoul.leetcode.utils;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ListGenerator {

  public static <E> List<E> asList( @NotNull E... elements){
    List<E> result = new ArrayList<>();
    for (int i = 0; i < elements.length; i++) {
      result.add(elements[i]);
    }
    return result;
  }

  // TODO: scenario 1 [1,2,3,4,5,6,7]; scenario 2 [[4],[2],[1,5,6],[3],[7]]
  public static <E> List<E> asList( @NotNull String elements){
    List<E> result = new ArrayList<>();

    return result;
  }

}
