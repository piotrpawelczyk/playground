package notadefaultpackage;

import lombok.Value;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Value
public class SolutionOutput {
  String[] actualOutputLines;

  public void expectsOutput(Object... expectedOutput) {
    assertEquals(textBlock(expectedOutput), textBlock(actualOutputLines));
  }

  private String textBlock(Object[] output) {
    return stream(output)
      .map(Object::toString)
      .collect(joining(System.lineSeparator()));
  }
}
