import java.util.*;
import java.util.stream.Collectors;

class Student {
    private String name;
    private double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() { return name; }
    public double getMarks() { return marks; }

    @Override
    public String toString() {
        return name + " (" + marks + "%)";
    }
}

public class MediumLevelFilterStudents {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("John", 72),
            new Student("Alice", 88),
            new Student("Bob", 95),
            new Student("Daisy", 66),
            new Student("Charlie", 82)
        );

        System.out.println("Students scoring above 75% sorted by marks:");
        students.stream()
                .filter(s -> s.getMarks() > 75)
                .sorted(Comparator.comparingDouble(Student::getMarks).reversed())
                .map(Student::getName)
                .forEach(System.out::println);
    }
}
