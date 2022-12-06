import java.io.FileNotFoundException;
import java.util.Scanner;

public class login {
    //Login Page
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        String username, password, choice;
        Bank b = new Bank(); 

        //allow login until user leave
        do{
            //Prompt
            System.out.println("Enter username:");
            username = in.nextLine();
            System.out.println("Enter your password: ");
            password = in.nextLine();
    
            //Database haven't done
            //Treat only valid as match in database
            if(!username.equals("") && !password.equals("")){
                if(b.verifyUsername(username)){ //user exist
                    //Go to homepage
                    if(b.verifyPassword(password)){
                        User user = b.getUser(username);
                        if(user == null){
                            user = new User(username, password, b);
                        }
                        user.service();
                    }
                    else{
                        System.out.println("\nInvalid password");
                    }
                }
                else{
                    //Create User
                    System.out.println("\nNo such user, please register to continue");
                    Register r = new Register(username, password);
                    r.register();
                }
            }
            else{
                //Display error message when invalid input
                System.out.println("\nInvalid input, please try again");
                System.out.println("Do you want to leave? reply 'y' or 'n'");
                choice = in.next();
                if(!choice.equals("y"))
                    continue;
                else
                    break;
            }
            
            System.out.println("\nYou have logout");
            System.out.println("Do you want to leave? reply 'y' or 'n'");
            choice = in.next();
            in.nextLine(); //clear buffer
            while(!choice.equals("y") && !choice.equals("n")){
                System.out.println("\nInvalid input");
                System.out.println("Please enter again");
                choice = in.next();
                in.nextLine();
            }
        }while(!choice.equals("y"));
        System.out.println("\nHave a good day!");
        b.updateDB();

        //in.close();
    }


}
