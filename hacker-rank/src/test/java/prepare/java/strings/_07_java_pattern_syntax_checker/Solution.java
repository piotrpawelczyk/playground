package prepare.java.strings._07_java_pattern_syntax_checker;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

// https://www.hackerrank.com/challenges/pattern-syntax-checker/problem?isFullScreen=true
public class Solution {
  public static void main(String[] args) {
    try (var scanner = new Scanner(System.in)) {
      var N = scanner.nextInt();
      scanner.nextLine();

      while (N-- > 0) {
        try {
          Pattern.compile(scanner.nextLine());
          System.out.println("Valid");
        } catch (PatternSyntaxException any) {
          System.out.println("Invalid");
        }
      }
    }
  }
}
