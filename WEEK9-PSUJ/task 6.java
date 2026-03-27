import java.util.*;

class Account {
    private int accountNumber;
    private String holderName;
    private double balance;

    public Account(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public int getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            this.balance -= amount;
            return true;
        }
        return false;
    }
}

class Bank {
    private Map<Integer, Account> accounts = new HashMap<>();

    public void addAccount(Account acc) {
        accounts.put(acc.getAccountNumber(), acc);
    }

    public void processOperation(String command, Scanner sc) {
        switch (command) {
            case "DEPOSIT":
                int depAccNum = sc.nextInt();
                double depAmt = sc.nextDouble();
                Account depAcc = accounts.get(depAccNum);
                if (depAcc != null) {
                    depAcc.deposit(depAmt);
                    System.out.println("Deposited " + (int)depAmt + " to " + depAcc.getHolderName());
                } else {
                    System.out.println("Account not found");
                }
                break;

            case "WITHDRAW":
                int witAccNum = sc.nextInt();
                double witAmt = sc.nextDouble();
                Account witAcc = accounts.get(witAccNum);
                if (witAcc != null) {
                    if (witAcc.withdraw(witAmt)) {
                        System.out.println("Withdrawn " + (int)witAmt + " from " + witAcc.getHolderName());
                    } else {
                        System.out.println("Insufficient balance");
                    }
                } else {
                    System.out.println("Account not found");
                }
                break;

            case "TRANSFER":
                int fromNum = sc.nextInt();
                int toNum = sc.nextInt();
                double transAmt = sc.nextDouble();
                Account fromAcc = accounts.get(fromNum);
                Account toAcc = accounts.get(toNum);

                if (fromAcc == null || toAcc == null) {
                    System.out.println("Account not found");
                } else if (fromAcc.withdraw(transAmt)) {
                    toAcc.deposit(transAmt);
                    System.out.println("Transferred " + (int)transAmt + " from " + fromAcc.getHolderName() + " to " + toAcc.getHolderName());
                } else {
                    System.out.println("Insufficient balance");
                }
                break;
        }
    }
}

public class ACT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        // Initialize Accounts
        int numAccounts = sc.nextInt();
        for (int i = 0; i < numAccounts; i++) {
            bank.addAccount(new Account(sc.nextInt(), sc.next(), sc.nextDouble()));
        }

        // Process Operations
        int numOps = sc.nextInt();
        for (int i = 0; i < numOps; i++) {
            String command = sc.next();
            bank.processOperation(command, sc);
        }
        sc.close();
    }
}
