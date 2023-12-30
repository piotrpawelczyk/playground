package prepare.java.data_structures._10_java_generics;

import java.lang.reflect.Method;
import java.util.stream.Stream;

// https://www.hackerrank.com/challenges/java-generics/problem?isFullScreen=true
class Printer {
  //Write your code here
  <T> void printArray(T... arr) {
    Stream.of(arr).forEach(System.out::println);
  }
}

public class Solution {


  public static void main(String args[]) {
    Printer myPrinter = new Printer();
    Integer[] intArray = {1, 2, 3};
    String[] stringArray = {"Hello", "World"};
    myPrinter.printArray(intArray);
    myPrinter.printArray(stringArray);
    int count = 0;

    for (Method method : Printer.class.getDeclaredMethods()) {
      String name = method.getName();

      if (name.equals("printArray"))
        count++;
    }

    if (count > 1) System.out.println("Method overloading is not allowed!");

  }
}
