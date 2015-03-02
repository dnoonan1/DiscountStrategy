package discount.strategy;

/**
 *
 * @author dnoonan1
 */
public class QuantityDiscount implements Discount {

    // Not sure how to implement this yet
    private double percentOff;
    private int minQuantity;

    public QuantityDiscount(double percentOff, int minQuantity) {
        this.percentOff = percentOff;
        this.minQuantity = minQuantity;
    }
    
    // Not yet implemented!
    @Override
    public double getDiscountAmount(double unitPrice, int qty) {
        if (qty >= minQuantity) {
            return (percentOff / 100.0) * unitPrice * qty;
        } else {
            return unitPrice * qty;
        }
    }

}
