package data.access;

import startup.Customer;
import discount.strategy.*;
import startup.Product;
import java.util.Arrays;

/**
 *
 * @author dnoonan1
 */
public final class FakeDatabase implements ReceiptDataAccessStrategy {
    
    private Customer[] customers = {
        new Customer("jsmith***1", "John", "Smith"),
        new Customer("sjones***1", "Sally", "Jones"),
        new Customer("bclementi1", "Bob", "Clementi"),
        new Customer("aschwarze1", "Arnold", "Schwarz")
    };

    private Product[] products = {
        new Product("A101", "Socks", 15.95, new PercentOffDiscount(30.0)),
        new Product("B101", "T-shirt", 12.95, new NoDiscount()),
        new Product("C101", "Dress Shoes", 55.95, new QuantityDiscount(10.0, 2)),
        new Product("D101", "Hoodie", 15.95, new FlatDiscount(2.00))
    };
    
    public FakeDatabase() {
        sort();
    }
    
    private final void sort() {
        Arrays.sort(customers);
        Arrays.sort(products);
    }
   
    private final Object searchArray(final Object[] a, final Object key) {
        if (key == null) {
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
    public final Customer findCustomer(final String custId) {
        return (Customer)searchArray(customers, new Customer(custId));
    }
    
    @Override
    public final Product findProduct(final String prodId) {
        return (Product)searchArray(products, new Product(prodId));
    }
    
}
