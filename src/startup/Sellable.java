package startup;

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
    double getDiscountValue(int qty);
}
