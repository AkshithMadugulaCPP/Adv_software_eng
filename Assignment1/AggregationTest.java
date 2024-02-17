package Assignment1;
class Instructor {
    private String firstName;
    private String lastName;
    private String officeNumber;

    public Instructor(String firstName, String lastName, String officeNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.officeNumber = officeNumber;
    }

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }
}

class Textbook {
    private String title;
    private String author;
    private String publisher;

    public Textbook(String title, String author, String publisher) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}

class Course {
    private String courseName;
    private Instructor instructor;
    private Textbook textbook;

    public Course(String courseName, Instructor instructor, Textbook textbook) {
        this.courseName = courseName;
        this.instructor = instructor;
        this.textbook = textbook;
    }

    // Print function
    public void print() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Instructor: " + instructor.getFirstName() + " " + instructor.getLastName());
        System.out.println("Textbook: " + textbook.getTitle() + " by " + textbook.getAuthor());
    }
}

public class AggregationTest {
    public static void main(String[] args) {
        // Single instructor and textbook
        Instructor instructor1 = new Instructor("Nima", "Davarpanah", "3-2636");
        Textbook textbook1 = new Textbook("Clean Code", "Robert C. Martin", "Prentice Hall");
        Course course1 = new Course("Advanced Software Engineering", instructor1, textbook1);
        course1.print();

        System.out.println();

        // Two instructors and textbooks
        Instructor instructor2 = new Instructor("Dave", "johannsen", "4-1234");
        Instructor instructor3 = new Instructor("Ericsson", "Marin", "8-48");
        Textbook textbook2 = new Textbook("Computer Architecture, A Quantitative Approach", "Hennessy, John L., and Patterson, David", "Morgan Kaufmann");
        Textbook textbook3 = new Textbook("Introduction to Data Mining", "Pang-Ning Tan, Michael Steinbach", "Pearson");
        Course course2 = new Course("Advanced Computer Architecture", instructor2, textbook2);
        Course course3 = new Course("Advanced Data Mining", instructor3, textbook3);
        course2.print();
        System.out.println();
        course3.print();
    }
}

