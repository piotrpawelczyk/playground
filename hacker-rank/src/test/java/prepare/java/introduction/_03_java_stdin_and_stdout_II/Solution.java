package prepare.java.introduction._03_java_stdin_and_stdout_II;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-stdin-stdout/problem?isFullScreen=true
public class Solution {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      var theInt = Integer.parseInt(scanner.nextLine());
      var theDouble = Double.parseDouble(scanner.nextLine());
      var theString = scanner.nextLine();

      System.out.println("String: " + theString);
      System.out.println("Double: " + theDouble);
      System.out.println("Int: " + theInt);
    }
  }
}
