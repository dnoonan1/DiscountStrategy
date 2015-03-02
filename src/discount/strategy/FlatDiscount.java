package discount.strategy;

/**
 *
 * @author Dan
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
