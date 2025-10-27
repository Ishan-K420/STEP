class Vehicle {
    private String reg, type; double rate;
    Vehicle(String r, String t, double ra){reg=r;type=t;rate=ra;}
    public String toString(){return "Vehicle: "+reg+", Type: "+type+", Rate: $"+rate+"/day";}
}
public class VehicleRental {
    public static void main(String[] a){
        Vehicle v1=new Vehicle("MH12AB1234","Sedan",1500);
        System.out.println(v1);
        Vehicle v2=new Vehicle("MH12AB5678","SUV",2000);
        System.out.println(v2);
    }
}
