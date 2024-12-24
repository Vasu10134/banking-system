import java.util.Scanner;

public class BankingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseHelper dbHelper = new DatabaseHelper();

        System.out.println("Welcome to the Banking System!");
        
        // Menu
        while (true) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 1) {
                // Create Account
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();
                System.out.print("Enter initial deposit amount: ");
                double initialDeposit = scanner.nextDouble();
                dbHelper.createAccount(name, initialDeposit);
            } else if (choice == 2) {
                // Deposit Money
                System.out.print("Enter account ID: ");
                int accountId = scanner.nextInt();
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                dbHelper.depositMoney(accountId, depositAmount);
            } else if (choice == 3) {
                // Withdraw Money
                System.out.print("Enter account ID: ");
                int accountId = scanner.nextInt();
                System.out.print("Enter withdrawal amount: ");
                double withdrawalAmount = scanner.nextDouble();
                dbHelper.withdrawMoney(accountId, withdrawalAmount);
            } else if (choice == 4) {
                // Check Balance
                System.out.print("Enter account ID: ");
                int accountId = scanner.nextInt();
                dbHelper.checkBalance(accountId);
            } else if (choice == 5) {
                // Exit
                System.out.println("Thank you for using the Banking System!");
                break;
            } else {
                System.out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close();
    }
}
