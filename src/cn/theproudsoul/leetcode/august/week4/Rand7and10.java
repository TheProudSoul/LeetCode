package cn.theproudsoul.leetcode.august.week4;

public class Rand7and10 {
  // return 1 - 7
  public int rand7() {
    return (int) Math.floor(Math.random() * 7 + 1);
  }

  public int rand10() {
    int row, col, idx;
    do {
      row = rand7();
      col = rand7();
      idx = col + (row - 1) * 7;
    } while (idx > 40);
    return 1 + (idx - 1) % 10;
  }
}
