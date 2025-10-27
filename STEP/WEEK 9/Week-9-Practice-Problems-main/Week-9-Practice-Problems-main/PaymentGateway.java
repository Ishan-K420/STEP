class Payment{void pay(){System.out.println("Generic payment");}}
class CreditCardPayment extends Payment{void pay(){System.out.println("Card payment");}}
class WalletPayment extends Payment{void pay(){System.out.println("Wallet payment");}}
public class PaymentGateway{
    public static void main(String[] a){
        Payment[] p={new CreditCardPayment(),new WalletPayment()};
        for(Payment x:p){System.out.println(x.getClass().getSimpleName());x.pay();}
    }
}
