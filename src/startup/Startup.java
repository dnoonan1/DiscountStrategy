package startup;

import data.access.FakeDatabase;
import strategy.lineitem.format.KohlsLineItemFormatStrategy1;
import strategy.receipt.format.*;
import strategy.text.output.*;

/**
 *
 * @author Dan
 */
public class Startup {

    public static void main(String[] args) {
        CashRegister cr = new CashRegister(new FakeDatabase());
        cr.setTextOutputStrategy(new GuiOutputStrategy());
        cr.setFormatter(
            new ReceiptFormatter(
                new KohlsReceiptFormatStrategy1(
                    new KohlsLineItemFormatStrategy1()
                )
            )
        );
        cr.startNewSale("bclementi1");
        cr.addProductToSale("A101", 10);
        cr.addProductToSale("B101", 5);
        cr.addProductToSale("C101", 2);
        cr.endSale();
    }
    
}
