/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

/**
 *
 * CashDispenser.java
 * Represents the cash dispenser of the ATM
 * 
 * @author Administrator
 */
public class CashDispenser {
    // the default initial number of bills in the cash dispenser
    private final static int INITIAL_COUNT = 500;
    private int count;// number of $20 bills remaining
    
    // no-argument CashDispenser constructor initializes count to default
    public CashDispenser()
    {
        count = INITIAL_COUNT; // set count attribute to default
    } // end CashDispenser constructor
    
    // simutates dispensing of specific amount of cash
    public void dispenseCash ( int amount )
    {
        int billsRequired = amount / 20 ; // number of bills required
        count -= billsRequired; // update the count of bills
    } // end method dispenseCash
    
    // indicates whether cash dispenser can dispenser desired amount
    public boolean isSufficientCashAvailable( int amount )
    {
        int billsRequired = amount / 20; // number of $20 bills required
        
        if ( count >= billsRequired )
            return true;// enough bills available
        else 
            return false; // not enough bills available
    } // end method isSufficientCashAvailable
    
} //end class CashDispense
