package cn.theproudsoul.leetcode.march.week4;

public class ReverseBits {
  // you need treat n as an unsigned value
  public int reverseBits(int n) {
    n = ((n & 0x55555555) << 1) | ((n & 0xAAAAAAAA) >>> 1);
    n = ((n & 0x33333333) << 2) | ((n & 0xCCCCCCCC) >>> 2);
    n = ((n & 0x0F0F0F0F) << 4) | ((n & 0xF0F0F0F0) >>> 4);
    n = ((n & 0x00FF00FF) << 8) | ((n & 0xFF00FF00) >>> 8);
    n = ((n & 0x0000FFFF) << 16) | ((n & 0xFFFF0000) >>> 16);
    return n;
  }
}
