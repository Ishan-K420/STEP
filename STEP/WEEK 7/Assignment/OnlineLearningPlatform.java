import java.time.LocalDate;

// Base Course class with common properties
abstract class Course {
    protected String title;
    protected String instructor;
    protected LocalDate enrollmentDate;
    
    public Course(String title, String instructor, LocalDate enrollmentDate) {
        this.title = title;
        this.instructor = instructor;
        this.enrollmentDate = enrollmentDate;
    }
    
    // Common method to display basic info
    public void displayBasicInfo() {
        System.out.println("Course: " + title);
        System.out.println("Instructor: " + instructor);
        System.out.println("Enrolled: " + enrollmentDate);
    }
    
    // Abstract method to be overridden by subclasses
    public abstract void displayProgress();
}

// Video Course implementation
class VideoCourse extends Course {
    private double completionPercentage;
    private int watchTimeMinutes;
    
    public VideoCourse(String title, String instructor, LocalDate enrollmentDate, 
                      double completionPercentage, int watchTimeMinutes) {
        super(title, instructor, enrollmentDate);
        this.completionPercentage = completionPercentage;
        this.watchTimeMinutes = watchTimeMinutes;
    }
    
    @Override
    public void displayProgress() {
        displayBasicInfo();
        System.out.println("Completion: " + completionPercentage + "%");
        System.out.println("Watch Time: " + watchTimeMinutes + " minutes");
        System.out.println("-----------------------------------");
    }
}

// Interactive Course implementation
class InteractiveCourse extends Course {
    private double averageQuizScore;
    private int projectsCompleted;
    
    public InteractiveCourse(String title, String instructor, LocalDate enrollmentDate,
                           double averageQuizScore, int projectsCompleted) {
        super(title, instructor, enrollmentDate);
        this.averageQuizScore = averageQuizScore;
        this.projectsCompleted = projectsCompleted;
    }
    
    @Override
    public void displayProgress() {
        displayBasicInfo();
        System.out.println("Quiz Score: " + averageQuizScore + "%");
        System.out.println("Projects Completed: " + projectsCompleted);
        System.out.println("-----------------------------------");
    }
}

// Reading Course implementation
class ReadingCourse extends Course {
    private int pagesRead;
    private int notesCount;
    
    public ReadingCourse(String title, String instructor, LocalDate enrollmentDate,
                        int pagesRead, int notesCount) {
        super(title, instructor, enrollmentDate);
        this.pagesRead = pagesRead;
        this.notesCount = notesCount;
    }
    
    @Override
    public void displayProgress() {
        displayBasicInfo();
        System.out.println("Pages Read: " + pagesRead);
        System.out.println("Notes Taken: " + notesCount);
        System.out.println("-----------------------------------");
    }
}

// Certification Course implementation
class CertificationCourse extends Course {
    private int examAttempts;
    private String certificationStatus;
    
    public CertificationCourse(String title, String instructor, LocalDate enrollmentDate,
                             int examAttempts, String certificationStatus) {
        super(title, instructor, enrollmentDate);
        this.examAttempts = examAttempts;
        this.certificationStatus = certificationStatus;
    }
    
    @Override
    public void displayProgress() {
        displayBasicInfo();
        System.out.println("Exam Attempts: " + examAttempts);
        System.out.println("Status: " + certificationStatus);
        System.out.println("-----------------------------------");
    }
}

public class OnlineLearningPlatform {
    public static void main(String[] args) {
        Course[] courses = {
            new VideoCourse("Java Fundamentals", "Dr. Smith", LocalDate.of(2024, 1, 15), 75.5, 180),
            new InteractiveCourse("Web Development", "Prof. Johnson", LocalDate.of(2024, 2, 1), 88.2, 3),
            new ReadingCourse("Data Structures", "Dr. Brown", LocalDate.of(2024, 1, 20), 120, 25),
            new CertificationCourse("AWS Solutions Architect", "Expert Wilson", LocalDate.of(2024, 3, 1), 2, "Certified")
        };
        
        System.out.println("ONLINE LEARNING PLATFORM - PROGRESS REPORT");
        System.out.println("==========================================");
        
        for (Course course : courses) {
            course.displayProgress();
        }
    }
}