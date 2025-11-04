import java.util.*;
class Product{
    private String n;double p;
    Product(String n,double p){this.n=n;this.p=p;}
    void show(){System.out.println("Product:"+n+", Price:₹"+p);}
    String getName(){return n;}
}
class Order{
    private String id;List<Product>p;
    Order(String id){this.id=id;p=new ArrayList<>();}
    void add(Product pr){p.add(pr);System.out.println("Added product '"+pr.getName()+"' to Order "+id);}
    void show(){System.out.println("Order "+id+" contains:");for(Product x:p)x.show();}
}
class Customer{
    private String n,e;List<Order>o;
    Customer(String n,String e){this.n=n;this.e=e;o=new ArrayList<>();}
    void place(Order or){o.add(or);System.out.println(n+" placed Order "+or);}
    void show(){System.out.println("Orders placed by "+n+":");for(Order x:o)x.show();}
}
public class ShoppingDemo{
    public static void main(String[]a){
        Customer c=new Customer("Amit","amit@gmail.com");
        Product p1=new Product("Laptop",55000),p2=new Product("Mobile",20000),p3=new Product("Mouse",500);
        Order o1=new Order("O1");o1.add(p1);o1.add(p2);
        Order o2=new Order("O2");o2.add(p3);
        c.place(o1);c.place(o2);
        c.show();
    }
}
