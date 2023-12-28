package prepare.java.strings._08_java_regex;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-regex/problem?isFullScreen=true
public class Solution {
  public static void main(String[] args) {
    try (var scanner = new Scanner(System.in)) {
      var ipSegmentPattern = "(0?[0-9]{1,2}|(1[0-9]{2})|(2[0-4][0-9])|(25[0-5]))";
      var ipPattern =
        ipSegmentPattern
        + "(\\." + ipSegmentPattern + "){3}";

      while (scanner.hasNext()) {
        System.out.println(scanner.nextLine().matches(ipPattern));
      }
    }
  }
}
