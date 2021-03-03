package cn.theproudsoul.leetcode.february.week1;

/**
 * @author : zhengyijing
 * Date    : 2021/2/2
 * Time    : 11:52 下午
 * ---------------------------------------
 * Desc    :
 */
public class MinimumOneBitOperations {
  public int minimumOneBitOperations(int n) {
    int y = n;
    while((n>>=1) > 0)
      y ^= n;
    return y;
  }

  public static void main(String[] args) {

  }
}
