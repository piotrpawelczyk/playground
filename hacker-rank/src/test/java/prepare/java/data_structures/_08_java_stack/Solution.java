package prepare.java.data_structures._08_java_stack;

import java.util.Scanner;
import java.util.Stack;

// https://www.hackerrank.com/challenges/java-stack/problem?isFullScreen=true
public class Solution {
  public static void main(String[] args) {
    try (var scanner = new Scanner(System.in)) {
      while (scanner.hasNext()) {
        System.out.println(isBalanced(scanner.nextLine()));
      }
    }
  }

  private static boolean isBalanced(final String p) {
    var opens = "({[";
    var closes = ")}]";

    var b = new Stack<Character>();
    for (var c : p.toCharArray()) {
      if (opens.indexOf(c) > -1) {
        b.push(c);
      } else if (b.isEmpty() || !b.pop().equals(opens.charAt(closes.indexOf(c)))) {
        return false;
      }
    }

    return b.isEmpty();
  }
}
