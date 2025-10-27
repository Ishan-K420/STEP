//question 1

class Book {
    String title, author;

    Book(String t, String a) {
        title = t;
        author = a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Book))
            return false;
        Book b = (Book) o;
        return title.equals(b.title) && author.equals(b.author);
    }
}

public class Main1 {
    public static void main(String[] args) {
        Book b1 = new Book("Java", "James");
        Book b2 = new Book("Java", "James");
        System.out.println(b1 == b2);
        System.out.println(b1.equals(b2));
    }
}

// question 2

class Car {
    String brand, model;
    double price;

    Car(String b, String m, double p) {
        brand = b;
        model = m;
        price = p;
    }

    @Override
    public String toString() {
        return brand + " " + model + " " + price;
    }
}

public class Main2 {
    public static void main(String[] args) {
        Car c = new Car("Tesla", "Model S", 99999);
        System.out.println(c);
        System.out.println(c.getClass().getName());
    }
}

// question 3

import java.util.*;

class Student {
    int id;
    String name;

    Student(int i, String n) {
        id = i;
        name = n;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Student))
            return false;
        return id == ((Student) o).id;
    }

    public int hashCode() {
        return Objects.hash(id);
    }
}

public class Main3 {
    public static void main(String[] args) {
        HashSet<Student> set = new HashSet<>();
        set.add(new Student(1, "Alok"));
        set.add(new Student(1, "Singh"));
        System.out.println(set);
    }
}

// question 4

class Address implements Cloneable {
    String city;

    Address(String c) {
        city = c;
    }

    public Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }
}

class Person implements Cloneable {
    String name;
    Address addr;

    Person(String n, Address a) {
        name = n;
        addr = a;
    }

    public Person clone() throws CloneNotSupportedException {
        Person p = (Person) super.clone();
        p.addr = addr.clone();
        return p;
    }
}

public class Main4 {
    public static void main(String[] args) throws Exception {
        Person p1 = new Person("Alok", new Address("Delhi"));
        Person p2 = p1.clone();
        p2.addr.city = "Mumbai";
        System.out.println(p1.addr.city);
        System.out.println(p2.addr.city);
    }
}

// question 5 Member Inner Class
class Outer {
    private String msg = "Hello";

    class Inner {
        void display() {
            System.out.println(msg);
        }
    }
}

public class Main5 {
    public static void main(String[] args) {
        Outer o = new Outer();
        Outer.Inner i = o.new Inner();
        i.display();
    }
}
