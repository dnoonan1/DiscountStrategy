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
    
}
