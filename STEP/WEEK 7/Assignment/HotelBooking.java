public class HotelBooking {

    public void bookRoom(String roomType, int nights) {
        double pricePerNight = getRoomPrice(roomType);
        double total = pricePerNight * nights;
        System.out.println("Standard Booking:");
        System.out.println("Room: " + roomType);
        System.out.println("Nights: " + nights);
        System.out.println("Total: ₹" + total);
        System.out.println("-----------------------------------");
    }

    public void bookRoom(String roomType, int nights, double seasonalMultiplier) {
        double pricePerNight = getRoomPrice(roomType) * seasonalMultiplier;
        double total = pricePerNight * nights;
        System.out.println("Seasonal Booking:");
        System.out.println("Room: " + roomType);
        System.out.println("Nights: " + nights);
        System.out.println("Seasonal Multiplier: " + seasonalMultiplier);
        System.out.println("Total: ₹" + total);
        System.out.println("-----------------------------------");
    }

    public void bookRoom(String roomType, int nights, double corporateDiscount, boolean mealPackage) {
        double pricePerNight = getRoomPrice(roomType);
        double baseCost = pricePerNight * nights;
        double discount = baseCost * corporateDiscount;
        double meals = mealPackage ? nights * 500 : 0;
        double total = baseCost - discount + meals;

        System.out.println("Corporate Booking:");
        System.out.println("Room: " + roomType);
        System.out.println("Nights: " + nights);
        System.out.println("Base Cost: ₹" + baseCost);
        System.out.println("Discount: -₹" + discount);
        System.out.println("Meal Package: ₹" + meals);
        System.out.println("Final Total: ₹" + total);
        System.out.println("-----------------------------------");
    }

    public void bookRoom(String roomType, int nights, int guests, double decorationFee, double cateringCost) {
        double pricePerNight = getRoomPrice(roomType);
        double roomCost = pricePerNight * nights;
        double catering = guests * cateringCost;
        double total = roomCost + decorationFee + catering;

        System.out.println("Wedding Package Booking:");
        System.out.println("Room: " + roomType);
        System.out.println("Nights: " + nights);
        System.out.println("Guests: " + guests);
        System.out.println("Room Cost: ₹" + roomCost);
        System.out.println("Decoration Fee: ₹" + decorationFee);
        System.out.println("Catering: ₹" + catering);
        System.out.println("Grand Total: ₹" + total);
        System.out.println("-----------------------------------");
    }

    private double getRoomPrice(String roomType) {
        switch (roomType.toLowerCase()) {
            case "deluxe": return 3000;
            case "suite": return 5000;
            default: return 2000;
        }
    }

    public static void main(String[] args) {
        HotelBooking booking = new HotelBooking();
        booking.bookRoom("Deluxe", 3);
        booking.bookRoom("Suite", 2, 1.5);
        booking.bookRoom("Standard", 5, 0.1, true);
        booking.bookRoom("Suite", 2, 100, 2000, 800);
    }
}