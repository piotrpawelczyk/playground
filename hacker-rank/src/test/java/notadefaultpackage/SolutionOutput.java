package notadefaultpackage;

import lombok.Value;
import lombok.val;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Value
public class SolutionOutput {
  String[] actualOutputLines;

  public void expectsOutput(String... expectedOutput) {
    val expectedOutputText = asText(expectedOutput);

    System.out.println();
    System.out.println("Expected Output");
    System.out.println(expectedOutputText);

    assertEquals(expectedOutputText, asText(actualOutputLines));
  }

  private String asText(String[] output) {
    return stream(output).collect(joining(System.lineSeparator()));
  }
}
