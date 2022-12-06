import java.util.ArrayList;
import java.util.Scanner;

public class Register {
    private String username;
    private String password;

    //user already entered username and password
    public Register(String username, String password){
        this.username = username;
        this.password = password;
    }

    //register user
    public void register(){
        Scanner in = new Scanner(System.in);

        //add in associated bank account with this user
        System.out.println("\nPlease add in your accounts");

        ArrayList<Account> accList = addBankInfo();
        User user = new User(username, password, accList);
        Bank b = new Bank();
        //add this newly created user to the bank info
        b.addUser(user, accList);

        //could begin using the services
        user.service();

        //in.close();
    }

    //Enter bank account that the user has
    public ArrayList<Account> addBankInfo(){
        Scanner in = new Scanner(System.in);
        String choice;

        ArrayList<Account> accList = new ArrayList<>();
        //allow multiple account to be entered
        do{
            System.out.println("\nEnter your bank account number (8 digits)");
            String accNum = in.nextLine();
            while(accNum.length() != 8){
                System.out.println("\nInvalid input");
                System.out.println("Please enter again");
                accNum = in.nextLine();
            }
            System.out.println("Enter your balance");
            double balance = in.nextDouble();
            while(balance < 0){
                System.out.println("\nInvalid input");
                System.out.println("Please enter again");
                balance = in.nextDouble();
            }
            in.nextLine();


            Account acc = new Account(balance, accNum);
            if(!exist(accList, acc)){ //user could not enter an existing account in the system
                accList.add(acc);
            }

            System.out.println("\nDo you have next account to add? reply 'y' or 'n'");
            choice = in.next();
            in.nextLine();
            while(!choice.equals("y") && !choice.equals("n")){
                System.out.println("\nInvalid input");
                System.out.println("Please enter again");
                choice = in.next();
                in.nextLine();
            }
        }while(!choice.equals("n"));

        //in.close();

        return accList;
    }

    //determine if an account is exist on file
    public boolean exist(ArrayList<Account> accList, Account acc){
        for(Account a: accList){
            if(a.getAccNum().equals(acc.getAccNum())){ //account exist
                if(a.getBalance() != acc.getBalance()){ //differ in balance
                    System.out.println("\nYou might enter the wrong bank account number");
                }
                else{
                    System.out.println("\nThis account already exist");
                }
                return true;
            }
        }
        return false;
    }

}
