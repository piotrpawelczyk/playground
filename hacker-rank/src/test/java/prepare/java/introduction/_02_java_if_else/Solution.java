package prepare.java.introduction._02_java_if_else;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-if-else/problem?isFullScreen=true
public class Solution {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println(whatIsTheInt(scanner.nextInt()));
    }
  }

  private static String whatIsTheInt(int N) {
    if (N % 2 == 1) {
      return "Weird";
    } else if (N >= 2 && N <= 5) {
      return "Not Weird";
    } else if (N >= 6 && N <= 20) {
      return "Weird";
    } else {
      return "Not Weird";
    }
  }
}
