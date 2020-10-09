package cn.theproudsoul.leetcode.september.week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BullsNCows {
  public String getHint(String secret, String guess) {
    int[] numbers = new int[10];

    int bulls = 0, cows = 0;

    for (int i = 0; i < secret.length(); i++) {
      if (secret.charAt(i) == guess.charAt(i)) bulls++;
      else {
        if (numbers[secret.charAt(i) - '0']++ < 0) cows++;
        if (numbers[guess.charAt(i) - '0']-- > 0) cows++;
      }
    }
    return bulls + "A" + cows + "B";
  }

  public static void main(String[] args) {
    BullsNCows bullsNCows = new BullsNCows();
    bullsNCows.getHint("1123", "0111");
  }
}
