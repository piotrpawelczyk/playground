package prepare.java.data_structures._09_java_hashset;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.HashSet;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-hashset/problem?isFullScreen=true
public class Solution {
  public static void main(String[] args) {
    try (var scanner = new Scanner(System.in)) {
      var T = scanner.nextInt();
      var pairs = new HashSet<SimpleImmutableEntry<String, String>>();
      while (T-- > 0) {
        pairs.add(new SimpleImmutableEntry<>(scanner.next(), scanner.next()));
        System.out.println(pairs.size());
      }
    }
  }
}
