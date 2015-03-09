package strategy.format.receipt;

import startup.Receipt;

/**
 *
 * @author Dan Noonan
 * @version 1.0
 */
public interface ReceiptFormatStrategy {
    String getFormattedReceipt(Receipt receipt);
}
