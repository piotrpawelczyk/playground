package prepare.java.introduction._12_java_date_and_time;

import java.util.Calendar;
import java.util.Scanner;
import java.util.TimeZone;

import static java.util.Calendar.*;

// https://www.hackerrank.com/challenges/java-date-and-time/problem?isFullScreen=true
public class Solution {
  public static void main(String[] args) {
    try (var scanner = new Scanner(System.in)) {
      var m = scanner.nextInt();
      var d = scanner.nextInt();
      var y = scanner.nextInt();

      var cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
      cal.set(y, m - 1, d);
      cal.setFirstDayOfWeek(MONDAY);

      System.out.println(formatDayOfWeek(cal.get(DAY_OF_WEEK)).toUpperCase());
    }
  }

  private static String formatDayOfWeek(int i) {
    return switch (i) {
      case MONDAY -> "monday";
      case TUESDAY -> "tuesday";
      case WEDNESDAY -> "wednesday";
      case THURSDAY -> "thursday";
      case FRIDAY -> "friday";
      case SATURDAY -> "saturday";
      case SUNDAY -> "sunday";
      default -> throw new IllegalArgumentException();
    };
  }
}
