package prepare.java.introduction._10_java_static_initializer_block;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-static-initializer-block/problem?isFullScreen=true
public class Solution {
  /**
   * Supposed to test static initialization ;)
   */
  static {
    anError = "java.lang.Exception: Breadth and height must be positive";
  }

  private static String anError;
  
  public static void main(String[] args) {
    try (var scanner = new Scanner(System.in)) {
      var b = scanner.nextInt();
      scanner.nextLine();
      var h = scanner.nextInt();

      if (b <= 0 || h <= 0) {
        System.out.println(anError);
        return;
      }

      var area = b * h;
      System.out.println(area);
    }
  }
}
