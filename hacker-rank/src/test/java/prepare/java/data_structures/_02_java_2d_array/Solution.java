package prepare.java.data_structures._02_java_2d_array;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-2d-array/problem?isFullScreen=true
public class Solution {
  public static void main(String[] args) {
    try (var scanner = new Scanner(System.in)) {
      var field = new int[6][6];
      for (var y = 0; y < 6; y++) {
        field[y] = new int[6];
        for (var x = 0; x < 6; x++) {
          field[y][x] = scanner.nextInt();
        }
        scanner.nextLine();
      }

      System.out.println(maxHourglass(field));
    }
  }

  private static int maxHourglass(int[][] field) {
    var max = -9;
    for (var y = 0; y < 4; y++) {
      for (var x = 0; x < 4; x++) {
        var v = calcHourglass(y, x, field);
        max = v > max ? v : max;
      }
    }
    return max;
  }

  private static int calcHourglass(final int y, final int x, int[][] field) {
    var v = 0;
    for (var ys = 0; ys < 3; ys++) {
      for (var xs = 0; xs < 3; xs++) {
        if (ys % 2 == 1 && xs % 2 == 0) continue;

        v += field[y + ys][x + xs];
      }
    }
    return v;
  }
}
