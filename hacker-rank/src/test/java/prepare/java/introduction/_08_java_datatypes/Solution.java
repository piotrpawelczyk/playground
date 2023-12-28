package prepare.java.introduction._08_java_datatypes;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

// https://www.hackerrank.com/challenges/java-datatypes/problem?isFullScreen=true
public class Solution {
  public static void main(String[] args) {
    try (var scanner = new Scanner(System.in)) {
      var T = scanner.nextInt();
      if (T < 1) return;

      scanner.nextLine();

      while ((T--) > 0) {
        var n = scanner.nextLine();
        var fits = fitsIn(n);

        if (fits.length == 0) {
          System.out.println(n + " can't be fitted anywhere.");
        } else {
          System.out.println(n + " can be fitted in:");
          for (var f : fits) {
            System.out.println("* " + f);
          }
        }
      }
    }
  }

  private static String[] fitsIn(String someInt) {
    var fits = new ArrayList<String>();
    var n = new BigInteger(someInt);

    fitsInIf(n::byteValueExact, "byte", fits);
    fitsInIf(n::shortValueExact, "short", fits);
    fitsInIf(n::intValueExact, "int", fits);
    fitsInIf(n::longValueExact, "long", fits);

    return fits.toArray(String[]::new);
  }

  private static void fitsInIf(Supplier<?> test, String type, List<String> fits) {
    try {
      test.get();
      fits.add(type);
    } catch (Exception any) {
      // no-op
    }
  }
}
