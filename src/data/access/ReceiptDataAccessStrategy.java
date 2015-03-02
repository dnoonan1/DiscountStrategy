package data.access;

import startup.Customer;
import startup.Product;

/**
 *
 * @author Dan
 */
public interface ReceiptDataAccessStrategy {
    Customer findCustomer(String custId);
    Product findProduct(String prodId);
}
