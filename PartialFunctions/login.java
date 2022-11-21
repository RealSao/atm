import java.util.Scanner;
public class login {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String username, password, choice;
        Bank b = new Bank();

        do{
            System.out.println("Enter username:");
            username = in.nextLine();
            System.out.println("Enter your password: ");
            password = in.nextLine();
    
            //Database haven't done
            if(!username.equals("") && !password.equals("")){
                if(username.equals("valid")){
                    User user = new User(username, password, b);
                    user.service();
                }
                else{
                    Register r = new Register(username, password);
                    r.register();
                }
            }
            else{
                System.out.println("Invalid input, please try again");
                System.out.println("Do you want to leave? reply 'y' or 'n'");
                choice = in.next();
                if(!choice.equals("y"))
                    continue;
                else
                    break;
            }
            

            System.out.println("You have logout");
            System.out.println("Do you want to leave? reply 'y' or 'n'");
            choice = in.next();
        }while(!choice.equals("y"));
        System.out.println("Have a good day!");
    }


}
