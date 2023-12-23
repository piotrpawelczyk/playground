package prepare.java.introduction._06_java_loops_II;

import lombok.val;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-loops/problem?isFullScreen=true
public class Solution {
  public static void main(String[] args) {
    try (var scanner = new Scanner(System.in)) {
      var Q = scanner.nextInt();

      if (Q < 1) return;

      scanner.nextLine();

      for (var q = 1; q <= Q; q++) {
        var a = scanner.nextInt();
        var b = scanner.nextInt();
        var N = scanner.nextInt();

        var v = a;
        for (var n = 0; n < N; n++) {
          v += Math.pow(2, n) * b;

          if (n > 0) System.out.print(' ');
          System.out.print(v);
        }

        System.out.println();
      }
    }
  }
}
