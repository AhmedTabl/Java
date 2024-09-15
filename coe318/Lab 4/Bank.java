/**
 *
 * @author Ahmed Tabl
 */

public class Bank {
    private String name;
    /**
     * An array of Accounts managed by
     * this bank.
     */
    private Account [] accounts;
    private int numAccounts;//number of active accounts

    public Bank(String name, int maxNumberAccounts) {
        this.name = name;
        accounts = new Account[maxNumberAccounts];
        numAccounts = 0;
    }


    /**
     * @return the name
     */
    public String getName() {
        return this.name;  //Fix this
    }

    /**
     * @return the numAccounts
     */
    public int getNumAccounts() {
        return this.numAccounts; //Fix this
    }


    public Account[] getAccounts() {
        return this.accounts; //Fix this
    }

    /**
     * Return true if the Bank already has an account
     * with this number; otherwise false.
     * @param accountNumber
     * @return
     */
    public boolean hasAccountNumber(int accountNumber) {
        
        for(int i  =0; i < this.numAccounts; i++){
            
            if(this.accounts[i].getNumber() == accountNumber){
                
                return true;
            }
            
        }
        
         return false;
    }

    /**
     * Adds the specified account to the Bank if possible. If the account number
     * already exists or the Bank has reached its maximum
     * number of accounts, return false and do not add it; otherwise,
     * add it and return true.
     * @param account
     * @return true if successful
     */
    public boolean add(Account account) {
    // Check if the bank has reached its maximum number of accounts
    if (this.numAccounts >= this.accounts.length) {
        return false; // Bank is full, cannot add more accounts
    }

    // Check if the account number already exists
    for (int i = 0; i < this.numAccounts; i++) {
        if (this.accounts[i].getNumber() == account.getNumber()) {
            return false; // Account with the same number already exists
        }
    }

    // Find a free spot in the array and add the account
    for (int i = 0; i < this.accounts.length; i++) {
        if (this.accounts[i] == null) {
            this.accounts[i] = account;
            this.numAccounts++;
            return true;
        }
    }

    return false; // This should not be reached if the bank is properly managed
}


    @Override
    public String toString() {
        //DO NOT MODIFY THIS CODE
        String s = getName() + ": " + getNumAccounts() +
                " of " + getAccounts().length +
                " accounts open";
        for(Account account : getAccounts()) {
            if (account == null) break;
            s += "\n  " + account;
        }
        return s;
    }
}
