package startup;

import strategy.dataaccess.*;
import strategy.format.receipt.ReceiptFormatter;

/**
 *
 * @author Dan Noonan
 * @version 1.0
 */
public class Receipt {

    private static final int INITIAL_CAPACITY = 8;
    
    private ReceiptDataAccessStrategy db;
    private final Customer customer;
    
    private LineItem[] lineItems; // Bad way to do this - violates
    private int lineCount;        // encapsulation. These two fields should be
                                  // be stored in their own class. Not doing so
                                  // creates problems elswhere in the project.
    
    public Receipt(ReceiptDataAccessStrategy db, String custId)
            throws CustomerNotFoundException {
        
        Customer c;
        this.db = db;
        
        // Iniialize array of LineItems
        this.lineItems = new LineItem[INITIAL_CAPACITY];
        
        // If customer doesn't exist in database, the following line will throw
        // a CustomerNotFoundException
        c = db.findCustomer(custId);
        
        this.customer = c;
        
    }

    public Customer getCustomer() {
        return customer;
    }

    public LineItem[] getLineItems() {
        return lineItems;
    }
    
    public void addLineItem(String prodId, int qty)
            throws ProductNotFoundException {
        LineItem li;
        
        // If lineItems is full, resize it
        if (lineCount >= lineItems.length) {
            resizeLineItems();
        }
        
        // If the Product isn't found in the database, the following line will
        // thrown a ProductNotFoundException
        li = new LineItem(db, prodId, qty);
        lineItems[lineCount++] = li;
        
    }
    
    private void resizeLineItems() {
        LineItem[] resized = new LineItem[2 * lineItems.length];
        for (int i = 0; i < lineCount; i++) { // Careful here - cannot use
            resized[i] = lineItems[i];        // i < lineItems.length because
        }                                     // lineItems is partially filled.
        lineItems = resized;                  // See comments in Receipt about
    }                                         // encapsulation.
    
    public double getTotal() {
        double total = 0.0;
        for (int i = 0; i < lineCount; i++) { // Above comments apply here too
            total += lineItems[i].getSubtotal();
        }
        return total;
    }
    
    public double getTotalDiscount() {
        double totalDiscount = 0.0;
        for (int i = 0; i < lineCount; i++) { // Above comments apply here too
            totalDiscount += lineItems[i].getDiscount();
        }
        return totalDiscount;
    }
    
    public double getFinalTotal() {
        return getTotal() - getTotalDiscount();
    }
    
}
