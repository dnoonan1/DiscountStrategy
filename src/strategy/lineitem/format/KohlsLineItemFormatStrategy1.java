package strategy.lineitem.format;

import startup.LineItem;
import startup.Product;

/**
 *
 * @author Dan
 */
public class KohlsLineItemFormatStrategy1 implements LineItemFormatStrategy {

    public KohlsLineItemFormatStrategy1() {}
    
    @Override
    public String getHeader() {
        return "ITEM   DESCRIPTION   PRICE    QTY  SUBTOTAL DISCOUNT\n" +
               "----------------------------------------------------\n";
    }
    
    @Override
    public String getFormattedLineItem(LineItem lineItem) {
        Product product = lineItem.getProduct();
        return String.format("%-5s  %-12s  $%6.2f  %3d  $%6.2f  $%6.2f",
                product.getId(), product.getDescription(),
                product.getUnitPrice(), lineItem.getQty(),
                lineItem.getSubtotal(), lineItem.getDiscount());
    }
    
}
