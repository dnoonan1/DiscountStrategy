package discountstrategy;

/**
 *
 * @author Dan
 */
public class Startup {

    public static void main(String[] args) {
        CashRegister cr = new CashRegister(new FakeDatabase());
        Receipt r;
        cr.startNewSale("bclementi1");
        cr.addProductToSale("A101", 10);
        cr.addProductToSale("B101", 5);
        cr.addProductToSale("C101", 2);
        r = cr.getReceipt();
        System.out.println(r);
    }
    
}
