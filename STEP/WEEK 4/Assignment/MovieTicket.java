public class MovieTicket {
    private String movieName;
    private String theatreName;
    private int seatNumber;
    private double price;
    
    // Default constructor
    public MovieTicket() {
        this.movieName = "Unknown";
        this.theatreName = "Unknown";
        this.seatNumber = 0;
        this.price = 0.0;
    }
    
    // Constructor with movie name
    public MovieTicket(String movieName) {
        this.movieName = movieName;
        this.theatreName = "Unknown";
        this.seatNumber = 0;
        this.price = 200.0;
    }
    
    // Constructor with movie name and seat number
    public MovieTicket(String movieName, int seatNumber) {
        this.movieName = movieName;
        this.theatreName = "PVR";
        this.seatNumber = seatNumber;
        this.price = 200.0;
    }
    
    // Full constructor
    public MovieTicket(String movieName, String theatreName, int seatNumber, double price) {
        this.movieName = movieName;
        this.theatreName = theatreName;
        this.seatNumber = seatNumber;
        this.price = price;
    }
    
    // Print ticket method
    public void printTicket() {
        System.out.println("=== MOVIE TICKET ===");
        System.out.println("Movie: " + movieName);
        System.out.println("Theatre: " + theatreName);
        System.out.println("Seat: " + seatNumber);
        System.out.println("Price: $" + price);
        System.out.println("==================");
    }
    
    public static void main(String[] args) {
        // Create tickets using different constructors
        MovieTicket ticket1 = new MovieTicket();
        MovieTicket ticket2 = new MovieTicket("Avengers");
        MovieTicket ticket3 = new MovieTicket("Spider-Man", 15);
        MovieTicket ticket4 = new MovieTicket("Batman", "INOX", 25, 350.0);
        
        // Print all tickets
        ticket1.printTicket();
        ticket2.printTicket();
        ticket3.printTicket();
        ticket4.printTicket();
    }
}