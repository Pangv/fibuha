package de.lebk.fibuha.account.asset_accounts;

import de.lebk.fibuha.account.Account;

/**
 * @author sopaetzel
 */
public class AssetAccount extends StockAccount{

    public AssetAccount(int accountNumber, String accountDescription, double openingBalance) {
        super(accountNumber, accountDescription, openingBalance);
    }

    @Override
    public double getBalance() {
        return openingBalance + sumDebitPosting;

    }

    @Override
    public double getAccountSum() {
        return (openingBalance + sumDebitPosting) - sumCreditPosting;
    }

    @Override
    public int compareTo(Account account) {
        return ((Integer) accountNumber).compareTo(account.getAccountNumber());
    }

    @Override
    public void postCredit(double value) {
        sumCreditPosting += value;
    }

    @Override
    public void postDebit(double value) {
        sumDebitPosting += value;
    }

//    @Override
//    public String toString() {
//        String toReturn = "";
//        toReturn += String.format("%-33s %04d %-21s %15s\n", "Soll", accountNumber, accountDescription, "Haben");
//        toReturn += "──────────────────────────────────────┬──────────────────────────────────────\n";
//        toReturn += String.format("%-21s %,15.2f │%-21s %,15.2f\n", "Anfangsbestand", openingBalance, "Summe Habenbuchungen", sumCreditPosting);
//        toReturn += String.format("%-21s %,15.2f │%-21s %,15.2f\n", "Summe Sollbuchungen", sumDebitPosting, "Saldo", getBalance());
//        toReturn += "──────────────────────────────────────┼──────────────────────────────────────\n";
//        toReturn += String.format("%,37.2f │%,37.2f\n", getAccountSum(), getAccountSum());
//        toReturn += "══════════════════════════════════════╧══════════════════════════════════════\n";
//        toReturn += "\n\n";
//        return toReturn;
//    }


}
