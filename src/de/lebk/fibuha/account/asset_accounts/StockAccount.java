package de.lebk.fibuha.account.asset_accounts;

import de.lebk.fibuha.account.Account;

/**
 * @author sopaetzel
 */
abstract class StockAccount extends Account{

    protected double openingBalance;

    public StockAccount(int accountNumber, String accountDescription, double openingBalance) {
        super(accountNumber, accountDescription);
        this.openingBalance = openingBalance;
    }

    public double getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(double openingBalance) {
        this.openingBalance = openingBalance;
    }
}
