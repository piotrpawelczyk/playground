package prepare.java.introduction._05_java_loops_I;

import notadefaultpackage.SolutionTester;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

// https://www.hackerrank.com/challenges/java-loops-i/problem?isFullScreen=true
class SolutionTest extends SolutionTester {
  @ParameterizedTest
  @CsvSource({
    "2, '2 x 1 = 2;2 x 2 = 4;2 x 3 = 6;2 x 4 = 8;2 x 5 = 10;2 x 6 = 12;2 x 7 = 14;2 x 8 = 16;2 x 9 = 18;2 x 10 = 20'",
  })
  void testSolution(String in, String out) {
    givenInput(in.split(";"))
      .whenRun()
      .expectsOutput(out.split(";"));
  }
}
