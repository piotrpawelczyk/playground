package prepare.java.data_structures._07_java_map;

import java.util.HashMap;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/phone-book/problem?isFullScreen=true
public class Solution {
  public static void main(String[] args) {
    try (var scanner = new Scanner(System.in)) {
      var n = scanner.nextInt();
      scanner.nextLine();

      var phoneBook = new HashMap<String, Integer>();
      while (n-- > 0) {
        phoneBook.put(scanner.nextLine(), scanner.nextInt());
        scanner.nextLine();
      }

      while (scanner.hasNext()) {
        var lookup = scanner.nextLine();
        System.out.println(
          phoneBook.containsKey(lookup)
            ? lookup + "=" + phoneBook.get(lookup)
            : "Not found");
      }
    }
  }
}
