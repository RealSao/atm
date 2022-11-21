public class Withdraw extends Transaction{
    public Withdraw(){

    }

    public static boolean withdraw(Account acc, double amt){
        if(acc.getBalance() < amt){
            System.out.println("No enough money in account " + acc.getAccNum());
            return false;
        }
        else{
            acc.setBalance(-amt);
            return true;
        }
        
    }
}