/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

/**
 *
 * @author Administrator
 */
// BankDatabase.java
 // Represents the bank account information database

public class BankDatabase {
    
    private Account[] accounts; // array of Accounts
    // no-argument BankDatabdase constructor initializes account
    public BankDatabase()
    {
        accounts = new Account[ 2 ]; // just 2 accounts for testing
        accounts[ 0 ] = new Account( 12345, 54321, 1000.0, 1200.0 );
        accounts[ 1 ] = new Account( 98765, 56789, 200.0, 200.0 );
    } // end no-argument BankDatabase constructor
    
    
    // retrieve Account object containing specific account number
    private Account getAccount( int accountNumber )
    {
        // loop through account searching for matching account number
        for ( Account currentAccount : accounts )
        {
            // return current account if match found
            if ( currentAccount.getAccountNumber() == accountNumber )
                return currentAccount;
        } // end for
        
        return null; // if no matching account was found, return null
    } // end method getAccount
    
    // determine whether user-specified account number and PIN match
    // those of an account in the database
    public boolean authenticaticateUser( int userAccountNumber, int userPIN )
    {
        // attempt to retrieve the account with the account number
        Account userAccount = getAccount( userAccountNumber );
        
        // if account exists, return result of Account method validatePIN
        if ( userAccount != null )
            return userAccount.validatePIN(  userPIN );
        else
            return false; // account number not found, so return false
    } // end method authenticateUser
    
    // return available balance of Account with specified account number
    public double getAvailableBalance( int userAccountNumber )
    {
        return getAccount( userAccountNumber ).getAvailableBalance();
    } // end method getAvailableBalance
    
    // return total balance of Account with specified account number
    public double getTotalBalance( int userAccountNumber )
    {
        return getAccount( userAccountNumber ).getTotalBalance();
    } // end method getTotalBalance
    
    // credit an amount to Account with specified account number
    public void credit( int userAccountNumber, double amount )
    {
        getAccount( userAccountNumber ).credit( amount );
    } // end method credit
    
    // debit an amount from Account with specified account number
    public void debit( int userAccountNumber, double amount )
    {
        getAccount( userAccountNumber ).debit( amount );
    } // end method debit
    
} // end class BankDatabase