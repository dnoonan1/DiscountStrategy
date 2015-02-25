package discountstrategy;

/**
 *
 * @author dnoonan1
 */
public class CashRegister {
    
    private ReceiptDataAccessStrategy db;
    private Customer currentCustomer; // may not need this
    private Receipt receipt;

    public CashRegister() {}
    
    public CashRegister(ReceiptDataAccessStrategy db) {
        setDatabase(db);
    }
    
    public void setDatabase(ReceiptDataAccessStrategy db) {
        this.db = db;
    }
    
    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public final void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

    public final Receipt getReceipt() {
        return receipt;
    }

    public void startNewSale(String custId) {
        // find customer in database
        Customer c = db.findCustomer(custId);
        if (c == null) {
            throw new IllegalArgumentException("Customer not found in database."
                    + " Cannot begin sale.");
        }
        setCurrentCustomer(c); // may not need this
        receipt = new Receipt(c);
    }
    
    public void addProductToSale(String prodId, int qty) {
        // find product in database
        Product p = db.findProduct(prodId);
        if (p == null) {
            throw new IllegalArgumentException("Product not found in database."
                    + " Cannot add to sale.");
        }
        //System.out.println("Adding product " + p.getProdId() + " to sale.");
        receipt.addLineItem(new LineItem(p, qty));
    }
    
    public void endSale() {
        // not sure what goes here
    }
    
}
