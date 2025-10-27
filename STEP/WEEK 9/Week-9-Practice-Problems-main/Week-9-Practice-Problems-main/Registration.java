class ContactInfo implements Cloneable{
    String email,phone;
    ContactInfo(String e,String p){email=e;phone=p;}
    protected Object clone() throws CloneNotSupportedException{return super.clone();}
}
class Student implements Cloneable{
    String id,name; ContactInfo c;
    Student(String i,String n,ContactInfo ci){id=i;name=n;c=ci;}
    protected Object clone() throws CloneNotSupportedException{return super.clone();}
    Student deepClone() throws CloneNotSupportedException{return new Student(id,name,(ContactInfo)c.clone());}
}
public class Registration{
    public static void main(String[] a)throws Exception{
        ContactInfo ci=new ContactInfo("x@mail.com","999");
        Student s1=new Student("1","A",ci);
        Student s2=(Student)s1.clone();
        Student s3=s1.deepClone();
        s1.c.email="new@mail.com";
        System.out.println(s2.c.email+" "+s3.c.email);
    }
}
