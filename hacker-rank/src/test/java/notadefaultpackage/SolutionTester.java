package notadefaultpackage;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;

import static java.util.concurrent.TimeUnit.SECONDS;

@DisplayNameGeneration(SolutionTester.HackerRankStyledDisplayNameGenerator.class)
public abstract class SolutionTester {
  static class HackerRankStyledDisplayNameGenerator implements DisplayNameGenerator {
    @Override
    public String generateDisplayNameForClass(final Class<?> testClass) {
      var nameParts = testClass.getCanonicalName().split("\\.");
      var name = "";
      for (var i = 0; i < nameParts.length - 1; i++) {
        if (!name.isEmpty()) name += " > ";
        name += humanize(nameParts[i]);
      }
      return name;
    }

    @Override
    public String generateDisplayNameForNestedClass(final Class<?> nestedClass) {
      return nestedClass.getName();
    }

    @Override
    public String generateDisplayNameForMethod(
      final Class<?> testClass, final Method testMethod
    ) {
      return testMethod.getName();
    }

    private static String humanize(String name) {
      var words = name.split("_+");

      var huminized = "";
      var first = true;
      for (var i = 0; i < words.length; i++) {
        if (words[i].isBlank()) continue;

        if (!first) huminized += " ";

        huminized += capitalized(words[i]);
        first = false;
      }

      return huminized;
    }

    private static String capitalized(String name) {
      var chars = name.toCharArray();
      chars[0] = ((Character) (chars[0])).toString().toUpperCase().toCharArray()[0];
      return new String(chars);
    }
  }

  protected String[] runSolution(String[] inputLines) {
    try {
      // fail-fast when class does not exist
      var solutionClass = Class.forName(getClass().getPackageName() + ".Solution");

      var jre = ProcessHandle.current().info().commandLine().get().split("\\s+")[0];

      var proc = Runtime.getRuntime().exec(new String[]{
        jre,
        "-Dfile.encoding=UTF-8", "-Dsun.stdout.encoding=UTF-8", "-Dsun.stderr.encoding=UTF-8",
        "-classpath", "./target/test-classes",
        solutionClass.getCanonicalName()
      });

      if (inputLines.length > 0) {
        var in = new OutputStreamWriter(proc.getOutputStream());
        System.out.println();
        System.out.println("Input (stdin)");
        for (var l : inputLines) {
          in.append(l);
          System.out.println(l);
        }
      }

      proc.onExit().get(5, SECONDS);

      var firstErr = true;
      var stdErr = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
      for (var l = stdErr.readLine(); l != null; l = stdErr.readLine()) {
        if (firstErr) {
          System.out.println();
          System.out.println("Error (stderr)");
          firstErr = false;
        }
        System.out.println(l);
      }

      var stdOut = new BufferedReader(new InputStreamReader(proc.getInputStream()));
      var outLines = new ArrayList<String>();
      System.out.println();
      System.out.println("Your Output (stdout)");
      for (var l = stdOut.readLine(); l != null; l = stdOut.readLine()) {
        outLines.add(l);
        System.out.println(l);
      }
      if (outLines.isEmpty()) {
        System.out.println("~ no response on stdout ~");
      }

      return outLines.toArray(String[]::new);
    } catch (Exception any) {
      throw new RuntimeException(any);
    }
  }
}
