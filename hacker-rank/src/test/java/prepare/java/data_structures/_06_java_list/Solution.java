package prepare.java.data_structures._06_java_list;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

// https://www.hackerrank.com/challenges/java-list/problem?isFullScreen=true
public class Solution {
  public static void main(String[] args) {
    try (var scanner = new Scanner(System.in)) {
      var N = scanner.nextInt();
      var L = new ArrayList<Integer>();
      scanner.nextLine();
      while (N-- > 0) L.add(scanner.nextInt());

      scanner.nextLine();
      var Q = scanner.nextInt();
      while (Q-- > 0) {
        scanner.nextLine();
        var cmd = scanner.nextLine();
        var x = scanner.nextInt();

        if ("Insert".equals(cmd)) {
          L.add(x, scanner.nextInt());
        } else if ("Delete".equals(cmd)) {
          L.remove(x);
        }
      }

      System.out.println(L.stream()
        .map(Object::toString)
        .collect(Collectors.joining(" ")));
    }
  }
}
