import java.util.*;

class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + "}";
    }
}

public class EasyLevelSortEmployees {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 30, 70000));
        employees.add(new Employee("Bob", 25, 50000));
        employees.add(new Employee("Charlie", 35, 80000));

        System.out.println("\nSorted by Name:");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(System.out::println);

        System.out.println("\nSorted by Age:");
        employees.stream()
                .sorted(Comparator.comparingInt(Employee::getAge))
                .forEach(System.out::println);

        System.out.println("\nSorted by Salary:");
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .forEach(System.out::println);
    }
}
