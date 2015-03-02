package discount.strategy;

/**
 *
 * @author dnoonan1
 */
public class QuantityDiscount implements Discount {

    private double discount;
    private int minQuantity;

    public QuantityDiscount(double discount, int minQuantity) {
        this.discount = discount;
        this.minQuantity = minQuantity;
    }
    
    // Not yet implemented!
    @Override
    public double getDiscountAmount(double unitPrice, int qty) {
        if (qty >= minQuantity) {
            return discount * qty;
        } else {
            return 0.0;
        }
    }

}
