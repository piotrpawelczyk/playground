import lombok.SneakyThrows;
import lombok.val;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static java.util.Comparator.reverseOrder;
import static java.util.concurrent.TimeUnit.SECONDS;
import static java.util.stream.Collectors.joining;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionsTest {
  @SneakyThrows
  private static Stream<Arguments> discoverSolutions() {
    val root = Path.of("./target/test-classes");
    return Files.walk(root)
      .map(root::relativize)
      .map(Path::toString)
      .filter(f -> f.endsWith("Solution.class"))
      .sorted()
      .map(f -> f.replace(".class", "").replaceAll("/", "."))
      .map(SolutionsTest::clazz)
      .map(c -> Arguments.of(testName(c), c))
      .flatMap(args -> testCases((Class<?>) args.get()[1])
        .map(tc -> Arguments.of(args.get()[0], args.get()[1], tc.get()[0]))
      );
  }

  @ParameterizedTest(name = "{0} - Test case {2}")
  @MethodSource("discoverSolutions")
  void testSolutions(
    String solutionName, Class<?> solutionClass, String testCase
  ) {
    val input = solutionClass.getResourceAsStream("input" + testCase + ".txt");
    val expectedOutput = solutionClass.getResourceAsStream("output" + testCase + ".txt");

    val actualOutput = whenRun(
      solutionClass.getPackage(),
      new BufferedReader(new InputStreamReader(input)).lines().toArray(String[]::new)
    );

    val expectedOutputText = asText(
      new BufferedReader(new InputStreamReader(expectedOutput)).lines().toArray(String[]::new));

    System.out.println();
    System.out.println("Expected Output");
    System.out.println(expectedOutputText);

    assertEquals(expectedOutputText, asText(actualOutput));
  }

  @SneakyThrows
  private static Stream<Arguments> testCases(Class<?> solutionClass) {
    val testFiles = new HashSet<Arguments>();
    for (var i = 0; i <= 99; i++) {
      val iStr = (i < 10 ? "0" : "") + i;
      try (val input = solutionClass.getResourceAsStream("input" + iStr + ".txt")) {
        if (input != null) testFiles.add(Arguments.of(iStr));
      }
    }
    if (testFiles.isEmpty()) testFiles.add(Arguments.of("--not found--"));
    return testFiles.stream();
  }

  @SneakyThrows
  private static Class<?> clazz(String name) {
    return Class.forName(name);
  }

  private static String asText(String[] output) {
    return stream(output).collect(joining(System.lineSeparator()));
  }

  private static String testName(Class<?> testClass) {
    val nameParts = testClass.getCanonicalName().split("\\.");
    StringBuilder name = new StringBuilder();
    for (var i = 0; i < nameParts.length - 1; i++) {
      if (!name.isEmpty()) name.append(" > ");

      name.append(humanize(nameParts[i]));
    }
    return name.toString();
  }

  private static String humanize(String name) {
    val words = name.split("_+");

    StringBuilder humanized = new StringBuilder();
    var first = true;
    for (String word : words) {
      if (word.isBlank()) continue;

      if (!first) humanized.append(" ");

      humanized.append(capitalized(word));
      first = false;
    }

    return humanized.toString();
  }

  private static String capitalized(String name) {
    val chars = name.toCharArray();
    chars[0] = ((Character) (chars[0])).toString().toUpperCase().toCharArray()[0];
    return new String(chars);
  }

  @SneakyThrows
  public String[] whenRun(Package solutionPackage, String[] inputLines) {
    val solutionClass = Class.forName(solutionPackage.getName() + ".Solution");
    val inOutErr = runAsProcess(solutionClass, inputLines);

    if (inOutErr[0].length > 0) {
      System.out.println();
      System.out.println("Input (stdin)");
      for (val l : inOutErr[0]) {
        System.out.println(l);
      }
    }

    var firstErr = true;
    for (val l : inOutErr[2]) {
      if (firstErr) {
        System.out.println();
        System.out.println("Error (stderr)");
        firstErr = false;
      }
      System.out.println(l);
    }

    System.out.println();
    System.out.println("Your Output (stdout)");
    for (val l : inOutErr[1]) {
      System.out.println(l);
    }
    if (inOutErr[1].length == 0) {
      System.out.println("~ no response on stdout ~");
    }

    return inOutErr[1];
  }

  @SneakyThrows
  private String[][] runAsProcess(Class<?> solutionClass, String[] inputLines) {
    val ts = Executors.newFixedThreadPool(4);

    val proc = ts.submit(() -> startProcess(solutionClass)).get();

    ts.submit(new Runnable() {
      @SneakyThrows
      @Override
      public void run() {
        try {
          proc.waitFor();
        } catch (InterruptedException e) {
          proc.destroyForcibly().waitFor();
        }
      }
    });
    val in = ts.submit(() -> writeLines(inputLines, proc.getOutputStream()));
    val out = ts.submit(() -> readLines(proc.getInputStream()));
    val err = ts.submit(() -> readLines(proc.getErrorStream()));

    ts.shutdown();
    if (!ts.awaitTermination(5, SECONDS)) {
      throw new IllegalStateException();
    }

    return new String[][]{in.get(), out.get(), err.get()};
  }

  @SneakyThrows
  private static Process startProcess(Class<?> solutionClass) {
    val jre = ProcessHandle.current().info().commandLine()
      .map(cmd -> cmd.split("\\s+"))
      .orElseThrow()[0];

    return Runtime.getRuntime().exec(new String[]{
      jre,
      "-Dfile.encoding=UTF-8", "-Dsun.stdout.encoding=UTF-8", "-Dsun.stderr.encoding=UTF-8",
      "-classpath", "./target/test-classes",
      solutionClass.getCanonicalName()
    });
  }

  @SneakyThrows
  private static String[] writeLines(String[] inputLines, OutputStream procOutStream) {
    if (inputLines.length == 0) return new String[0];

    val inStream = new OutputStreamWriter(procOutStream);
    val in = new ArrayList<String>();
    for (val l : inputLines) {
      inStream.append(l).append(System.lineSeparator());
      inStream.flush();
      in.add(l);
    }

    inStream.close();

    return in.toArray(String[]::new);
  }

  @SneakyThrows
  private static String[] readLines(InputStream outStream) {
    val out = new BufferedReader(new InputStreamReader(outStream));
    val outLines = new ArrayList<String>();
    String l;
    while ((l = out.readLine()) != null) {
      outLines.add(l);
    }
    return outLines.toArray(String[]::new);
  }
}
