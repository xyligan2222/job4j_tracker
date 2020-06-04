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
        Optional<User> optUser = findByPassport(passport);
        if (optUser.isPresent() && !users.get(optUser.get()).contains(account)) {
            users.get(optUser.get()).add(account);
        }
    }

    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream().distinct().filter(x -> x.getPassport().equals(passport)).findAny();
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<Account> rsl = Optional.empty();
        Optional<User> optUser = findByPassport(passport);
        if (optUser.isPresent()) {
            rsl = users.get(optUser.get()).stream().distinct().filter(x -> x.getRequisite().equals(requisite)).findAny();
        }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent() && srcAccount.get().getBalance() - amount >= 0) {
           srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
           destAccount.get().setBalance(destAccount.get().getBalance() + amount);
           rsl = true;
        }
        return rsl;
    }

    public static void main(String[] args) {
        BankService bankService = new BankService();
        bankService.addUser(new User("3212", "Vania"));
        Optional<User> user = bankService.findByPassport("3232");
        if (user.isPresent()) {
            System.out.println(user.get().getUsername());
        }
    }
}