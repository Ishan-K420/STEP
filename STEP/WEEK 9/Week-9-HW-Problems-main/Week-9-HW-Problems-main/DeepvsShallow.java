import java.util.*;

class Book implements Cloneable {
    String title;
    Book(String t){title=t;}
    public Book clone(){try{return (Book)super.clone();}catch(Exception e){return null;}}
}

class Library implements Cloneable {
    List<Book> books;
    Library(List<Book> list){books=list;}
    public Library cloneShallow(){try{return (Library)super.clone();}catch(Exception e){return null;}}
    public Library cloneDeep(){
        List<Book> newList=new ArrayList<>();
        for(Book b:books)newList.add(b.clone());
        return new Library(newList);
    }
}

public class DeepvsShallow {
    public static void main(String[] args){
        List<Book> list=new ArrayList<>();
        list.add(new Book("Java"));
        list.add(new Book("C++"));
        Library l1=new Library(list);
        Library l2=l1.cloneShallow();
        Library l3=l1.cloneDeep();
        l2.books.get(0).title="Python";
        System.out.println(l1.books.get(0).title);
        System.out.println(l3.books.get(0).title);
    }
}
