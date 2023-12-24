package prepare.java.introduction._12_java_currency_formatter;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

import static java.util.Locale.*;

/**
 * Having issues when running with J15 - expected output00.txt isn't exactly as on HR
 * On HR needs to run on J8
 */
// https://www.hackerrank.com/challenges/java-currency-formatter/problem?isFullScreen=true
public class Solution {
  public static void main(String[] args) {
    try (var scanner = new Scanner(System.in)) {
      var amount = scanner.nextDouble();

      System.out.println("US: " + formatAsCurrency(amount, US));
      System.out.println(
        "India: "
        + formatAsCurrency(amount, new Locale("en", "India"))
          .replace("\u00A4", "Rs.")
      );
      System.out.println("China: " + formatAsCurrency(amount, CHINA));
      System.out.println("France: " + formatAsCurrency(amount, FRANCE));
    }
  }

  private static String formatAsCurrency(double amount, Locale locale) {
    return NumberFormat.getCurrencyInstance(locale).format(amount);
  }
}
