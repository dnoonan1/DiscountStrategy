package startup;

import strategy.discount.Discount;

/**
 * Sellable is an interface that abstracts Product. The intention was to have a
 * superclass that could potentially represent both products and services.
 * However, there is no implementation of a Service class in this project.
 * So while Sellable is not used with the current design, it is included here
 * in case more flexibility is needed in the future.
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
