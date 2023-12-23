package notadefaultpackage;

import lombok.val;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;

import java.lang.reflect.Method;

import static java.util.Arrays.stream;

@DisplayNameGeneration(SolutionTester.HackerRankStyledDisplayNameGenerator.class)
public abstract class SolutionTester {
  protected SolutionInput givenInput(Object... givenInput) {
    return new SolutionInput(
      getClass().getPackage(),
      stream(givenInput).map(Object::toString).toArray(String[]::new)
    );
  }

  static class HackerRankStyledDisplayNameGenerator implements DisplayNameGenerator {
    @Override
    public String generateDisplayNameForClass(final Class<?> testClass) {
      val nameParts = testClass.getCanonicalName().split("\\.");
      StringBuilder name = new StringBuilder();
      for (var i = 0; i < nameParts.length - 1; i++) {
        if (!name.isEmpty()) name.append(" > ");

        name.append(humanize(nameParts[i]));
      }
      return name.toString();
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
  }
}
