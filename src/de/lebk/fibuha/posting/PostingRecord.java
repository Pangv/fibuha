package de.lebk.fibuha.posting;

import de.lebk.fibuha.account.Account;

/**
 * @author sopaetzel
 */
public class PostingRecord {
    private Account debitAccount;
    private Account creditAccount;
    private double postingValue;

    public String executePosting(){
        String toReturn = "";
        return toReturn;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
