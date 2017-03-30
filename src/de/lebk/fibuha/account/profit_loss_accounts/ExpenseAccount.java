package de.lebk.fibuha.account.profit_loss_accounts;

/**
 * @author sopaetzel
 */
public class ExpenseAccount extends ProfitLossAccount{


    public ExpenseAccount(int accountNumber, String accountDescription) {
        super(accountNumber, accountDescription);
    }

    @Override
    public String toScreen() {
        return super.toScreen();
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
