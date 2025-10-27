class Employee {
    String code,name;
    Employee(String c,String n){code=c;name=n;}
    public boolean equals(Object o){return o instanceof Employee && code.equals(((Employee)o).code);}
    public int hashCode(){return code.hashCode();}
    public String toString(){return code+" "+name;}
}
import java.util.*;
public class EmployeeAuth {
    public static void main(String[] a){
        Employee e1=new Employee("BL001","Ritika");
        Employee e2=new Employee("BL001","Ritika S");
        System.out.println(e1==e2);
        System.out.println(e1.equals(e2));
        HashSet<Employee> s=new HashSet<>();
        s.add(e1);s.add(e2);
        System.out.println(s);
    }
}
