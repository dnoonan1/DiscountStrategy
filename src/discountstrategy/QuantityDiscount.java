package discountstrategy;

/**
 *
 * @author dnoonan1
 */
public class QuantityDiscount implements Discount {

    // Not sure how to implement this yet
    private double percentOff;
    private int maxQuantity;
    
    // Not yet implemented!
    @Override
    public double getDiscountAmount(double unitPrice, int qty) {
        throw new UnsupportedOperationException();
    }

}
