class Book {
    String title;
    String author;
    String isbn;
    
    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
    
    void displayInfo() {
        System.out.println("Book: " + title + " by " + author);
    }
}

class Member {
    String name;
    String memberId;
    Book[] borrowedBooks;
    int bookCount;
    
    Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new Book[5];
        this.bookCount = 0;
    }
    
    void borrowBook(Book book) {
        if(bookCount < 5) {
            borrowedBooks[bookCount++] = book;
            System.out.println(name + " borrowed " + book.title);
        }
    }
    
    void returnBook(int index) {
        if(index < bookCount) {
            System.out.println(name + " returned " + borrowedBooks[index].title);
            borrowedBooks[index] = null;
        }
    }
}

class Librarian {
    String name;
    String employeeId;
    
    Librarian(String name, String employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }
    
    void issueBook(Member member, Book book) {
        member.borrowBook(book);
    }
    
    void receiveBook(Member member, int index) {
        member.returnBook(index);
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Book book1 = new Book("Java Programming", "Author A", "ISBN001");
        Book book2 = new Book("Data Structures", "Author B", "ISBN002");
        
        Member member1 = new Member("Rajesh", "M001");
        Librarian librarian = new Librarian("Mrs. Sharma", "L001");
        
        librarian.issueBook(member1, book1);
        librarian.issueBook(member1, book2);
    }
}
