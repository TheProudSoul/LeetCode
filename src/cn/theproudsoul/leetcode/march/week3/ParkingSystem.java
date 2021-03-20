package cn.theproudsoul.leetcode.march.week3;

/**
 * 1603. 设计停车系统
 * https://leetcode-cn.com/problems/design-parking-system/
 */
public class ParkingSystem {

  private int[] parkingLotLeft;

  public ParkingSystem(int big, int medium, int small) {
    parkingLotLeft = new int[4];
    parkingLotLeft[1] = big;
    parkingLotLeft[2] = medium;
    parkingLotLeft[3] = small;
  }

  public boolean addCar(int carType) {
    return parkingLotLeft[carType]-- > 0;
  }

  public static void main(String[] args) {
    ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
    parkingSystem.addCar(1); // 返回 true ，因为有 1 个空的大车位
    parkingSystem.addCar(2); // 返回 true ，因为有 1 个空的中车位
    parkingSystem.addCar(3); // 返回 false ，因为没有空的小车位
    parkingSystem.addCar(1); // 返回 false ，因为没有空的大车位，唯一一个大车位已经被占据了
  }
}
