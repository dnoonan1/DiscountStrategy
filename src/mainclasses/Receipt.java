package mainclasses;

import exception.ProductNotFoundException;
import exception.CustomerNotFoundException;
import data.access.ReceiptDataAccessStrategy;

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
//    private ReceiptFormatStrategy format;
//    private LineItemFormatStrategy lineFormat;
    
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
        //resized = null;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        LineItem li;
        double total = 0.0, totalDiscount = 0.0;
        sb.append("Customer: " + customer.getFullName() + "\n \n");
        sb.append(LineItem.getHeader());
        for (int i = 0; i < lineCount; i++) {
            li = lineItems[i];
            total += li.getSubtotal();
            totalDiscount += li.getDiscount();
            sb.append(li);
        }
        sb.append(String.format("\nSubtotal: $%7.2f\nDiscount: $%7.2f\n",
                total, totalDiscount));
        sb.append(String.format("------------------\nTotal:    $%7.2f\n",
                total - totalDiscount));
        sb.append(" \nThank you for shopping at Kohl's!\n");
        return sb.toString();
    }
    
}
