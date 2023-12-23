package prepare.java.introduction._04_java_output_formatting;

import notadefaultpackage.SolutionTester;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

// https://www.hackerrank.com/challenges/java-output-formatting/problem?isFullScreen=true
class SolutionTest extends SolutionTester {
  @ParameterizedTest
  @CsvSource({
    "'java 100;cpp 65;python 50', '================================;java           100 ;cpp            065 ;python         050 ;================================'",
    "'hello 0;hackerrank 65;java 10', '================================;hello          000 ;hackerrank     065 ;java           010 ;================================'",
  })
  void testSolution(String in, String out) {
    givenInput(in.split(";"))
      .whenRun()
      .expectsOutput(out.split(";"));
  }
}
