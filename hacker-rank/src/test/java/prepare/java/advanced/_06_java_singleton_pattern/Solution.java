// https://www.hackerrank.com/challenges/java-singleton/problem?isFullScreen=true
package prepare.java.advanced._06_java_singleton_pattern;

import java.util.Scanner;

class Singleton {
  String str;
  private static Singleton ref;

  static Singleton getSingleInstance() {
    if (ref == null) ref = new Singleton();
    return ref;
  }
}

public class Solution {
  public static void main(String args[]) {
    try (var scanner = new Scanner(System.in)) {
      Singleton.getSingleInstance().str = scanner.nextLine();
      System.out.println(
        "Hello I am a singleton! Let me say "
        + Singleton.getSingleInstance().str
        + " to you");
    }
  }
}
