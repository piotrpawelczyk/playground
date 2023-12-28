package prepare.java.strings._01_java_strings_introduction;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-strings-introduction/problem?isFullScreen=true
public class Solution {
  public static void main(String[] args) {
    try (var scanner = new Scanner(System.in)) {
      var A = scanner.nextLine();
      var B = scanner.nextLine();

      System.out.println(A.length() + B.length());
      System.out.println(A.compareTo(B) > 0 ? "Yes" : "No");
      System.out.println(capitalize(A) + " " + capitalize(B));
    }
  }

  private static String capitalize(String word) {
    return word.substring(0, 1).toUpperCase() + word.substring(1);
  }
}
