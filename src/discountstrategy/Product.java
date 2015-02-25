package discountstrategy;

/**
 *
 * @author dnoonan1
 */
public final class Product implements Comparable {

    private String prodId;
    private String description;
    private double unitPrice;
    private Discount discount;

    public Product(String prodId, String description, double unitPrice,
            Discount discount) {
        this.prodId = prodId;
        this.description = description;
        this.unitPrice = unitPrice;
        this.discount = discount;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
    
    public double getDiscountAmount(int qty) {
        return discount.getDiscountAmount(unitPrice, qty);
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Product) {
            Product that = (Product)o;
            return this.prodId.compareTo(that.prodId);
        } else if (o instanceof String) {
            String that = prodId;
            return this.prodId.compareTo(that);
        }
        throw new ClassCastException("Object o must be type Product");
    }
    
}
