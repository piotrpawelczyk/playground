package prepare.java.strings._11_java_tag_content_extractor;

import java.util.Scanner;
import java.util.regex.Pattern;

// https://www.hackerrank.com/challenges/tag-content-extractor/problem?isFullScreen=true
public class Solution {
  public static void main(String[] args) {
    try (var scanner = new Scanner(System.in)) {
      var N = scanner.nextInt();
      scanner.nextLine();
      var tagsPattern = Pattern.compile(".*?<([^/]+)>([^<>]+)</\\1>");

      while (N-- > 0) {
        var m = tagsPattern.matcher(scanner.nextLine());
        var found = false;

        while (m.find()) {
          System.out.println(m.group(2));
          found = true;
        }

        if (!found)
          System.out.println("None");
      }
    }
  }
}
