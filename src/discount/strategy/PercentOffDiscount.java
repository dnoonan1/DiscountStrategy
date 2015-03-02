package discount.strategy;

/**
 * PercentOffDiscount gives a discount that is a percentage of the unit price.
 * 
 * @author Dan Noonan
 * @version 1.0
 */
public class PercentOffDiscount implements Discount {

    private double percentOff;
    
    public PercentOffDiscount(double percentOff) {
        this.percentOff = percentOff;
    }
    
    @Override
    public double getDiscountAmount(double unitPrice, int qty) {
        return unitPrice * qty * (percentOff / 100.0);
    }
    
}
