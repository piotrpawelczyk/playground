package prepare.java.introduction._06_java_loops_I;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-loops-i/problem?isFullScreen=true
public class Solution {
  public static void main(String[] args) {
    try (var scanner = new Scanner(System.in)) {
      var n = scanner.nextInt();
      for (var i = 1; i <= 10; i++) {
        System.out.println(n + " x " + i + " = " + n * i);
      }
    }
  }
}
