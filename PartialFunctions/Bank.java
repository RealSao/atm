import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;

public class Bank {
    //HashMap allows one user only maps to one list of account
    private static HashMap<User, ArrayList<Account>> map;

    //constructor
    public Bank(){
        map = new HashMap<>();
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
