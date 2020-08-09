package cn.theproudsoul.leetcode.august.week2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

  private final static int EMPTY = 0;
  private final static int FRESH = 1;
  private final static int ROTTEN = 2;
  // a better solution find in Discuss
  public int orangesRottingBFS(int[][] grid){
    Queue<int[]> q = new LinkedList<>();

    int freshCount = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 2)
          q.add(new int[]{i, j}); // add all rotten orange indices pair in queue
        if (grid[i][j] == 1)
          freshCount++; // count fresh oranges
      }
    }

    int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // defined 4 direction 2d-array
    int time = 0;
    while (!q.isEmpty() && freshCount > 0) {
      time++;
      int size = q.size();
      while (size-- > 0) {
        int[] xy = q.poll(); // poll rotten oranges from queue
        for (int[] d : direction) {
          int x = xy[0] + d[0];
          int y = xy[1] + d[1];
          // continue if x or y out of grid or grid don't have fresh orange
          if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0 || grid[x][y] == 2)
            continue;
          q.add(new int[]{x, y}); // add indices pair of fresh orange in queue
          grid[x][y] = 2; // mark fresh orange to rotten - kind of marking visited
          freshCount--; // decrease freshCount
        }
      }
    }

    return freshCount == 0 ? time : -1;
  }
  public int orangesRotting(int[][] grid) {
    // 主要考虑截枝
    int[] general = new int[3];

    int hLen = grid.length;
    int vLen = grid[0].length;
    int gridNum = hLen * vLen;
    for (int[] ints : grid) {
      for (int j = 0; j < vLen; j++) {
        general[ints[j]]++;
      }
    }
    if (general[FRESH]==0) return 0;
    int minutes = 0;
    while (general[EMPTY] + general[FRESH] < gridNum) {
      minutes++;
      int[][] copy = Arrays.stream(grid).map(int[]::clone).toArray(int[][]::new);
      for (int i = 0; i < hLen; i++) {
        for (int j = 0; j < vLen; j++) {
          if (copy[i][j] == ROTTEN) {
            rottenProcess(grid,general, i, j);
          }
        }
      }
      if (general[FRESH] == 0) return minutes;
    }
    return -1;
  }

  private void rottenProcess(int[][] grid,int[] general, int i, int j) {
    if (i > 0 && grid[i - 1][j] == FRESH) {
      grid[i - 1][j] = ROTTEN;
      general[FRESH]--;
      general[ROTTEN]++;
    }
    if (j > 0 && grid[i][j - 1] == FRESH) {
      grid[i][j - 1] = ROTTEN;
      general[FRESH]--;
      general[ROTTEN]++;
    }
    if (i < grid.length - 1 && grid[i + 1][j] == FRESH) {
      grid[i + 1][j] = ROTTEN;
      general[FRESH]--;
      general[ROTTEN]++;
    }
    if (j < grid[i].length - 1 && grid[i][j + 1] == FRESH) {
      grid[i][j + 1] = ROTTEN;
      general[FRESH]--;
      general[ROTTEN]++;
    }
    grid[i][j] = EMPTY;
    general[ROTTEN]--;
    general[EMPTY]++;
  }

  public static void main(String[] args) {
    int[][] test1 = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
    int[][] test2 = new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
    int[][] test3 = new int[][]{{0, 2}};
    int[][] test4 = new int[][]{{1}, {2}};
    RottingOranges obj = new RottingOranges();
    assert obj.orangesRotting(test1) == 4;
    assert obj.orangesRotting(test2) == -1;
    assert obj.orangesRotting(test3) == 0;
    assert obj.orangesRotting(test4) == 1;
  }
}
