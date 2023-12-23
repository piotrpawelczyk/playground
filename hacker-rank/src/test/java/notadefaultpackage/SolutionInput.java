package notadefaultpackage;

import lombok.SneakyThrows;
import lombok.Value;
import lombok.val;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;

@Value
public class SolutionInput {
  Package solutionPackage;
  String[] inputLines;

  @SneakyThrows
  public SolutionOutput whenRun() {
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

    return new SolutionOutput(inOutErr[1]);
  }

  @SneakyThrows
  private String[][] runAsProcess(Class<?> solutionClass, String[] inputLines) {
    val jre = ProcessHandle.current().info().commandLine()
      .map(cmd -> cmd.split("\\s+"))
      .orElseThrow()[0];

    val proc = Runtime.getRuntime().exec(new String[]{
      jre,
      "-Dfile.encoding=UTF-8", "-Dsun.stdout.encoding=UTF-8", "-Dsun.stderr.encoding=UTF-8",
      "-classpath", "./target/test-classes",
      solutionClass.getCanonicalName()
    });

    val ts = Executors.newFixedThreadPool(3);
    val in = ts.submit(() -> writeLines(inputLines, proc.getOutputStream()));
    val out = ts.submit(() -> readLines(proc.getInputStream()));
    val err = ts.submit(() -> readLines(proc.getErrorStream()));

    ts.shutdown();
    if (!ts.awaitTermination(5, SECONDS)) {
      proc.destroyForcibly();
      throw new IllegalStateException("Timed out waiting for in/out streams to finish.");
    }

    val exit = proc.destroyForcibly().exitValue();
    if (exit != 0)
      throw new IllegalStateException("Solution process exited with error code: " + exit + ".");

    return new String[][]{in.get(), out.get(), err.get()};
  }

  @SneakyThrows
  private String[] writeLines(String[] inputLines, OutputStream procOutStream) {
    if (inputLines.length == 0) return new String[0];

    val inStream = new OutputStreamWriter(procOutStream);
    val in = new ArrayList<String>();
    for (val l : inputLines) {
      inStream.append(l).append(System.lineSeparator());
      inStream.flush();
      in.add(l);
    }

    return in.toArray(String[]::new);
  }

  @SneakyThrows
  private String[] readLines(InputStream outStream) {
    val out = new BufferedReader(new InputStreamReader(outStream));
    val outLines = new ArrayList<String>();
    String l;
    while ((l = out.readLine()) != null) {
      outLines.add(l);
    }
    return outLines.toArray(String[]::new);
  }
}
