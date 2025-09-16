import java.time.LocalDate;
import java.util.*;

public final class ImmutableStudent {
    private final String studentId;
    private final String name;
    private final LocalDate birthDate;
    private final List<String> courses;
    private final Map<String, Double> grades;
    private final LocalDate graduationDate;

    public ImmutableStudent(String studentId, String name, LocalDate birthDate,
                            List<String> courses, Map<String, Double> grades,
                            LocalDate graduationDate) {
        this.studentId = Objects.requireNonNull(studentId);
        this.name = Objects.requireNonNull(name);
        this.birthDate = birthDate;
        this.courses = new ArrayList<>(Objects.requireNonNull(courses));
        this.grades = new HashMap<>(Objects.requireNonNull(grades));
        this.graduationDate = graduationDate;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<String> getCourses() {
        return new ArrayList<>(courses);
    }

    public Map<String, Double> getGrades() {
        return new HashMap<>(grades);
    }

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public int getAge() {
        return LocalDate.now().getYear() - birthDate.getYear();
    }

    public double getGPA() {
        if (grades.isEmpty()) return 0.0;
        double total = 0;
        for (double grade : grades.values()) {
            total += grade;
        }
        return total / grades.size();
    }

    public int getTotalCourses() {
        return courses.size();
    }

    public boolean isGraduated() {
        return graduationDate != null;
    }

    public ImmutableStudent withGraduationDate(LocalDate date) {
        return new ImmutableStudent(studentId, name, birthDate, courses, grades, date);
    }

    public ImmutableStudent withAdditionalCourse(String course) {
        List<String> newCourses = new ArrayList<>(courses);
        newCourses.add(course);
        return new ImmutableStudent(studentId, name, birthDate, newCourses, grades, graduationDate);
    }

    public ImmutableStudent withGrade(String course, double grade) {
        Map<String, Double> newGrades = new HashMap<>(grades);
        newGrades.put(course, grade);
        return new ImmutableStudent(studentId, name, birthDate, courses, newGrades, graduationDate);
    }

    public ImmutableStudent withName(String newName) {
        return new ImmutableStudent(studentId, newName, birthDate, courses, grades, graduationDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ImmutableStudent)) return false;
        ImmutableStudent that = (ImmutableStudent) o;
        return studentId.equals(that.studentId) && name.equals(that.name) &&
               Objects.equals(birthDate, that.birthDate) && courses.equals(that.courses) &&
               grades.equals(that.grades) && Objects.equals(graduationDate, that.graduationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, name, birthDate, courses, grades, graduationDate);
    }

    @Override
    public String toString() {
        return "ImmutableStudent{" +
               "studentId='" + studentId + '\'' +
               ", name='" + name + '\'' +
               ", birthDate=" + birthDate +
               ", courses=" + courses +
               ", grades=" + grades +
               ", graduationDate=" + graduationDate +
               '}';
    }

    public static void main(String[] args) {
        List<String> courses = Arrays.asList("Math", "Science");
        Map<String, Double> grades = new HashMap<>();
        grades.put("Math", 95.0);
        grades.put("Science", 87.0);

        ImmutableStudent student = new ImmutableStudent("S1", "Alice", LocalDate.of(2000, 1, 1),
                                                        courses, grades, null);
        System.out.println(student.getAge());
        System.out.println(student.getGPA());
        System.out.println(student.isGraduated());

        ImmutableStudent graduatedStudent = student.withGraduationDate(LocalDate.of(2024, 6, 30));
        System.out.println(graduatedStudent.isGraduated());
    }
}
