package prepare.java.introduction._02_java_if_else;

import notadefaultpackage.SolutionTester;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

// https://www.hackerrank.com/challenges/java-if-else/problem?isFullScreen=true
class SolutionTest extends SolutionTester {
  @ParameterizedTest
  @CsvSource({
    "3, Weird",
    "24, Not Weird",
  })
  void testSolution(String in, String out) {
    givenInput(in)
      .whenRun()
      .expectsOutput(out);
  }
}
