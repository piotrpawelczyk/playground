// https://www.hackerrank.com/challenges/can-you-access/problem?isFullScreen=true
package prepare.java.advanced._03_java_can_you_access;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine().trim());
    Object o;// Must be used to hold the reference of the instance of the class Solution.Inner.Private

    //Write your code here

    var inner = new Inner();
    var cls = Inner.class.getDeclaredClasses()[0];
    var cont = cls.getDeclaredConstructor(Inner.class);
    cont.setAccessible(true);
    o = cont.newInstance(inner);

    var powMethod = cls.getDeclaredMethod("powerof2", int.class);
    powMethod.setAccessible(true);

    System.out.println(num + " is " + powMethod.invoke(o, num));

    System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");
  }//end of main

  static class Inner {
    private class Private {
      private String powerof2(int num) {
        return ((num & num - 1) == 0) ? "power of 2" : "not a power of 2";
      }
    }
  }//end of Inner

}//end of Solution
