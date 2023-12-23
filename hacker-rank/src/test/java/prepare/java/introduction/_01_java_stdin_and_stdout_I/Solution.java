package prepare.java.introduction._01_java_stdin_and_stdout_I;

import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    try(Scanner scanner = new Scanner(System.in)) {
      System.out.println(scanner.nextInt());
      System.out.println(scanner.nextInt());
      System.out.println(scanner.nextInt());
    }
  }
}
