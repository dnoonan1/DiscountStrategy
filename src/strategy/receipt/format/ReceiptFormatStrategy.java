package strategy.receipt.format;

import mainclasses.Receipt;

/**
 *
 * @author Dan
 */
public interface ReceiptFormatStrategy {
    String getFormattedReceipt(Receipt receipt);
}
