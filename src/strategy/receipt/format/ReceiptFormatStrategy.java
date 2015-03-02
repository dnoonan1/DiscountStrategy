package strategy.receipt.format;

import startup.Receipt;

/**
 *
 * @author Dan
 */
public interface ReceiptFormatStrategy {
    String getFormattedReceipt(Receipt receipt);
}
