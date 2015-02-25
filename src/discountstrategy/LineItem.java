package discountstrategy;

/**
 *
 * @author dnoonan1
 */
public class LineItem {

    private final Product product;
    private final int qty;

    public LineItem(Product product, int qty) {
        this.product = product;
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
        return product.getDiscountAmount(qty);
    }
    
    public String toString() {
        return String.format("%-5s  %-10s  $%6.2f  %2d  $%6.2f  $%6.2f\n",
                product.getProdId(), product.getDescription(),
                product.getUnitPrice(), qty, getSubtotal(), getDiscount());
    }
    
}
