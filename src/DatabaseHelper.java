import java.sql.*;

public class DatabaseHelper {

    private static final String URL = "jdbc:mysql://localhost:3306/banking_system";
    private static final String USER = "root";
    private static final String PASSWORD = "password";  // Replace with your actual MySQL password

    // Establish connection to the database
    public Connection connect() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Create a new account
    public void createAccount(String name, double initialDeposit) {
        String query = "INSERT INTO Accounts (account_holder, balance) VALUES (?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setDouble(2, initialDeposit);
            stmt.executeUpdate();
            System.out.println("Account created successfully with balance: " + initialDeposit);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Deposit money to an account
    public void depositMoney(int accountId, double depositAmount) {
        String query = "UPDATE Accounts SET balance = balance + ? WHERE account_id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDouble(1, depositAmount);
            stmt.setInt(2, accountId);
            stmt.executeUpdate();
            System.out.println("Deposited " + depositAmount + " to account " + accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Withdraw money from an account
    public void withdrawMoney(int accountId, double withdrawalAmount) {
        String query = "UPDATE Accounts SET balance = balance - ? WHERE account_id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDouble(1, withdrawalAmount);
            stmt.setInt(2, accountId);
            stmt.executeUpdate();
            System.out.println("Withdrew " + withdrawalAmount + " from account " + accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Check account balance
    public void checkBalance(int accountId) {
        String query = "SELECT balance FROM Accounts WHERE account_id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, accountId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                double balance = rs.getDouble("balance");
                System.out.println("Account balance: " + balance);
            } else {
                System.out.println("Account not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
