package strategy.format.receipt;

import strategy.format.lineitem.LineItemFormatter;
import strategy.format.lineitem.LineItemFormatStrategy;
import startup.*;

/**
 *
 * @author Dan Noonan
 * @version 1.0
 */
public class KohlsReceiptFormatStrategy1 implements ReceiptFormatStrategy {

    private LineItemFormatter lineItemFormatter;

    public KohlsReceiptFormatStrategy1() {}

    public KohlsReceiptFormatStrategy1(
            LineItemFormatStrategy lineItemFormatStrategy) {
        lineItemFormatter = new LineItemFormatter();
        setLineItemStrategy(lineItemFormatStrategy);
    }

    public void setLineItemStrategy(
        LineItemFormatStrategy lineItemFormatStrategy) {
        lineItemFormatter.setStrategy(lineItemFormatStrategy);
    }
    
    @Override
    public String getFormattedReceipt(Receipt receipt) {
        Customer customer = receipt.getCustomer();
        LineItem[] lineItems = receipt.getLineItems();
        StringBuilder sb = new StringBuilder();
        sb.append("Printing Receipt...\n");
        sb.append("Customer: " + customer.getFullName() + "\n\n");
        sb.append(lineItemFormatter.getHeader());
        for (LineItem li : lineItems) {
            if (li != null) { // BAD - see comments in Receipt
                sb.append(lineItemFormatter.getFormattedLineItem(li));
                sb.append("\n");
            }
        }
        // Have to add total and subtotal
        sb.append(String.format(
              //"ITEM   DESCRIPTION   PRICE    QTY  SUBTOTAL DISCOUNT\n"
              //"----------------------------------------------------\n"
              "\n                            TOTAL: $%6.2f\n"
              + "                         DISCOUNT: $%6.2f\n"
              + "                      --------------------\n"
              + "                      FINAL TOTAL: $%6.2f\n",
                    receipt.getTotal(), receipt.getTotalDiscount(),
                receipt.getFinalTotal()));
        sb.append("\nThank you for shopping at Kohl's!\n");
        return sb.toString();
    }

}
