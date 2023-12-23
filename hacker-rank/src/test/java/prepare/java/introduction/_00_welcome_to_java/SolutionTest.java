package prepare.java.introduction._00_welcome_to_java;

import org.junit.jupiter.api.Test;

// https://www.hackerrank.com/challenges/welcome-to-java/problem?isFullScreen=true
class SolutionTest extends notadefaultpackage.SolutionTest {
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
