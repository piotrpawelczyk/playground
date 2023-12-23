package prepare.java.introduction._01_java_stdin_and_stdout_I;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-stdin-and-stdout-1/problem?isFullScreen=true
public class Solution {
  public static void main(String[] args) {
    try(Scanner scanner = new Scanner(System.in)) {
      System.out.println(scanner.nextInt());
      System.out.println(scanner.nextInt());
      System.out.println(scanner.nextInt());
    }
  }
}
