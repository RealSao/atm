import java.util.ArrayList;
import java.util.Scanner;

public class Register {
    private String username;
    private String password;

    public Register(String username, String password){
        this.username = username;
        this.password = password;
    }

    public void register(){
        Scanner in = new Scanner(System.in);

        System.out.println("Please add in your accounts");

        ArrayList<Account> accList = addBankInfo();
        User user = new User(username, password, accList);
        Bank b = new Bank();
        b.addUser(user, accList);

        user.service();
    }

    public ArrayList<Account> addBankInfo(){
        Scanner in = new Scanner(System.in);
        String choice;

        ArrayList<Account> accList = new ArrayList<>();
        do{
            System.out.println("Enter your bank account number");
            String accNum = in.nextLine();
            System.out.println("Enter your balance");
            double balance = in.nextDouble();

            Account acc = new Account(balance, accNum);
            if(!exist(accList, acc)){
                accList.add(acc);
            }

            System.out.println("Do you have next account to add? reply 'y' or 'n'");
            choice = in.next();
            in.nextLine();
        }while(!choice.equals("n"));

        return accList;
    }

    public boolean exist(ArrayList<Account> accList, Account acc){
        for(Account a: accList){
            if(a.getAccNum().equals(acc.getAccNum())){
                if(a.getBalance() != acc.getBalance()){
                    System.out.println("You might enter the wrong bank account number");
                }
                else{
                    System.out.println("This account already exist");
                }
                return true;
            }
        }
        return false;
    }

}
