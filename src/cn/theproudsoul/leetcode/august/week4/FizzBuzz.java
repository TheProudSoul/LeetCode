package cn.theproudsoul.leetcode.august.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FizzBuzz {
  public List<String> fizzBuzz(int n) {
    List<String> result = new ArrayList<>(n);

    for (int i = 1; i <= n; i++) {
      if (i % 15 == 0) result.add("FizzBuzz");
      else if (i % 3 == 0) result.add("Fizz");
      else if (i % 5 == 0) result.add("Buzz");
      else result.add(String.valueOf(i));
    }

    return result;
  }

  public static void main(String[] args) {
    FizzBuzz obj = new FizzBuzz();
    assert obj.fizzBuzz(15).equals(Arrays.asList(
        "1",
        "2",
        "Fizz",
        "4",
        "Buzz",
        "Fizz",
        "7",
        "8",
        "Fizz",
        "Buzz",
        "11",
        "Fizz",
        "13",
        "14",
        "FizzBuzz"
    ));
  }
}
