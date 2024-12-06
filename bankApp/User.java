package bankApp;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private HashMap<String, Integer> balanceMap = new HashMap<>();
    private HashMap<String, ArrayList<String>> transactionHistory = new HashMap<>();
    private HashMap<String, String> credentials = new HashMap<>();

    public boolean isValidUser(String id) {
        return credentials.containsKey(id);
    }

    public boolean checkPassword(String id, String pass) {
        return pass.equals(credentials.get(id));
    }

    public void registerUser(String id, String pass) {
        credentials.put(id, pass);
        balanceMap.put(id, 0); 
        transactionHistory.put(id, new ArrayList<>()); 
    }

    public int getBalance(String id) {
        return balanceMap.get(id);
    }

    public void updateBalance(String id, int newBalance) {
        balanceMap.put(id, newBalance);
    }

    public void addTransaction(String id, String transaction) {
        ArrayList<String> history = transactionHistory.get(id);
        if (history.size() == 5) {
            history.remove(0);
        }
        history.add(transaction);
    }

    public ArrayList<String> getTransactionHistory(String id) {
        return transactionHistory.get(id);
    }
}
