package de.lebk.fibuha.posting;

import de.lebk.fibuha.account.Account;

/**
 * @author sopaetzel
 */
public class PostingRecord {
    private Account debitAccount;
    private Account creditAccount;
    private double postingValue;

    public PostingRecord(Account debitAccount, Account creditAccount, String postingValueString) {
        this.debitAccount = debitAccount;
        this.creditAccount = creditAccount;
        this.postingValue = evaluatePosting(postingValueString);
    }

    public String executePosting(){
        String toReturn;

        if (creditAccount.getBalance() >= postingValue){
            debitAccount.postDebit(postingValue);
            creditAccount.postCredit(postingValue);
            toReturn = "Die Buchung wurde durchgeführt";
        }else {
            toReturn = "Die Buchung konnte nicht durchgeführt werden,\n"
                    + "da der Buchungsbetrag den verfügbaren Saldo\n"
                    + "um " + String.format("%,.2f", postingValue - creditAccount.getBalance()) + " € überschreitet.";
        }
        return toReturn;
    }

    @Override
    public String toString() {
        String toReturn;
        toReturn = String.format("%04d %-18s an %04d %-18s %,15.2f\n",
                debitAccount.getAccountNumber(), debitAccount.getAccountDescription(),
                creditAccount.getAccountNumber(), creditAccount.getAccountDescription(), postingValue);
       return toReturn;
    }


    public double evaluatePosting(String postingValueString){
        if (postingValueString.contains(",")){
            postingValueString = postingValueString.replace(',', '.');
        }
        postingValue = Double.parseDouble(postingValueString);
        return postingValue;
    }
}
