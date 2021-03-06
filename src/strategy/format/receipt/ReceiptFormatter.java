package strategy.format.receipt;

import startup.Receipt;

/**
 *
 * @author Dan Noonan
 * @version 1.0
 */
public class ReceiptFormatter {
    
    private ReceiptFormatStrategy receiptStrategy;

    public ReceiptFormatter() {}
    
    public ReceiptFormatter(ReceiptFormatStrategy receiptStrategy) {
        setReceiptStrategy(receiptStrategy);
    }
    
    public void setReceiptStrategy(ReceiptFormatStrategy receiptStrategy) {
        this.receiptStrategy = receiptStrategy;
    }

    public String getFormattedReceipt(Receipt receipt) {
        return receiptStrategy.getFormattedReceipt(receipt);
    }
    
}
