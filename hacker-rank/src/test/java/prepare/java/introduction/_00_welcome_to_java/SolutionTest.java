package prepare.java.introduction._00_welcome_to_java;

import notadefaultpackage.SolutionTester;
import org.junit.jupiter.api.Test;

// https://www.hackerrank.com/challenges/welcome-to-java/problem?isFullScreen=true
class SolutionTest extends SolutionTester {
  @Test
  void testSolution() {
    givenInput()
      .whenRun()
      .expectsOutput(
        "Hello, World.",
        "Hello, Java."
      );
  }
}
