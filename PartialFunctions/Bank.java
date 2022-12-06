import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Bank {
    //HashMap allows one user only maps to one list of account
    private static HashMap<User, ArrayList<Account>> map;

    //constructor
    public Bank() throws FileNotFoundException{
        // First we'll grab any and all accounts and put them along with their ammounts in a HashMap
        HashMap<String, Double> accountMap = new HashMap<>();
        map = new HashMap<>();
        try {
            File myFile = new File("./PartialFunctions/accounts.txt");
            Scanner scnr = new Scanner(myFile);
            
            while (scnr.hasNextLine()) {
                String l = scnr.nextLine();
                if(l != ""){
                    String[] temp = l.split(" ");
                    String accountNumber = temp[0];
                    Double ammount = Double.parseDouble(temp[1]);
                    accountMap.put(accountNumber, ammount);
                }
            }

            BufferedReader reader = new BufferedReader(new FileReader("./PartialFunctions/users.txt"));
            String line = "";
            String[] readList;

            while (line != null) {
                line = reader.readLine();
                if (line != null && !line.equals("")) {
                    readList = line.split(" ");
                
                    //System.out.println(line);

                    ArrayList<Account> accounts = new ArrayList<Account>();
                    for (int i=2; i < readList.length; i++) { // Make an account object for each found in the file, add it to the account list for this user
                        Account newAccount = new Account(accountMap.get(readList[i]), readList[i]); 
                        accounts.add(newAccount);
                    }

                    User readUser = new User(readList[0], readList[1], accounts);
                    addUser(readUser, accounts);
                }
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

    public void updateDB() throws FileNotFoundException{
        try{
            File accFile = new File("./PartialFunctions/accounts.txt");
            File userFile = new File("./PartialFunctions/users.txt");
    
            PrintWriter w1 = new PrintWriter(accFile);
            PrintWriter w2 = new PrintWriter(userFile);

            for(User u: map.keySet()){
                w2.print(u.getUsername() + " " + u.getPassword() + " ");
                for(Account a: u.getAcc()){
                    w2.print(a.getAccNum() + " ");
                    w1.print(a.getAccNum() + " ");
                    w1.print(String.format("%.2f\n", a.getBalance()));
                }
                w2.println("");
            }

            w1.close();
            w2.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Can't open file: " + e);
        }
    }
}
