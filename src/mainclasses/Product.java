package mainclasses;

import discount.strategy.Discount;

/**
 *
 * @author dnoonan1
 */
public final class Product implements Sellable, Comparable {

    private String id;
    private String description;
    private double unitPrice;
    private Discount discount;

    public Product(String prodId) {
        setId(prodId);
    }
    
    public Product(String prodId, String description, double unitPrice,
            Discount discount) {
        this(prodId);
        this.description = description;
        this.unitPrice = unitPrice;
        this.discount = discount;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String prodId) {
        this.id = prodId;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
    
    @Override
    public double getDiscountAmount(int qty) {
        return discount.getDiscountAmount(unitPrice, qty);
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Product) {
            Product that = (Product)o;
            return this.id.compareTo(that.id);
        } /*else if (o instanceof String) {
            String that = (String)o;
            return this.prodId.compareTo(that);
        }*/
        throw new ClassCastException("Object o must be type Product");
    }
    
}
