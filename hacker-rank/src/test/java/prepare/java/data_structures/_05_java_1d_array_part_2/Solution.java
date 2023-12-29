package prepare.java.data_structures._05_java_1d_array_part_2;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-1d-array/problem?isFullScreen=true
public class Solution {
  public static void main(String[] args) {
    try (var scanner = new Scanner(System.in)) {
      var q = scanner.nextInt();

      while (q-- > 0) {
        scanner.nextLine();
        var n = scanner.nextInt();
        var leap = scanner.nextInt();

        scanner.nextLine();
        var game = new int[n];
        while (n-- > 0) game[game.length - n - 1] = scanner.nextInt();

        System.out.println(canWin(game, leap, 0, -1) ? "YES" : "NO");
      }
    }
  }

  private static boolean canWin(int[] game, int leap, int pos, int fuse) {
    if (pos >= game.length) return true;
    if (pos == fuse || pos < 0 || game[pos] != 0) return false;
    if (pos == game.length - 1) return true;

    return canWin(game, leap, pos + leap, pos) // take a leap
           || canWin(game, leap, pos + 1, pos) // step forth
           || canWin(game, leap, pos - 1, fuse) // step back
      ;
  }
}
