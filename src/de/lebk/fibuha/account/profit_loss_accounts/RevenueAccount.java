package de.lebk.fibuha.account.profit_loss_accounts;

/**
 * @author sopaetzel
 */
public class RevenueAccount extends ProfitLossAccount{

    public RevenueAccount(int accountNumber, String accountDescription) {
        super(accountNumber, accountDescription);
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
