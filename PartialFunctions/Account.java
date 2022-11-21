public class Account{
    private double balance;
    private String accNum;

    public Account(){
        balance = 0;
        accNum = "";
    }

    public Account(double balance, String accNum){
        this.balance = balance;
        this.accNum = accNum;
    }

    public double getBalance(){ return this.balance; }
    public void setBalance(double amt) { this.balance += amt; }
    public String getAccNum(){ return accNum; }

    public void withdraw(double amt){
        Transaction trans = new Transaction();
        trans.modify(this, amt, null, "withdraw");
    }

    public void transfer(double amt, Account dest){
        Transaction trans = new Transaction();
        trans.modify(this, amt, dest, "transfer");
    }

    public void deposit(double amt){
        Transaction trans = new Transaction();
        trans.modify(this, amt, null, "deposit");
    }

    public String toString(){
        return accNum;
    }

}