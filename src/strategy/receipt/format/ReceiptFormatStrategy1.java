package strategy.receipt.format;

import strategy.lineitem.format.*;
import mainclasses.*;

/**
 *
 * @author Dan
 */
public class ReceiptFormatStrategy1 implements ReceiptFormatStrategy {

    private LineItemFormatter lineItemFormatter;

    public ReceiptFormatStrategy1() {}

    public ReceiptFormatStrategy1(LineItemFormatter lineItemFormatter) {
        this.lineItemFormatter = lineItemFormatter;
    }

    public void setLineItemFormatter(LineItemFormatter lineItemFormatter) {
        this.lineItemFormatter = lineItemFormatter;
    }
    
    @Override
    public String getFormattedReceipt(Receipt receipt) {
        Customer customer = receipt.getCustomer();
        LineItem[] lineItems = receipt.getLineItems();
        StringBuilder sb = new StringBuilder();
        sb.append("Customer: " + customer.getFullName());
        return sb.toString();
    }

}
