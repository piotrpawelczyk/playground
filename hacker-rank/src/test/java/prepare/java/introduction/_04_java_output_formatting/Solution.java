package prepare.java.introduction._04_java_output_formatting;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-output-formatting/problem?isFullScreen=true
public class Solution {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("================================");

      System.out.println(formatStringAndNumber(scanner.nextLine()));
      System.out.println(formatStringAndNumber(scanner.nextLine()));
      System.out.println(formatStringAndNumber(scanner.nextLine()));

      System.out.println("================================");
    }
  }

  private static String formatStringAndNumber(String line) {
    var strInt = line.split("\\s+");
    return strInt[0] + " ".repeat(14 - strInt[0].length())
           + " "
           + "0".repeat(3 - strInt[1].length()) + strInt[1]
           + " ";
  }
}
