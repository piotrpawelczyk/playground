package prepare.java.strings._02_java_substring;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-substring/problem?isFullScreen=true
public class Solution {
  public static void main(String[] args) {
    try (var scanner = new Scanner(System.in)) {
      System.out.println(scanner.nextLine().substring(scanner.nextInt(), scanner.nextInt()));
    }
  }
}
