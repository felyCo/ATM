
package atm;

/**
 *
 * @author Felix
 */
// DepositSlot.java
// Represents the deposit slot of the ATM
public class DepositSlot {
    
    // indicates whether envelop was received (always returns true,
    // because this is only a software simulation of a real deposit slot)
    public boolean isEnvelopeReceived()
    {
        return true; // deposit envelop was received
    } // end method isEnvelopeReceived
    
} // end class DepositSlot

