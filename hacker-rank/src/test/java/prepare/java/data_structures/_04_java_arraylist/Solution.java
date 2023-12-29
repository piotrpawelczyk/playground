package prepare.java.data_structures._04_java_arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-arraylist/problem?isFullScreen=true
public class Solution {
  public static void main(String[] args) {
    try (var scanner = new Scanner(System.in)) {
      var n = scanner.nextInt();

      List<List<Integer>> lines = new ArrayList<>();
      while (n-- > 0) {
        var l = new ArrayList<Integer>();

        scanner.nextLine();
        var d = scanner.nextInt();
        while (d-- > 0) l.add(scanner.nextInt());

        lines.add(l);
      }

      scanner.nextLine();
      var q = scanner.nextInt();
      while (q-- > 0) {
        scanner.nextLine();
        var y = scanner.nextInt();
        var x = scanner.nextInt();

        if (y <= lines.size() && x <= lines.get(y - 1).size()) {
          System.out.println(lines.get(y - 1).get(x - 1));
        } else {
          System.out.println("ERROR!");
        }
      }
    }
  }
}
