package startup;

import discount.strategy.Discount;

/**
 *
 * @author Dan Noonan
 * @version 1.0
 */
public interface Sellable {
    String getId();
    String getDescription();
    double getUnitPrice();
    Discount getDiscount();
    double getDiscountValue(int qty);
}
