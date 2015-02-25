package discountstrategy;

/**
 *
 * @author dnoonan1
 */
public interface Discount {
    public abstract double getDiscountAmount(double unitPrice, int qty);
}
