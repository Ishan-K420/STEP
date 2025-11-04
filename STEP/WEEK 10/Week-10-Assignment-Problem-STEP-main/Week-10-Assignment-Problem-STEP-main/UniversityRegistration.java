class Student {
    String name;
    String email;
    
    Student(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    boolean fillForm(RegistrationForm form) {
        System.out.println(name + " filling registration form...");
        form.studentName = this.name;
        form.email = this.email;
        return validateForm(form);
    }
    
    boolean validateForm(RegistrationForm form) {
        if(form.studentName != null && form.email != null) {
            System.out.println("Form details are valid");
            return true;
        } else {
            System.out.println("Form details are invalid. Please fill again.");
            return false;
        }
    }
    
    void uploadDocuments() {
        System.out.println(name + " uploading documents...");
        System.out.println("Documents uploaded successfully");
    }
    
    void payFees(double amount) {
        System.out.println(name + " paying fees of Rs." + amount);
        System.out.println("Payment successful");
    }
}

class RegistrationForm {
    String studentName;
    String email;
    String course;
    
    RegistrationForm(String course) {
        this.course = course;
    }
}

class RegistrationSystem {
    void processRegistration(Student student, RegistrationForm form) {
        System.out.println("Starting registration process...");
        
        boolean formValid = student.fillForm(form);
        
        if(formValid) {
            student.uploadDocuments();
            student.payFees(50000);
            sendConfirmation(student);
        } else {
            System.out.println("Registration failed");
        }
    }
    
    void sendConfirmation(Student student) {
        System.out.println("Confirmation email sent to " + student.email);
        System.out.println("Registration completed successfully!");
    }
}

public class UniversityRegistration {
    public static void main(String[] args) {
        Student student = new Student("Arjun", "arjun@srmist.edu.in");
        RegistrationForm form = new RegistrationForm("Computer Science");
        RegistrationSystem system = new RegistrationSystem();
        
        system.processRegistration(student, form);
    }
}
