package prepare.java.introduction._00_welcome_to_java;

import notadefaultpackage.SolutionTester;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest extends SolutionTester {
  @Test
  void testSolution() {
    assertArrayEquals(new String[]{
        "Hello, World.",
        "Hello, Java."
      },
      runSolution(new String[0]),
      "Expected Output");
  }
}
