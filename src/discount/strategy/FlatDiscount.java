package discount.strategy;

/**
 * FlatDiscount gives a constant amount off, regardless of price or quantity.
 * 
 * @author Dan Noonan
 * @version 1.0
 */
public class FlatDiscount implements Discount {

    private double discount;
    
    public FlatDiscount(double discount) {
        this.discount = discount;
    }
    
    @Override
    public double getDiscountAmount(double unitPrice, int qty) {
        return discount;
    }
    
}
