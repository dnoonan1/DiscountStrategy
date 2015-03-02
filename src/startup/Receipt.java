package startup;

import exception.ProductNotFoundException;
import exception.CustomerNotFoundException;
import data.access.ReceiptDataAccessStrategy;
import strategy.receipt.format.ReceiptFormatter;

/**
 *
 * @author dnoonan1
 */
public class Receipt {

    private static final int INITIAL_CAPACITY = 8;
    
    private ReceiptDataAccessStrategy db;
    private final Customer customer;
    private LineItem[] lineItems;
    private int lineCount;
    
    public Receipt(ReceiptDataAccessStrategy db, String custId)
            throws CustomerNotFoundException {
        Customer c;
        this.db = db;
        this.lineItems = new LineItem[INITIAL_CAPACITY];
        c = db.findCustomer(custId);
        if (c == null) {
            throw new CustomerNotFoundException();
        }
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
        if (lineCount >= lineItems.length) {
            resizeLineItems();
        }
        li = new LineItem(db, prodId, qty);
        if (li == null) {
            throw new ProductNotFoundException();
        }
        lineItems[lineCount++] = li;
    }
    
    private void resizeLineItems() {
        LineItem[] resized = new LineItem[2 * lineItems.length];
        for (int i = 0; i < lineCount; i++) {
            resized[i] = lineItems[i];
        }
        lineItems = resized;
        //resized = null; // not necessary since local variables are destroyed
    }
    
    public double getTotal() {
        double total = 0.0;
        for (int i = 0; i < lineCount; i++) {
            total += lineItems[i].getSubtotal();
        }
        return total;
    }
    
    public double getTotalDiscount() {
        double totalDiscount = 0.0;
        for (int i = 0; i < lineCount; i++) {
            totalDiscount += lineItems[i].getDiscount();
        }
        return totalDiscount;
    }
    
    public double getFinalTotal() {
        return getTotal() - getTotalDiscount();
    }
    
}
