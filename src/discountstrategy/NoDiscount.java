package discountstrategy;

/**
 *
 * @author dnoonan1
 */
public class NoDiscount implements Discount {

    @Override
    public double getDiscountAmount(double unitPrice, int qty) {
        return 0.0;
    }
    
}
