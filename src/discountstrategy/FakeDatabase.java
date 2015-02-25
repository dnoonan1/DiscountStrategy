package discountstrategy;

import java.util.Arrays;

/**
 *
 * @author dnoonan1
 */
public final class FakeDatabase implements ReceiptDataAccessStrategy {

    private boolean sorted = false;
    
    private Customer[] customers = {
        new Customer("jsmith1", "John", "Smith"),
        new Customer("sjones1", "Sally", "Jones"),
        new Customer("bclementi1", "Bob", "Clementi")
    };

    private Product[] products = {
        new Product("A101", "Socks", 15.95, new PercentOffDiscount(30.0)),
        new Product("B101", "T-shirt", 12.95, new NoDiscount()),
        new Product("C101", "Shoes", 55.95, new PercentOffDiscount(10.0))
    };
    
    public FakeDatabase() {
        sort();
    }
    
    private final void sort() {
        Arrays.sort(customers);
        Arrays.sort(products);
    }
   
    private final Object searchArray(Object[] a, String key) {
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("key cannot be null or empty");
        }
        int index = Arrays.binarySearch(a, key);
        if (index < 0) {
            return null;
        } else {
            return a[index];
        }
    }
    
    @Override
    public final Customer findCustomer(String custId) {
        //return (Customer)searchArray(customers, custId);
        for (Customer c : customers) {
            if (c.getCustId().equals(custId)) {
                return c;
            }
        }
        return null;
    }
    
    @Override
    public final Product findProduct(String prodId) {
        //return (Product)searchArray(products, prodId);
        for (Product p : products) {
            if (p.getProdId().equals(prodId)) {
                return p;
            }
        }
        return null;
    }
    
}
