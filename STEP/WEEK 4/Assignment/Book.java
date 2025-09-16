public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;
    
    // Default constructor
    public Book() {
        this.title = "";
        this.author = "";
        this.isbn = "";
        this.isAvailable = true;
    }
    
    // Constructor with title and author
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isbn = "";
        this.isAvailable = true;
    }
    
    // Constructor with all details
    public Book(String title, String author, String isbn, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }
    
    // Borrow book method
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book borrowed: " + title);
        } else {
            System.out.println("Book is not available");
        }
    }
    
    // Return book method
    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Book returned: " + title);
        } else {
            System.out.println("Book was not borrowed");
        }
    }
    
    // Display book info
    public void displayBookInfo() {
        System.out.println("=== BOOK INFO ===");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
        System.out.println("================");
    }
    
    public static void main(String[] args) {
        // Create books using different constructors
        Book book1 = new Book();
        Book book2 = new Book("1984", "George Orwell");
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084", true);
        
        // Perform operations
        book2.borrowBook();
        book3.borrowBook();
        book3.returnBook();
        
        // Display all books
        book1.displayBookInfo();
        book2.displayBookInfo();
        book3.displayBookInfo();
    }
}