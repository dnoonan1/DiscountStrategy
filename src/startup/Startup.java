package startup;

import data.access.FakeDatabase;
import strategy.lineitem.format.KohlsLineItemFormatStrategy1;
import strategy.receipt.format.*;
import strategy.text.output.*;

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
        cr.setTextOutputStrategy(new ConsoleOutputStrategy());
        // Set the ReceiptFormatter
        cr.setFormatter(
            // ReceiptFormatter...
            new ReceiptFormatter(
                // ...requires a ReceiptFormatStrategy
                new KohlsReceiptFormatStrategy1(
                    // ...requires a LineItemFormatStrategy 
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
        cr.addProductToSale("D101", 1);
        // End sale and print receipt
        cr.endSale();
    }
    
}
