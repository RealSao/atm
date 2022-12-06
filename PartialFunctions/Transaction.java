import java.util.Date;

public class Transaction{
    //should show transaction date and id
    private Date d;
    private static int id = 1;
    private String transID;

    public Transaction(){
        d = new Date();
        transID = String.valueOf(id);
    }

    //call the selected service
    public boolean modify(Account account, double amt, Account dest, String service){
        if(service.equals("withdraw")){
            if(Withdraw.withdraw(account, amt)){
                id++;
                return true;
            }
        }
        else if(service.equals("deposit")){
            if(Deposit.deposit(account, amt)){
                id++;
                return true;
            }
        }
        else{
            if(Transfer.transfer(account, amt, dest)){
                id++;
                return true;
            }
        }
        return false;
    }

    //Display transaction info after transaction is done
    public void display(Account a){
        System.out.println("\nTransaction Done");
        System.out.println("Transaction ID: " + transID + " in " + d.toString());
        System.out.println("Your new balance is " + a.getBalance());
    }
}