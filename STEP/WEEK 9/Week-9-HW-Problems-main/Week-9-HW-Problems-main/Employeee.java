class Employee {
    int id; String name; double salary;
    Employee(int i, String n, double s) { id=i; name=n; salary=s; }
    public String toString() { return id+" "+name+" "+salary; }
}

public class Employeee {
    public static void main(String[] args) {
        Employee e1=new Employee(1,"Amit",50000);
        Employee e2=new Employee(2,"Riya",60000);
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e1.getClass().getName());
    }
}
