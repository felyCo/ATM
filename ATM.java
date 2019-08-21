/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

/**
 *  * /**
 * (Starting to program the Classes of the ATM System)
 *      Incorporate inheritance into the design of the ATM.
 *      Incorporate polymorphism into the design of the ATM.
 *      Fully implement in Java the UML-based object-oriented design of the ATM software
 *      Detailed code walk-through of the ATM software system that explain the implementation issues.
 *
 **********************
 *  A   T   M         *
 **********************
 *      Class ATM
 *      Class Screen
 *      Class Keypad
 *      Class CashDispenser
 *      Class DepositSlot
 *      Class Account
 *      Class BankDatabase
 *      Class Transaction
 *      Class BalanceInquiry
 *      Class Withdrawal
 *      Class Deposit
 *      Class ATMCaseStudy
 * 
 * 
 *
 *
 * @author Administrator
 */
public class ATM {

    /**
     * @param args the command line arguments
     */
    
        private boolean userAuthenticated;//whether user is authenticated 
    private int currentAccountNumber;//current user account number
    private Screen screen;//ATM's screen
    private Keypad keypad;//ATM's keypad
    private CashDispenser cashDispenser;//ATM's cash despenser
    private DepositSlot depositSlot;//ATM's deposit slot
    private BankDatabase bankDatabase;//account information database
    
    //constants corresponding to main menu options
    private static final int BALANCE_INQUIRY = 1;
    private static final int WITHDRAWAL = 2;
    private static final int DEPOSIT = 3;
    private static final int EXIT = 4;
    
    //no-argument ATM constructor initializes instance variables
    public ATM()
    {
        
        userAuthenticated = false;//user is not authenticated to start
        currentAccountNumber = 0;//no current account number to start
        screen = new Screen();//create screen
        keypad = new Keypad();//create keypad
        cashDispenser = new CashDispenser();//create cash dispenser
        depositSlot = new DepositSlot();//create deposit slot
        bankDatabase = new BankDatabase();//create acct info database
        
    }//end no-argument ATM constructor
    
    //start ATM
    public void run()
    {
        // TODO code application logic here
        //welcome and authenticate user; perform transaction
        while ( true )
        {
            // loop while the user is not yet authenticated
            while ( !userAuthenticated )
            {
                screen.displayMessageLine("\nWelcome");
                authenticateUser();// authenticate user
            } // end while
            
            performTransactions(); // user is now authenticated
            userAuthenticated = false ; // reset before next ATM session
            currentAccountNumber = 0; // reset before next ATM session
            screen.displayMessageLine( "\nThank you ! Goodbye");
        } // end while
    } // end method run
    
    // attempts to authenticate user against database
    private void authenticateUser()
    {
     screen.displayMessage( "\nPlease enter your account number" );
     int accountNumber = keypad.getInput(); // input account number 
     screen.displayMessage( "\nEnter your PIN: "); // prompt for PIN
     int pin = keypad.getInput(); // input PIN
     
     // set userAuthenticated to boolean value returned by database
     userAuthenticated = bankDatabase.authenticaticateUser( accountNumber , pin );
     
     // check whether authentication succeeded
     if ( userAuthenticated )
     {
         currentAccountNumber = accountNumber;// save user's account #
     } // end if
     else 
         screen.displayMessageLine( "Invalid account number or PIN. Please try again.");
    } // end method authenticateUser
    
    // display the main menu and perform transactions
    private void performTransactions()
    {
        //local variable to store transactions currently being processed
        Transaction currentTransaction = null;
        
        boolean userExited = false;// user has not chosen to exit
        
        // loop while user has not chosen option to exit system
        while ( !userExited)
        {
            // show main and get user selection
            int mainMenuSelection = displayMainMenu();
            
            // decide how to proceed based on user's menu selection
            switch ( mainMenuSelection )
            {
                // user chose to perform one of three transaction types
                case BALANCE_INQUIRY:
                case WITHDRAWAL:
                case DEPOSIT:
                    
                    //initialize as new object chosen type
                    currentTransaction = createTransaction( mainMenuSelection );
                    
                    currentTransaction.execute(); // execute transaction
                    break;
                case EXIT: // user chose to terminate the session
                    screen.displayMessageLine( "\nExiting the system...");
                    userExited = true; // this ATM session should end
                    break;
            } // end switch
        } // end while
    } // end method performTransactions
    
    //display the main menu and return an input selection
    private int displayMainMenu()
    {
      screen.displayMessageLine( "\nMain menu:");  
       screen.displayMessageLine( "1 - View my balance");  
        screen.displayMessageLine( "2 - Withdraw cash");  
         screen.displayMessageLine( "3 - Deposit funds");  
          screen.displayMessageLine( "4 - Exit\n");
           screen.displayMessageLine( "Enter a choice:");
           return keypad.getInput(); // return user's selection
    } // end method displayMainMenu
    
    // return object of specific Transaction subclass
    private Transaction createTransaction( int type )
    {
        Transaction temp = null; // temporary Transaction variable
        
        // determine which type  of Transaction subclass
        switch ( type )
        {
            case BALANCE_INQUIRY: // create new BalanceInquiry transaction
                temp = new BalanceInquiry( currentAccountNumber , screen , bankDatabase );
                break;
            case WITHDRAWAL: // create new Withdrawal transaction
                temp = new Withdrawal( currentAccountNumber , screen , bankDatabase , keypad , cashDispenser );
                break;
            case DEPOSIT: //  create new Deposit transaction
                 temp = new Deposit( currentAccountNumber , screen , bankDatabase , keypad , depositSlot );
                 break;
         } // end switch 
    return temp; // return the newly created object
    } // end the method transaction
    
    
} // end class ATM


   
