package startup;

import strategy.output.text.TextOutputStrategy;
import strategy.dataaccess.*;
import strategy.format.receipt.ReceiptFormatter;

/**
 *
 * @author Dan Noonan
 * @version 1.0
 */
public class CashRegister {
    
    private static final String CUSTOMER_NOT_FOUND_MSG = "Customer not found.";
    private static final String PRODUCT_NOT_FOUND_MSG = "Product not found.";
    
    private ReceiptDataAccessStrategy db;
    private TextOutputStrategy output;
    private Receipt receipt;
    private ReceiptFormatter formatter;

    public CashRegister() {}
    
    public CashRegister(ReceiptDataAccessStrategy db) {
        setDatabase(db);
    }
    
    public void setDatabase(ReceiptDataAccessStrategy db) {
        this.db = db;
    }
    
    public void setTextOutputStrategy(TextOutputStrategy output) {
        this.output = output;
    }
    
    public void setFormatter(ReceiptFormatter formatter) {
        this.formatter = formatter;
    }

    public final Receipt getReceipt() {
        return receipt;
    }
    
    public final void writeMsg(String msg) {
        output.writeText(msg);
    }
    
    public final void writeMsgLn(String msg) {
        writeMsg(msg + "\n");
    }

    public final void startNewSale(String custId) {
        try {
            receipt = new Receipt(db, custId);
        } catch (CustomerNotFoundException e) {
            writeMsgLn(CUSTOMER_NOT_FOUND_MSG);
            System.exit(0);
        }
    }
    
    public final void addProductToSale(String prodId, int qty) {
        try {
            receipt.addLineItem(prodId, qty);
        } catch (ProductNotFoundException e) {
            writeMsgLn(PRODUCT_NOT_FOUND_MSG);
        }
    }
    
    public final void endSale() {
        printReceipt();
    }
    
    public final void printReceipt() {
        writeMsg(formatter.getFormattedReceipt(receipt));
    }
    
}
