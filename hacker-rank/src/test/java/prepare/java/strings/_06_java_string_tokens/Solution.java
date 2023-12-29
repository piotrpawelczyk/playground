package prepare.java.strings._06_java_string_tokens;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

// https://www.hackerrank.com/challenges/java-string-tokens/problem?isFullScreen=true
public class Solution {
  public static void main(String[] args) {
    try (var scanner = new Scanner(System.in)) {
      var tokens = tokenize(scanner.nextLine());
      System.out.println(tokens.size());
      tokens.forEach(System.out::println);
    }
  }

  private static List<String> tokenize(String s) {
    var withRegExp = useRegExp(s);
    var withLoop = useLoop(s);

    if (!withRegExp.equals(withLoop)) throw new IllegalStateException();

    return withRegExp;
  }

  private static List<String> useRegExp(String s) {
    return Stream.of(s.split("[^a-zA-Z]+"))
      .filter(t -> !t.isBlank())
      .collect(toList());
  }

  private static List<String> useLoop(String s) {
    var tokens = new ArrayList<String>();

    var lastToken = "";
    for (var i = 0; i < s.length(); i++) {
      var c = s.charAt(i);
      if (c >= 65 && c <= 90 || c >= 97 && c <= 122) {
        lastToken += c;
      } else if (!lastToken.isEmpty()) {
        tokens.add(lastToken);
        lastToken = "";
      }
    }

    if (!lastToken.isEmpty()) tokens.add(lastToken);

    return tokens;
  }
}
