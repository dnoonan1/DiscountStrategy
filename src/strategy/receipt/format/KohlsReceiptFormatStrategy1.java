package strategy.receipt.format;

import startup.*;
import strategy.lineitem.format.*;

/**
 *
 * @author Dan
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
        sb.append("Customer: " + customer.getFullName() + "\n\n");
        sb.append(lineItemFormatter.getHeader());
        for (LineItem li : lineItems) {
            if (li != null) {
                sb.append(lineItemFormatter.getFormattedLineItem(li).toString());
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
