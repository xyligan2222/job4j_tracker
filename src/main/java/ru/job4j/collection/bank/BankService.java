package ru.job4j.collection.bank;



import java.util.*;
import java.util.stream.Collectors;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public boolean addUser(User user) {
        boolean rsl = false;
        if (users.putIfAbsent(user, new ArrayList<Account>()) == null) {
            rsl = true;
        }
        return rsl;
    }

    public void addAccount(String passport, Account account) {
        List<Account> accountList = users.get(findByPassport(passport));
            if (!accountList.contains(account)) {
                accountList.add(account);
        }
    }

    public User findByPassport(String passport) {
        Set<User> findPass = users.keySet();
        return findPass.stream().distinct().filter(x -> x.getPassport().equals(passport)).findAny().orElse(null);
    }

    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            rsl = accounts.stream().distinct().filter(x -> x.getRequisite().equals(requisite)).findAny().orElse(null);
        }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String dеstRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, dеstRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() - amount >= 0 && srcAccount != null && destAccount != null) {
           srcAccount.setBalance(srcAccount.getBalance() - amount);
           destAccount.setBalance(destAccount.getBalance() + amount);
           rsl = true;
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        String requisite = "3fdsbb9";
        accounts.add(new Account("3fdsbb9", 140));
        int index = accounts.indexOf(new Account(requisite, -1));
        Account find = accounts.get(index);
        System.out.println(find.getRequisite() + " -> " + find.getBalance());
    }
}