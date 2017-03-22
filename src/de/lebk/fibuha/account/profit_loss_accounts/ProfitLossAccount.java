package de.lebk.fibuha.account.profit_loss_accounts;

import de.lebk.fibuha.account.Account;

/**
 * @author sopaetzel
 */
abstract class ProfitLossAccount  extends Account{

    public ProfitLossAccount(int accountNumber, String accountDescription) {
        super(accountNumber, accountDescription);
    }
}
