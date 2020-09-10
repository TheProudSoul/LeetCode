package cn.theproudsoul.leetcode.september.week2;

public class CompareVersionNums {
  public int compareVersion(String version1, String version2) {
    String[] version1detail = version1.split("\\.");
    String[] version2detail = version2.split("\\.");
    boolean swapFlag = false;
    if (version1detail.length < version2detail.length) {
      String[] tmp = version1detail;
      version1detail = version2detail;
      version2detail = tmp;
      swapFlag = true;
    }
    int i;
    for (i = 0; i < version2detail.length; i++) {
      int num1 = Integer.parseInt(version1detail[i]);
      int num2 = Integer.parseInt(version2detail[i]);
      if (num1 == num2) {
      } else {
        if (swapFlag) return -Integer.compare(num1, num2);
        return Integer.compare(num1, num2);
      };
    }
    for (; i< version1detail.length;i++) {
      if (Integer.parseInt(version1detail[i])>0) {
        if (swapFlag) return -1;
        else return 1;
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    CompareVersionNums obj = new CompareVersionNums();
    System.out.println(obj.compareVersion("1", "1.1"));
  }
}
