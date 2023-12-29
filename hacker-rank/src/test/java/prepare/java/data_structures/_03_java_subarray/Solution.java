package prepare.java.data_structures._03_java_subarray;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-negative-subarray/problem?isFullScreen=true
public class Solution {
  public static void main(String[] args) {
    try (var scanner = new Scanner(System.in)) {
      var n = scanner.nextInt();
      scanner.nextLine();
      var A = new int[n];
      while (n-- > 0) A[A.length - n - 1] = scanner.nextInt();

      System.out.println(countNegativeSubArrays(A));
    }
  }

  private static int countNegativeSubArrays(int[] A) {
    int count = 0;
    for (var s = 0; s < A.length; s++) {
      var sum = 0;
      for (var i = s; i < A.length; i++) {
        sum += A[i];
        if (sum < 0) count++;
      }
    }
    return count;
  }
}
