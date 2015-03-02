package strategy.lineitem.format;

import mainclasses.LineItem;
import mainclasses.Product;

/**
 *
 * @author Dan
 */
public class LineItemFormatStrategy1 implements LineItemFormatStrategy {

    @Override
    public String getHeader() {
        return "ITEM   DESCRIPTION   PRICE      QTY  SUBTOTAL   DISCOUNT\n" +
               "---------------------------------------------------------\n";
    }
    
    @Override
    public String getFormattedLineItem(LineItem lineItem) {
        Product product = lineItem.getProduct();
        return String.format("%-5s  %-12s  $%8.2f  %3d  $%8.2f  $%8.2f\n",
                product.getId(), product.getDescription(),
                product.getUnitPrice(), lineItem.getQty(),
                lineItem.getSubtotal(), lineItem.getDiscount());
    }
    
}
