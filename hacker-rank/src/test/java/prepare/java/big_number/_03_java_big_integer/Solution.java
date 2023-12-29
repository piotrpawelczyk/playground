package prepare.java.big_number._03_java_big_integer;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-biginteger/problem?isFullScreen=true
public class Solution {
  public static void main(String[] args) {
    try (var scanner = new Scanner(System.in)) {
      var a = scanner.nextBigInteger();
      scanner.nextLine();
      var b = scanner.nextBigInteger();

      System.out.println(a.add(b));
      System.out.println(a.multiply(b));
    }
  }
}
