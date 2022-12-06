import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;

public class Bank {
    //HashMap allows one user only maps to one list of account
    private static HashMap<User, ArrayList<Account>> map;

    //constructor
    public Bank(){
        // First we'll grab any and all accounts and put them along with their ammounts in a HashMap
        accountMap = new HashMap<>();
        try {
            File myFile = new File("accounts.txt");
            Scanner scnr = new Scanner(myFile);
            
            while (scnr.hasNextLine()) {
                String accountNumber = scnr.next();
                Double ammount = scnr.nextDouble();
                accountMap.put(accountNumber, ammount);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Failed to open file");
            return;
        }
        
        map = new HashMap<>();

        // Take each existing user in the file and add them to the list of users
        try {
            BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
            String line = "";
            String[] readList;

            while (line != null) {
                line = reader.readLine();
                if (line == null) {
                    break;
                }
                readList = line.split(" ");
                
                System.out.println(line);

                ArrayList<Account> accounts = new ArrayList<Account>();
                for (int i=2; i < readList.length; i++) { // Make an account object for each found in the file, add it to the account list for this user
                    Account newAccount = new Account(accountMap.get(readList[i]), readList[i]); 
                    accounts.add(newAccount);
                }

                User readUser = new User(readList[0], readList[1], accounts);
                addUser(readUser, accounts);

            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Failed to open file");
            return;
        }
        catch (IOException e) {
            System.out.println("File Read Error");
            return;
        }

    }

    //Add newly registered user to the bank info
    public void addUser(User user, ArrayList<Account> acc){
        map.put(user, acc);
    }

    public HashMap<User, ArrayList<Account>> getMap() { return map; }

    public boolean verifyUsername(String username){
        for(User u: map.keySet()){
            if(u.getUsername().equals(username))
                return true;
        }
        return false;
    }

    public boolean verifyPassword(String password){
        for(User u: map.keySet()){
            if(u.getPassword().equals(password))
                return true;
        }
        return false;
    }

    public User getUser(String username){
        for(User u: map.keySet()){
            if(u.getUsername().equals(username))
                return u;
        }
        return null;
    }
}
