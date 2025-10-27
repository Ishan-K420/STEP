interface Discount { double apply(double amt); }

class Payment {
    void processTransaction(double amt){
        class Validator {
            boolean valid(){return amt>0;}
        }
        Validator v=new Validator();
        if(v.valid()){
            Discount d=new Discount(){public double apply(double a){return a*0.9;}};
            System.out.println("Final Amount: "+d.apply(amt));
        } else System.out.println("Invalid Amount");
    }
}

public class LocalAnonymous {
    public static void main(String[] args){
        Payment p=new Payment();
        p.processTransaction(1000);
    }
}
