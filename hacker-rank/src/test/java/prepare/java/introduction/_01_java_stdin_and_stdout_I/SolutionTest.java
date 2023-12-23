package prepare.java.introduction._01_java_stdin_and_stdout_I;

import notadefaultpackage.SolutionTester;
import org.junit.jupiter.api.Test;

// https://www.hackerrank.com/challenges/java-stdin-and-stdout-1/problem?isFullScreen=true
class SolutionTest extends SolutionTester {
  @Test
  void testSolution() {
    givenInput("42", "100", "125")
      .whenRun()
      .expectsOutput("42", "100", "125");
  }
}
