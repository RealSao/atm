import java.util.Date;
public class Transaction{
    private Date d;
    private static int id = 0;
    private String transID;

    public Transaction(){
        d = new Date();
        transID = String.valueOf(id++);
    }

    public boolean modify(Account account, double amt, Account dest, String service){
        if(service.equals("withdraw")){
            return Withdraw.withdraw(account, amt);
        }
        else if(service.equals("deposit")){
            return Deposit.deposit(account, amt);
        }
        else{
            return Transfer.transfer(account, amt, dest);
        }

    }

    public void display(Account a){
        System.out.println("Transaction Done");
        System.out.println("Transaction ID: " + transID + " in " + d.toString());
        System.out.println("Your new balance is " + a.getBalance());
    }
}