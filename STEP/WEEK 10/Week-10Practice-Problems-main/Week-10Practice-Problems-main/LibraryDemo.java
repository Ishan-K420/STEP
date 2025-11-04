import java.util.*;
class Book{
    private String t,a,i;
    Book(String t,String a,String i){this.t=t;this.a=a;this.i=i;}
    void show(){System.out.println("Title:"+t+", Author:"+a+", ISBN:"+i);}
    String getTitle(){return t;}
}
class Library{
    private String n;List<Book>b;
    Library(String n){this.n=n;b=new ArrayList<>();}
    void addBook(Book bk){b.add(bk);System.out.println("Added book '"+bk.getTitle()+"' to "+n+" Library");}
    void showBooks(){System.out.println("Books in "+n+" Library:");for(Book x:b)x.show();}
}
class Member{
    private String n;List<Book>b;
    Member(String n){this.n=n;b=new ArrayList<>();}
    void borrow(Book bk){b.add(bk);System.out.println(n+" borrowed book: "+bk.getTitle());}
    void show(){System.out.println("Books borrowed by "+n+":");for(Book x:b)x.show();}
}
public class LibraryDemo{
    public static void main(String[]a){
        Library l=new Library("Central");
        Book b1=new Book("Java","James","J01"),b2=new Book("C++","Bjarne","C02"),b3=new Book("Python","Guido","P03");
        l.addBook(b1);l.addBook(b2);l.addBook(b3);l.showBooks();
        Member m=new Member("Ravi");
        m.borrow(b1);m.borrow(b2);m.show();
    }
}
