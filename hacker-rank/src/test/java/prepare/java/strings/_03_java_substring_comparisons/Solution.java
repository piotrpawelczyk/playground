package prepare.java.strings._03_java_substring_comparisons;

import java.util.Scanner;
import java.util.TreeSet;

// https://www.hackerrank.com/challenges/java-string-compare/problem?isFullScreen=true
public class Solution {
  public static void main(String[] args) {
    try (var scanner = new Scanner(System.in)) {
      System.out.println(getSmallestAndLargest(scanner.nextLine(), scanner.nextInt()));
    }
  }

  private static String getSmallestAndLargest(String s, int k) {
    var substrings = new TreeSet<String>();
    for (var i = 0; i < s.length() - k + 1; i++) substrings.add(s.substring(i, i + k));
    return substrings.first() + "\n" + substrings.last();
  }
}
