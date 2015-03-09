package strategy.discount;

/**
 * Discount is a simple interface. It has one method for calculating the value
 * of a discount based on price and quantity.
 * 
 * @author Dan Noonan
 * @version 1.0
 */
public interface Discount {
    public abstract double getDiscountAmount(double unitPrice, int qty);
}
