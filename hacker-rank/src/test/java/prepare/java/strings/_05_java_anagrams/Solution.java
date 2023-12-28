package prepare.java.strings._05_java_anagrams;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-anagrams/problem?isFullScreen=true
public class Solution {
  public static void main(String[] args) {
    try (var scanner = new Scanner(System.in)) {
      System.out.println(
        areAnagrams(scanner.nextLine(), scanner.nextLine()) ? "Anagrams" : "Not Anagrams");
    }
  }

  private static boolean areAnagrams(String a, String b) {
    return useSorting(a, b) && useMaps(a, b);
  }

  private static boolean useSorting(String a, String b) {
    if (a.length() != b.length()) return false;

    var ac = a.toLowerCase().chars().sorted().toArray();
    var bc = b.toLowerCase().chars().sorted().toArray();

    for (int i = 0; i < ac.length; i++) if (ac[i] != bc[i]) return false;

    return true;
  }

  private static boolean useMaps(String a, String b) {
    var ac = new HashMap<Integer, Integer>();
    var bc = new HashMap<Integer, Integer>();

    for (var i = 0; i < a.length(); i++) {
      countChars(a, i, ac);
      countChars(b, i, bc);
    }

    return ac.entrySet().equals(bc.entrySet());
  }

  private static void countChars(String s, int i, Map<Integer, Integer> sc) {
    int c = s.toCharArray()[i];
    if (c < 97) c += 32;

    sc.compute(c, (k, v) -> v == null ? 0 : ++v);
  }
}
