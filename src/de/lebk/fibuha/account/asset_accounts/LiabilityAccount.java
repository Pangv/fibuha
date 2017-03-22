package de.lebk.fibuha.account.asset_accounts;

/**
 * @author sopaetzel
 */
public class LiabilityAccount extends StockAccount{

    public LiabilityAccount(int accountNumber, String accountDescription, double openingBalance) {
        super(accountNumber, accountDescription, openingBalance);
    }

    @Override
    public double getAccountSum() {
        return 0;
    }

    @Override
    public double getBalance() {
        return 0;
    }
}
