import java.util.ArrayList;
import java.util.Scanner;

public class User {
    //user should have username and password to login 
    //also has a list of account associated with them
    private ArrayList<Account> acc;
    private String username;
    private String password;

    //default
    public User(){
        acc = new ArrayList<>();
        username = "";
        password = "";
    }

    //use during registration
    public User(String username, String password, ArrayList<Account> acc){
        this.username = username;
        this.password = password;
        this.acc = acc;
    }

    //use during login
    public User(String username, String password, Bank b){
        this.username = username;
        this.password = password;
        acc = (ArrayList<Account>) b.getMap().get(username);
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public ArrayList<Account> getAcc() { return acc; }

    //homepage
    public void service(){
        Scanner in = new Scanner(System.in);

        //service menu
        System.out.println("\nChoose your servcie: ");
        System.out.println("1. Transfer");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. View Account");
        System.out.println("5. Add Account");
        System.out.println("6. exit");

        int choice = in.nextInt();

        int size = acc.size();
        //allow multiple services 
        while(choice != 6){
            switch(choice){
                case 1:
                    //cant transfer money if less than 2 account
                    if(acc.size() < 2){
                        System.out.println("\nNo enough accounts to perform this action");
                    }
                    else{
                        //menu
                        System.out.println("\nChoose your account to withdraw from: ");
                        displayAcc();
                        int src = in.nextInt();
                        while(src > size){
                            System.out.println("\nInvalid choice");
                            System.out.println("Please choose again");
                            src = in.nextInt();
                        }
                        in.nextLine();
                        System.out.println("Choose your account to transfer to: ");
                        displayAcc();
                        int dest1 = in.nextInt();
                        while(dest1 > size){
                            System.out.println("\nInvalid choice");
                            System.out.println("Please choose again");
                            dest1 = in.nextInt();
                        }
                        in.nextLine();
                        System.out.println("Enter the amount to transfer:");
                        double amt1 = in.nextDouble();
        
                        //Create transaction
                        Transaction t1 = new Transaction();
                        if(t1.modify(acc.get(src - 1), amt1, acc.get(dest1 - 1), "transfer")){ //transaction could failed
                            System.out.println("\nSource account");
                            t1.display(acc.get(src - 1));
                            System.out.println("\nDestination account");
                            t1.display(acc.get(dest1 - 1));
                        }
                        else{
                            System.out.println("\nTransaction Failed"); 
                        }

                        
                    }
                    
                    break;
                case 2:
                    //menu
                    System.out.println("\nChoose your account to deposit:");
                    displayAcc();
                    int dest2 = in.nextInt();
                    while(dest2 > size){
                        System.out.println("\nInvalid choice");
                        System.out.println("Please choose again");
                        dest2 = in.nextInt();
                    }
                    in.nextLine();
                    System.out.println("Enter the amount to deposit:");
                    double amt2 = in.nextDouble();

                    //Create transaction
                    Transaction t2 = new Transaction();
                    if(t2.modify(acc.get(dest2 - 1), amt2, null, "deposit")){//transaction could failed
                        System.out.println("\nDestination account");
                        t2.display(acc.get(dest2 - 1));
                    }
                    else{
                        System.out.println("\nTransaction Failed");
                    }
                    
                    
                    break;

                case 3:
                    System.out.println("\nChoose your account to withdraw:");
                    displayAcc();
                    int dest3 = in.nextInt();
                    while(dest3 > size){
                        System.out.println("\nInvalid choice");
                        System.out.println("Please choose again");
                        dest3 = in.nextInt();
                    }
                    in.nextLine();
                    System.out.println("Enter the amount to withdraw:");
                    double amt3 = in.nextDouble();

                    //Create transaction
                    Transaction t3 = new Transaction();
                    if(t3.modify(acc.get(dest3 - 1), amt3, null, "withdraw")){//transaction could failed
                        System.out.println("\nDestination account");
                        t3.display(acc.get(dest3 - 1));
                    }
                    else{
                        System.out.println("\nTransaction Failed");
                    }

                    
                    break;
                case 4:
                    System.out.println("\nChoose an account to view:");
                    displayAcc();
                    int dest4 = in.nextInt();
                    while(dest4 > size){
                        System.out.println("\nInvalid choice");
                        System.out.println("Please choose again");
                        dest4 = in.nextInt();
                    }
                    in.nextLine();
                    System.out.println(acc.get(dest4 - 1).toString() + " has a balance of " + acc.get(dest4 - 1).getBalance());
                    break;
                
                case 5:
                    System.out.println("\nEnter your bank account number (8 digits)");
                    in.nextLine();
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
        
        
                    Account newacc = new Account(balance, accNum);
                    if(!exist(acc, newacc)){ //user could not enter an existing account in the system
                        acc.add(newacc);
                    }
                    size++;
                    break;

                default:
                    System.out.println("\nInvalid choice");
                    System.out.println("Please enter again");
                    break;
            }

            System.out.println("\nChoose your servcie: ");
            System.out.println("1. Transfer");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Account");
            System.out.println("5. Add Account");
            System.out.println("6. exit");
            choice = in.nextInt();
        }
        
        //in.close();
    }

    //display all account associated with user
    public void displayAcc(){
        for(int i = 0; i < acc.size(); i++){
            System.out.println((i + 1)+ ". " + acc.get(i).toString());
        }

        System.out.println("");
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
