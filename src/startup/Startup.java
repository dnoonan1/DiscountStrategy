package startup;

import strategy.output.text.*;
import strategy.format.receipt.*;
import strategy.dataaccess.FakeDatabase;
import strategy.format.lineitem.KohlsLineItemFormatStrategy1;

/**
 * Startup tests the Kohl's Point-of-Sale system.
 * 
 * @author Dan Noonan
 * @version 1.0
 */
public class Startup {

    public static void main(String[] args) {
        // Create a cash register
        CashRegister cr = new CashRegister(new FakeDatabase());
        // Set its output
        cr.setTextOutputStrategy(new GuiOutputStrategy());
        // Set the ReceiptFormatter
        cr.setFormatter(
            // ReceiptFormatter...
            new ReceiptFormatter(
                // ...requires a ReceiptFormatStrategy
                new KohlsReceiptFormatStrategy1(
                    // ...which requires a LineItemFormatStrategy 
                    new KohlsLineItemFormatStrategy1()
                )
            )
        );
        // Start a new sale for Bob Clementi
        cr.startNewSale("bclementi1");
        // Add four products
        cr.addProductToSale("A101", 10);
        cr.addProductToSale("B101", 5);
        cr.addProductToSale("C101", 2);
        cr.addProductToSale("D102", 1); // invalid product - will be ignored
        // End sale and print receipt
        cr.endSale();
    }
    
}
