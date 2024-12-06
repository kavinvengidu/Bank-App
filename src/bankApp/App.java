package bankApp;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Login log = new Login();
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to XXX Bank App!");
        while (true) {
            System.out.println("\nEnter the option number:");
            System.out.println("1. Login");
            System.out.println("2. Register");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the Login ID:");
                    String id = sc.next();
                    System.out.println("Enter the Password:");
                    String pass = sc.next();

                    if (log.checkLog(id, pass)) {
                        String user = id;
                        System.out.println("\nWelcome " + user);

                        boolean loggedIn = true;
                        while (loggedIn) {
                            System.out.println("\nSelect the Option:");
                            System.out.println("1. Balance Inquiry");
                            System.out.println("2. Amount Withdrawal");
                            System.out.println("3. Amount Deposit");
                            System.out.println("4. Mini Statement");
                            System.out.println("5. Logout");

                            int ch = sc.nextInt();
                            switch (ch) {
                                case 1:
                                    log.checkBalance(user);
                                    break;
                                case 2:
                                    System.out.println("Enter withdrawal amount:");
                                    int withdrawAmount = sc.nextInt();
                                    log.withdrawAmount(user, withdrawAmount);
                                    break;
                                case 3:
                                    System.out.println("Enter deposit amount:");
                                    int depositAmount = sc.nextInt();
                                    log.depositAmount(user, depositAmount);
                                    break;
                                case 4:
                                    log.miniStatement(user);
                                    break;
                                case 5:
                                    loggedIn = false;
                                    System.out.println("Logged out successfully.");
                                    break;
                                default:
                                    System.out.println("Enter a valid option.");
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("Enter a new ID:");
                    String newId = sc.next();
                    System.out.println("Enter a Password:");
                    String newPass = sc.next();
                    log.registerUser(newId, newPass);
                    break;
                default:
                    System.out.println("Enter a valid option.");
            }
        }
    }
}
