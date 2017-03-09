package de.lebk.fibuha.account;

/**
 * @author sopaetzel
 */
public abstract class Account {

    protected int accountNumber;
    protected String accountDescription;
    protected double sumDebitPosting;
    protected double sumCreditPosting;


    @Override
    public String toString() {
        return super.toString();
    }

    public int compareTo(Account account){
        return 0;
    }

    public void postDebit(double value){

    }

    public void postCredit(double value){

    }

    public abstract double getAccountSum();
    public abstract double getBalance();
}
