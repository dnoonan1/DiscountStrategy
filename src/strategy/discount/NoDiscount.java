package strategy.discount;

/**
 * NoDiscount always gives $0 off, no matter unit price or quantity.
 * 
 * @author Dan Noonan
 * @version 1.0
 */
public class NoDiscount implements Discount {

    @Override
    public double getDiscountAmount(double unitPrice, int qty) {
        return 0.0;
    }
    
}
