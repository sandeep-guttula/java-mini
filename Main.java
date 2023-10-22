import java.util.Scanner;

class Account {
     private String accountNumber;
     private String pin;
     private double balance;

     public Account(String accountNumber, String pin) {
          this.accountNumber = accountNumber;
          this.pin = pin;
          this.balance = 0.0;
     }

     public boolean validatePin(String enteredPin) {
          return pin.equals(enteredPin);
     }

     public double getBalance() {
          return balance;
     }

     public void deposit(double amount) {
          balance += amount;
     }

     public boolean withdraw(double amount) {
          if (amount > 0 && amount <= balance) {
               balance -= amount;
               return true;
          }
          return false;
     }
}

public class Main {
     public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);

          // Simulate a bank with one account for this example
          Account account = new Account("123456", "1234");

          // Main ATM menu
          while (true) {
               System.out.println("Welcome to the ATM");
               System.out.println("1. Check Balance");
               System.out.println("2. Deposit");
               System.out.println("3. Withdraw");
               System.out.println("4. Exit");
               System.out.print("Select an option: ");

               int option = scanner.nextInt();

               switch (option) {
                    case 1:
                         System.out.println("Balance: $" + account.getBalance());
                         break;
                    case 2:
                         System.out.print("Enter the amount to deposit: $");
                         double depositAmount = scanner.nextDouble();
                         account.deposit(depositAmount);
                         System.out.println("Deposited $" + depositAmount);
                         break;
                    case 3:
                         System.out.print("Enter the amount to withdraw: $");
                         double withdrawAmount = scanner.nextDouble();
                         if (account.withdraw(withdrawAmount)) {
                              System.out.println("Withdrawn $" + withdrawAmount);
                         } else {
                              System.out.println("Insufficient funds or invalid amount");
                         }
                         break;
                    case 4:
                         System.out.println("Thank you for using the ATM. Goodbye!");
                         System.exit(0);
                    default:
                         System.out.println("Invalid option. Please try again.");
               }
          }
     }
}
