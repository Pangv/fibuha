package de.lebk.fibuha.dao;

import de.lebk.fibuha.account.Account;
import de.lebk.fibuha.account.asset_accounts.AssetAccount;
import de.lebk.fibuha.account.asset_accounts.LiabilityAccount;
import de.lebk.fibuha.account.profit_loss_accounts.ExpenseAccount;
import de.lebk.fibuha.account.profit_loss_accounts.RevenueAccount;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataAccessObject {
    private static DataAccessObject ourInstance = new DataAccessObject();

    public static DataAccessObject getInstance() {
        return ourInstance;
    }

    private DataAccessObject() {
    }

    private static List<Account> accountList = new ArrayList<>();


    public Account searchAccount(int accountNumber) {

        Iterator<Account> accountIterator = accountList.iterator();
        Account account;
        while (accountIterator.hasNext()) {
            account = accountIterator.next();
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }

        return null;
    }


    public void removeAccount(int accountNumber) {
        Iterator<Account> accountIterator = accountList.iterator();
        Account account;

        while (accountIterator.hasNext()) {
            account = accountIterator.next();
            if (account.getAccountNumber() == accountNumber) {
                accountIterator.remove();
            } else {
                System.out.println("Konto wurde nicht gefunden");
            }
        }

    }

    public void addAccount(int accountNumber, String accountDescription) {
        if (accountNumber >= 0 && accountNumber <= 2999) {
            accountList.add(new AssetAccount(accountNumber, accountDescription, 0.0));
        } else if (accountNumber >= 3000 && accountNumber <= 4999) {
            accountList.add(new LiabilityAccount(accountNumber, accountDescription, 0.0));
        } else if (accountNumber >= 5000 && accountNumber <= 5999) {
            accountList.add(new RevenueAccount(accountNumber, accountDescription));
        } else if (accountNumber >= 6000 && accountNumber <= 7999) {
            accountList.add(new ExpenseAccount(accountNumber, accountDescription));
        } else {
            System.err.println("Kontotyp nicht bekannt");
        }
    }

    public List<Account> getAccountList() {
        return accountList;
    }
}
