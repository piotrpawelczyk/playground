package prepare.java.big_number._02_java_primality_test;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-primality-test/problem?isFullScreen=true
public class Solution {
  public static void main(String[] args) {
    try (var scanner = new Scanner(System.in)) {
      System.out.println(
        scanner.nextBigInteger()
          .isProbablePrime(2 ^ 7) ? "prime" : "not prime");
    }
  }
}
