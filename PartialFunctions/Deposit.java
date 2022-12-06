public class Deposit extends Transaction{
    public Deposit(){

    }

    //deposit function
    public static boolean deposit(Account acc, double amt){
        if(amt > 0){
            acc.setBalance(amt);
            return true;
        }
        else if(amt == 0){
            System.out.println("\nTransaction is not necessary");
            return false;
        }
        else{
            System.out.println("\nInvalid amount entered");
            return false;
        }
        
    }
}