package prepare.java.introduction._08_java_end_of_file;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-end-of-file/problem?isFullScreen=true
public class Solution {
  public static void main(String[] args) {
    try (var scanner = new Scanner(System.in)) {
      var line = 0;
      while (true) {
        try {
          System.out.println(++line + " " + scanner.nextLine());
        } catch (Exception any) {
          return;
        }
      }
    }
  }
}
