class BankAccount{
    private String num;double bal;int pin;
    BankAccount(String n,double b,int p){num=n;bal=b;pin=p;}
    boolean validate(int e){return e==pin;}
    void debit(double a){bal-=a;System.out.println("₹"+a+" withdrawn. Remaining balance: ₹"+bal);}
}
class ATM{
    BankAccount acc;
    ATM(BankAccount a){acc=a;}
    void withdraw(int p,double a){
        if(acc.validate(p)){acc.debit(a);System.out.println("Transaction successful.");}
        else System.out.println("Invalid PIN. Transaction failed.");
    }
}
class Customer{
    private String n;ATM atm;
    Customer(String n,ATM a){this.n=n;atm=a;}
    void perform(int p,double a){System.out.println(n+" is requesting withdrawal...");atm.withdraw(p,a);}
}
public class ATMDemo{
    public static void main(String[]a){
        BankAccount b=new BankAccount("A123",10000,1234);
        ATM atm=new ATM(b);
        Customer c=new Customer("Ravi",atm);
        c.perform(1234,2000);
        c.perform(9999,500);
    }
}
