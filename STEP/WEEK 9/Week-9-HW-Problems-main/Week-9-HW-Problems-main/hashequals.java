import java.util.*;

class Student {
    int rollNo; String name;
    Student(int r,String n){rollNo=r;name=n;}
    public boolean equals(Object o){
        if(this==o)return true;
        if(o==null||getClass()!=o.getClass())return false;
        Student s=(Student)o;
        return rollNo==s.rollNo;
    }
    public int hashCode(){return Objects.hash(rollNo);}
    public String toString(){return rollNo+" "+name;}
}

public class hashequals {
    public static void main(String[] args){
        HashSet<Student> set=new HashSet<>();
        set.add(new Student(1,"A"));
        set.add(new Student(1,"B"));
        set.add(new Student(2,"C"));
        System.out.println(set);
    }
}
