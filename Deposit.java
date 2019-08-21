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
// Deposit.java
// Represents a deposit ATM transaction
public class Deposit extends Transaction
{
    private double amount; // amount to deposit
    private Keypad keypad; // reference to keypad
    private DepositSlot depositSlot; // reference to deposit slot
    private final static int CANCELED = 0; // constant for cancel option
    
    // Deposit constructor
    public Deposit( int userAccountNumber, Screen atmScreen,
            BankDatabase atmBankDatabase, Keypad atmKeypad,
            DepositSlot atmDepositSlot )
    {
        // initialize superclass variables
        super( userAccountNumber, atmScreen, atmBankDatabase );
        
        // initialize reference to keypad and deposit slot
        keypad = atmKeypad;
        depositSlot = atmDepositSlot;
    } // end Deposit constructor
    
    // perform transaction
    @Override
    public void execute()
    {
        BankDatabase bankDatabase = getBankDatabase(); // get reference
        Screen screen = getScreen(); // get reference
        
        amount = promptForDepositAmount(); // get deposit amount from user
        
        // check whether user entered a deposit amount or canceled
        if ( amount != CANCELED )
        {
            // request deposit envelop containing specified amount
            screen.displayMessage( "\nPlease insert a deposit envelop containing ");
            screen.displayDollarAmount( amount );
            screen.displayMessageLine( ".");
            
            // receive deposit envelop
            boolean envelopeReceived = depositSlot.isEnvelopeReceived();
            
            // check whether deposit envelope was received
            if ( envelopeReceived )
            {
                screen.displayMessageLine( "\nYour envelop has been received."
                        + "\nNote: The money just deposited will not " +
                        "be available until we verify the amount of any " +
                         "enclosed cash and your checks clear." );
            } // end if
            else // deposit envelop not received
            {
                screen.displayMessageLine( "\nYou did not insert an" +
                        "envelope, so the ATM has canceled your transaction." );
            } // end else
            {
                screen.displayMessageLine( "\nCanceling transaction...");
        } // end else
    } // end method execute
        
        // prompt the user to enter a deposit amount in cents
        private double promptForDepositAmount()
        {
            Screen screen = getScreen(); // get reference to screen
            
            // display the prompt
            screen.displayMessage( "\nPlease enter a deposit amount in " +
                    "CENTS (or 0 to cancel): ");
            int input = keypad.getInput(); // receive input of deposit amount
            if ( input == CANCELED )
                return CANCELED;
            else
            {
                return ( double ) input / 100; // return dollar amount
            } // end else
        } // end method promptForDepositAmount
} // end class Deposit
            
        