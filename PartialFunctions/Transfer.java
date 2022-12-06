public class Transfer extends Transaction{
    public Transfer(){

    }

    //transfer
    public static boolean transfer(Account acc, double amt, Account dest){
        if(acc.getBalance() < amt){
            System.out.println("\nNo enough money in account " + acc.getAccNum());
            return false;
        }
        else if (amt < 0){
            System.out.println("\nInvalid amount entered");
            return false;
        }
        else if(amt == 0){
            System.out.println("\nTransaction is not necessary");
            return false;
        }
        else{
            acc.setBalance(-amt);
            dest.setBalance(amt);
            return true;
        }   
    }
}