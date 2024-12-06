package bankApp;

public class Login {
    private User user = new User();

    public boolean checkLog(String id, String pass) {
        if (user.isValidUser(id) && user.checkPassword(id, pass)) {
            System.out.println("Login Successful");
            return true;
        }
        System.out.println("Invalid ID or Password");
        return false;
    }

    public void registerUser(String id, String pass) {
        if (!user.isValidUser(id)) {
            user.registerUser(id, pass);
            System.out.println("Registration Successful");
        } else {
            System.out.println("ID already registered");
        }
    }

    public void checkBalance(String id) {
        System.out.println("Current Balance: " + user.getBalance(id) + " Rs.");
    }

    public void depositAmount(String id, int amount) {
        int currentBalance = user.getBalance(id);
        user.updateBalance(id, currentBalance + amount);
        user.addTransaction(id, "Deposited " + amount + " Rs.");
        System.out.println("Transaction Successful. New Balance: " + user.getBalance(id) + " Rs.");
    }

    public void withdrawAmount(String id, int amount) {
        int currentBalance = user.getBalance(id);
        if (amount <= currentBalance) {
            user.updateBalance(id, currentBalance - amount);
            user.addTransaction(id, "Withdrew " + amount + " Rs.");
            System.out.println("Transaction Successful. New Balance: " + user.getBalance(id) + " Rs.");
        } else {
            System.out.println("Insufficient Balance.");
        }
    }

    public void miniStatement(String id) {
        System.out.println("Mini Statement:");
        for (String transaction : user.getTransactionHistory(id)) {
            System.out.println(transaction);
        }
    }
}
