package strategy.discount;

/**
 * QuantityDiscount gives a certain amount off (discount) per unit bought if
 * the customer buys more than a certain amount (minQuantity).
 * 
 * @author Dan Noonan
 * @version 1.0
 */
public class QuantityDiscount implements Discount {

    private double discount;
    private int minQuantity;

    public QuantityDiscount(double discount, int minQuantity) {
        this.discount = discount;
        this.minQuantity = minQuantity;
    }
    
    @Override
    public double getDiscountAmount(double unitPrice, int qty) {
        if (qty >= minQuantity) {
            return discount * qty;
        } else {
            return 0.0;
        }
    }

}
