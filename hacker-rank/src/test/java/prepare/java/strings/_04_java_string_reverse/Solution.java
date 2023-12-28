package prepare.java.strings._04_java_string_reverse;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-string-reverse/problem?isFullScreen=true
public class Solution {
  public static void main(String[] args) {
    try (var scanner = new Scanner(System.in)) {
      System.out.println(isPalindrome(scanner.nextLine()) ? "Yes" : "No");
    }
  }

  private static boolean isPalindrome(String a) {
    var chars = a.toCharArray();
    for (var l = 0; l < a.length() / 2; l++) {
      var s = chars[l];
      var r = a.length() - l - 1;
      chars[l] = chars[r];
      chars[r] = s;
    }
    return a.equals(new String(chars));
  }
}
