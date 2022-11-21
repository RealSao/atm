import java.util.ArrayList;
import java.util.HashMap;

public class Bank {
    private static HashMap<User, ArrayList<Account>> map;

    public Bank(){
        map = new HashMap<>();
    }

    public void addUser(User user, ArrayList<Account> acc){
        map.put(user, acc);
    }

    public HashMap getMap() { return map; }
}
