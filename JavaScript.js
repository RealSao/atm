import java.util.Date;

public class Transaction {
    //should show transaction date and id
    const Date d;
    var id = 0;
    var transID;

    public Transaction() {
        d = new Date();
        transID = String.valueOf(id++);
    }

    //call the selected service
    modify: function(Account account, double amt, Account dest, String service) {
        if (service.equals("withdraw")) {
            return Withdraw.withdraw(account, amt);
        }
        else if (service.equals("deposit")) {
            return Deposit.deposit(account, amt);
        }
        else {
            return Transfer.transfer(account, amt, dest);
        }

    }

    //Display transaction info after transaction is done
    display: function() {
        console.log("Transaction Done");
        console.log("Transaction ID: " + transID + " in " + d.toString());
        console.log("Your new balance is " + a.getBalance());
    }
}