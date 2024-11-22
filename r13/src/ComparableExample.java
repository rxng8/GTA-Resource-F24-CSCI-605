import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Define a class that implements Comparable
class Student implements Comparable<Student> {
    private int id;
    private String name;
    private double grade;

    // Constructor
    public Student(int id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    // Implement the compareTo method
    @Override
    public int compareTo(Student other) {
        // Compare by grade in descending order
        return Double.compare(other.grade, this.grade);
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', grade=" + grade + "}";
    }
}

class Student2 {
    private String name;
    private int grade;

    public Student2(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', grade=" + grade + "}";
    }
}

class NameComparator implements Comparator<Student2> {
    @Override
    public int compare(Student2 s1, Student2 s2) {
        return s1.getName().compareTo(s2.getName()); // Sort by name
    }
}

class GradeComparator implements Comparator<Student2> {
    @Override
    public int compare(Student2 s1, Student2 s2) {
        return Integer.compare(s2.getGrade(), s1.getGrade()); // Sort by grade
    }
}


// Main class to demonstrate the example
public class ComparableExample {
    public static void main(String[] args) {
        // Create a list of students
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "Alice", 85.5));
        students.add(new Student(2, "Bob", 90.0));
        students.add(new Student(3, "Charlie", 78.0));

        // Print the list before sorting
        System.out.println("Before sorting:");
        for (Student student : students) {
            System.out.println(student);
        }

        // Sort the list (uses compareTo method)
        Collections.sort(students);

        // Print the list after sorting
        System.out.println("\nAfter sorting (by grade in descending order):");
        for (Student student : students) {
            System.out.println(student);
        }


        /////////// Another example:
        // Using Comparable (Natural Order by grade)
        List<Student2> students2 = new ArrayList<>();
        students2.add(new Student2("Alice", 85));
        students2.add(new Student2("Bob", 90));
        students2.add(new Student2("Charlie", 78));

        // Using Comparator (Custom Order by name)
        students2.sort(Comparator.comparing(Student2::getName));
        System.out.println("Sorted by name: " + students2);

        // Sorting by name using NameComparator
        System.out.println("Sorted by name:");
        students2.sort(new NameComparator());
        students2.forEach(System.out::println);

        // Sorting by grade using GradeComparator
        System.out.println("\nSorted by grade (descending):");
        students2.sort(new GradeComparator());
        students2.forEach(System.out::println);
    }
}
