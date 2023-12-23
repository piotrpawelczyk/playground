package prepare.java.introduction._03_java_stdin_and_stdout_II;

import notadefaultpackage.SolutionTester;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

// https://www.hackerrank.com/challenges/java-stdin-stdout/problem?isFullScreen=true
class SolutionTest extends SolutionTester {
  @ParameterizedTest
  @CsvSource({
    "'42;3.1415;Welcome to HackerRank''s Java tutorials!', 'String: Welcome to HackerRank''s Java tutorials!;Double: 3.1415;Int: 42'",
    "'100;42;42 is the answer to life, the universe, and everything!', 'String: 42 is the answer to life, the universe, and everything!;Double: 42.0;Int: 100'",
  })
  void testSolution(String in, String out) {
    givenInput(in.split(";"))
      .whenRun()
      .expectsOutput(out.split(";"));
  }
}
