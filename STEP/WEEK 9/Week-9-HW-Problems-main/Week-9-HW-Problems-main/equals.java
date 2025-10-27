class Product {
    int productId; String productName;
    Product(int id,String name){productId=id;productName=name;}
    public boolean equals(Object o){
        if(this==o)return true;
        if(o==null||getClass()!=o.getClass())return false;
        Product p=(Product)o;
        return productId==p.productId;
    }
}

public class equals {
    public static void main(String[] args){
        Product p1=new Product(101,"Pen");
        Product p2=new Product(101,"Pen");
        System.out.println(p1==p2);
        System.out.println(p1.equals(p2));
    }
}
