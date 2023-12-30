// https://www.hackerrank.com/challenges/java-priority-queue/problem?isFullScreen=true
package prepare.java.data_structures._15_java_priority_queue;

import java.util.*;
import java.util.stream.Collectors;

/*
 * Create the Student and Priorities classes here.
 */
class Student {
  private final int id;
  private final String name;
  private final double cgpa;

  Student(int id, String name, double cgpa) {
    this.id = id;
    this.name = name;
    this.cgpa = cgpa;
  }

  int getID() {
    return id;
  }

  String getName() {
    return name;
  }

  double getCGPA() {
    return cgpa;
  }
}

class Priorities {
  List<Student> getStudents(List<String> events) {
    var comparingDesc = Comparator.comparing(Student::getCGPA, Comparator.reverseOrder())
      .thenComparing(Student::getName)
      .thenComparing(Student::getID);

    var pq = new PriorityQueue<>(comparingDesc);

    events.stream()
      .map(Priorities::parseEvent)
      .forEach(e -> {
        switch ((String) e[0]) {
          case "ENTER":
            pq.add((Student) e[1]);
            break;
          case "SERVED":
            pq.poll();
            break;
        }
      });

    return pq.stream().sorted(comparingDesc).collect(Collectors.toList());
  }

  private static Object[] parseEvent(String event) {
    var se = event.split("\\s+");
    return new Object[]{se[0],
      se.length == 1
        ? null
        : new Student(
        Integer.parseInt(se[3]), se[1], Double.parseDouble(se[2])
      )};
  }
}

public class Solution {
  private final static Priorities priorities = new Priorities();

  public static void main(String[] args) {
    try (Scanner scan = new Scanner(System.in)) {
      int totalEvents = Integer.parseInt(scan.nextLine());
      List<String> events = new ArrayList<>();

      while (totalEvents-- != 0) {
        String event = scan.nextLine();
        events.add(event);
      }

      List<Student> students = priorities.getStudents(events);

      if (students.isEmpty()) {
        System.out.println("EMPTY");
      } else {
        for (Student st : students) {
          System.out.println(st.getName());
        }
      }
    }
  }
}
