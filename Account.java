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
// Account.java
 // Represents a bank account

public class Account {
    private int accountNumber; // account number
    private int pin; //PIN for authentication
    private double availableBalance; // funds available for withdrawal
    private double totalBalance; // funds available + pending deposits
    
    // Account constructor initializes attributes
    public Account( int theAccountNumber , int thePIN ,
            double theAvailableBalance , double theTotalBalance )
    {
        accountNumber = theAccountNumber;
        pin = thePIN;
        availableBalance = theAvailableBalance;
        totalBalance = theTotalBalance;
    } // end Account constructor
    
    // determines whether a user-specific PIN matches PIN in Account
    public boolean validatePIN( int userPIN )
    {
        if ( userPIN == pin )
            return true;
        else
            return false;
    } // end method validatePIN
    
    // returns available balance
    public double getAvailableBalance()
    {
        return availableBalance;
    } // end getAvailableBalance
    
    // returns the total balance
    public double getTotalBalance()
    {
        return totalBalance;
    } // end method getTotalBalance
    
    // credit an amount to the account
    public void credit( double amount )
    {
        totalBalance += amount; // add to total balance
    } // end method credit
    
    // returns account number
    public int getAccountNumber()
    {
        return accountNumber;
    } // end method getAccountNumber 

    void debit(double amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
} // end class Account

