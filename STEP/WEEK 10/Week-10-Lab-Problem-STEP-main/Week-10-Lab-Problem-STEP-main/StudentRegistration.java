class RegistrationForm {
    String studentName;
    String email;
    String course;
    boolean isValid;
    
    RegistrationForm(String studentName, String email, String course) {
        this.studentName = studentName;
        this.email = email;
        this.course = course;
        this.isValid = false;
    }
    
    boolean validate() {
        if(studentName != null && email != null && course != null) {
            isValid = true;
            System.out.println("Form data is valid");
        } else {
            System.out.println("Form data is invalid");
        }
        return isValid;
    }
}

class Admin {
    String adminName;
    
    Admin(String adminName) {
        this.adminName = adminName;
    }
    
    boolean approveRegistration(RegistrationForm form) {
        System.out.println(adminName + " reviewing registration...");
        if(form.isValid) {
            System.out.println("Registration approved for " + form.studentName);
            return true;
        } else {
            System.out.println("Registration rejected");
            return false;
        }
    }
}

class RegistrationSystem {
    void processRegistration(RegistrationForm form, Admin admin) {
        System.out.println("Starting registration process...");
        
        if(form.validate()) {
            boolean approved = admin.approveRegistration(form);
            if(approved) {
                System.out.println("Confirmation sent to " + form.email);
                System.out.println("Registration complete!");
            }
        } else {
            System.out.println("Please fill the form again");
        }
    }
}

public class StudentRegistration {
    public static void main(String[] args) {
        RegistrationForm form = new RegistrationForm("Ananya", "ananya@srmist.edu.in", "CSE");
        Admin admin = new Admin("Dr. Kumar");
        RegistrationSystem system = new RegistrationSystem();
        
        system.processRegistration(form, admin);
    }
}
