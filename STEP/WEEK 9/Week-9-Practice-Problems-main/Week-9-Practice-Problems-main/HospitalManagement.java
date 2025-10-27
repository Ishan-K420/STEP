class Hospital{
    String name;
    Hospital(String n){name=n;}
    class Department{
        String d;
        Department(String dn){d=dn;}
        void show(){System.out.println(d+" Dept at "+name);}
    }
}
public class HospitalManagement{
    public static void main(String[] a){
        Hospital h=new Hospital("CityCare");
        Hospital.Department d1=h.new Department("Cardio");
        Hospital.Department d2=h.new Department("Neuro");
        d1.show();d2.show();
    }
}
