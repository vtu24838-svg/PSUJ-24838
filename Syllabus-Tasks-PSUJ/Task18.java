import java.util.*;

class Account {
    int accNo;
    String name;
    int balance;

    Account(int accNo, String name, int balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }
}

class Bank {
    HashMap<Integer, Account> map = new HashMap<>();

    void addAccount(Account a) {
        map.put(a.accNo, a);
    }

    void deposit(int accNo, int amt) {
        if (!map.containsKey(accNo)) {
            System.out.println("Account not found");
            return;
        }
        Account a = map.get(accNo);
        a.balance += amt;
        System.out.println("Deposited " + amt + " to " + a.name);
    }

    void withdraw(int accNo, int amt) {
        if (!map.containsKey(accNo)) {
            System.out.println("Account not found");
            return;
        }
        Account a = map.get(accNo);
        if (a.balance < amt) {
            System.out.println("Insufficient balance");
        } else {
            a.balance -= amt;
            System.out.println("Withdrawn " + amt + " from " + a.name);
        }
    }

    void transfer(int from, int to, int amt) {
        if (!map.containsKey(from) || !map.containsKey(to)) {
            System.out.println("Account not found");
            return;
        }

        Account a = map.get(from);
        Account b = map.get(to);

        if (a.balance < amt) {
            System.out.println("Insufficient balance");
        } else {
            a.balance -= amt;
            b.balance += amt;
            System.out.println("Transferred " + amt + " from " + a.name + " to " + b.name);
        }
    }
}

public class task18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Bank bank = new Bank();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            int bal = sc.nextInt();
            bank.addAccount(new Account(id, name, bal));
        }

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            String op = sc.next();

            if (op.equals("DEPOSIT")) {
                bank.deposit(sc.nextInt(), sc.nextInt());
            } else if (op.equals("WITHDRAW")) {
                bank.withdraw(sc.nextInt(), sc.nextInt());
            } else {
                bank.transfer(sc.nextInt(), sc.nextInt(), sc.nextInt());
            }
        }
    }
}
