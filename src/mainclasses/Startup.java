package mainclasses;

import strategy.text.output.GuiOutputStrategy;
import data.access.FakeDatabase;

/**
 *
 * @author Dan
 */
public class Startup {

    public static void main(String[] args) {
        CashRegister cr = new CashRegister(new FakeDatabase());
        cr.setTextOutputStrategy(new GuiOutputStrategy());
        cr.startNewSale("bclementi1");
        cr.addProductToSale("A101", 10);
        cr.addProductToSale("B101", 5);
        cr.addProductToSale("C101", 2);
        cr.endSale();
    }
    
}
