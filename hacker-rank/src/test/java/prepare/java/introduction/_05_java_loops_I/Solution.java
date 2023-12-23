package prepare.java.introduction._05_java_loops_I;

import java.util.Scanner;

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
