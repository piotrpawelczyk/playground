package prepare.java.strings._09_java_regex_2_duplicate_words;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * HR is really annoying here: the comments must be replaced and no other code changed + use Java 8
 */
// https://www.hackerrank.com/challenges/duplicate-word/problem?isFullScreen=true
public class Solution {
  public static void main(String[] args) {
    String regex =
      /* Write a RegEx matching repeated words here. */
      "(\\b\\w+\\b)(\\s+\\1\\b)+";
    Pattern p = Pattern.compile(regex,
      /* Insert the correct Pattern flag here.*/
      Pattern.CASE_INSENSITIVE
    );

    Scanner in = new Scanner(System.in);
    int numSentences = Integer.parseInt(in.nextLine());

    while (numSentences-- > 0) {
      String input = in.nextLine();

      Matcher m = p.matcher(input);

      // Check for subsequences of input that match the compiled pattern
      while (m.find()) {
        input = input.replaceAll(
          /* The regex to replace */
          m.group(),
          /* The replacement. */
          m.group(1)
        );
      }

      // Prints the modified sentence.
      System.out.println(input);
    }

    in.close();
  }
}
