package prepare.java.big_number._01_java_big_decimal;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.stream.Stream;

// https://www.hackerrank.com/challenges/java-bigdecimal/problem?isFullScreen=true
public class Solution {
  public static void main(String[] args) {
    try (var scanner = new Scanner(System.in)) {
      var N = scanner.nextInt();
      scanner.nextLine();

      Stream.generate(scanner::nextLine)
        .limit(N)
        .map(s -> new Comparable[]{s, new BigDecimal(s)})
        .sorted((l, r) -> r[1].compareTo(l[1]))
        .forEach(sd -> System.out.println(sd[0]));
    }
  }
}
