package mainclasses;

import discount.strategy.Discount;

/**
 *
 * @author Dan
 */
public interface Sellable {
    String getId();
    String getDescription();
    double getUnitPrice();
    Discount getDiscount();
    double getDiscountAmount(int qty);
}
