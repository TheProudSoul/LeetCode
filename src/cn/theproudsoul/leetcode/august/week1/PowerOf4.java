package cn.theproudsoul.leetcode.august.week1;

public class PowerOf4 {
  public boolean isPowerOfFour(int num) {
    while (num >= 4) {
      if (num % 4 != 0) return false;
      num = num / 4;
    }
    return num == 1;
  }

  public boolean isPowerOfFourWithoutLoop(int num) {
    // TODO:
    return false;
  }

  public static void main(String[] args) {
    PowerOf4 powerOf4 = new PowerOf4();
    assert !powerOf4.isPowerOfFour(5);
    assert powerOf4.isPowerOfFour(4);
    assert powerOf4.isPowerOfFour(16);
  }
}
