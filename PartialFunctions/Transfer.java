public class Transfer extends Transaction{
    public Transfer(){

    }

    public static boolean transfer(Account acc, double amt, Account dest){
        if(acc.getBalance() < amt){
            System.out.println("No enough money in account " + acc.getAccNum());
            return false;
        }
        else{
            acc.setBalance(-amt);
            dest.setBalance(amt);
            return true;
        }   
    }
}