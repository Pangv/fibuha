package de.lebk.fibuha.account;

/**
 * @author sopaetzel
 */
public abstract class Account {

    protected int accountNumber;
    protected String accountDescription;
    protected double sumDebitPosting; // Soll (Debt - Schulden)
    protected double sumCreditPosting; // Haben (Credit - Vermögen)

    public Account(int accountNumber, String accountDescription) {
        this.accountNumber = accountNumber;
        this.accountDescription = accountDescription;
    }

    @Override
    public String toString() {
        return String.valueOf(accountNumber);
    }

    public int compareTo(Account account){
        return 0;
    }

    public void postDebit(double value){

    }

    public void postCredit(double value){

    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountDescription() {
        return accountDescription;
    }



    public double getSumDebitPosting() {
        return sumDebitPosting;
    }

    public double getSumCreditPosting() {
        return sumCreditPosting;
    }

    public abstract double getAccountSum();
    public abstract double getBalance();
}
