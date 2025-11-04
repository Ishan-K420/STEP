class Admin {
    String adminId;
    String name;
    
    Admin(String adminId, String name) {
        this.adminId = adminId;
        this.name = name;
    }
    
    void manageAppointments() {
        System.out.println(name + " is managing appointments");
    }
    
    void generateBills(Patient patient) {
        System.out.println(name + " generated bill for " + patient.name);
    }
    
    void updateRecords(String recordId) {
        System.out.println(name + " updated record " + recordId);
    }
}

class Doctor {
    String doctorId;
    String name;
    String specialization;
    
    Doctor(String doctorId, String name, String specialization) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
    }
    
    void manageAppointments() {
        System.out.println("Dr. " + name + " is checking appointments");
    }
    
    void updateRecords(Patient patient, String diagnosis) {
        System.out.println("Dr. " + name + " updated records for " + patient.name);
        System.out.println("Diagnosis: " + diagnosis);
    }
    
    void prescribeMedicine(Patient patient, String medicine) {
        System.out.println("Dr. " + name + " prescribed " + medicine + " to " + patient.name);
    }
}

class Patient {
    String patientId;
    String name;
    String disease;
    
    Patient(String patientId, String name, String disease) {
        this.patientId = patientId;
        this.name = name;
        this.disease = disease;
    }
    
    void bookAppointment(Doctor doctor) {
        System.out.println(name + " booked appointment with Dr. " + doctor.name);
    }
    
    void viewRecords() {
        System.out.println(name + " is viewing medical records");
    }
    
    void payBill(double amount) {
        System.out.println(name + " paid Rs." + amount);
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Admin admin = new Admin("A001", "Mr. Sharma");
        Doctor doctor = new Doctor("D001", "Kumar", "Cardiologist");
        Patient patient = new Patient("P001", "Rahul", "Fever");
        
        patient.bookAppointment(doctor);
        admin.manageAppointments();
        doctor.updateRecords(patient, "Viral infection");
        doctor.prescribeMedicine(patient, "Paracetamol");
        admin.generateBills(patient);
        patient.payBill(1500);
    }
}
