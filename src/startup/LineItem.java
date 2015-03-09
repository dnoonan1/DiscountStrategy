package startup;

import strategy.dataaccess.*;

/**
 *
 * @author Dan Noonan
 * @version 1.0
 */
public class LineItem {

    private final Product product;
    private final int qty;

    public LineItem(ReceiptDataAccessStrategy db, String prodId, int qty) 
            throws ProductNotFoundException {
        this.product = db.findProduct(prodId);
        this.qty = qty;
    }

    public Product getProduct() {
        return product;
    }

    public int getQty() {
        return qty;
    }
    
    public double getSubtotal() {
        return product.getUnitPrice() * qty;
    }
    
    public double getDiscount() {
        return product.getDiscountValue(qty);
    }
    
    /*public static String getHeader() {
        return "ITEM   DESCRIPTION   PRICE      QTY  SUBTOTAL   DISCOUNT\n" +
               "---------------------------------------------------------\n";
    }
    
    @Override
    public String toString() {
        return String.format("%-5s  %-12s  $%8.2f  %3d  $%8.2f  $%8.2f\n",
                product.getId(), product.getDescription(),
                product.getUnitPrice(), qty, getSubtotal(), getDiscount());
    }*/
    
}
