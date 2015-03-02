package data.access;

import mainclasses.Customer;
import mainclasses.Product;

/**
 *
 * @author Dan
 */
public interface ReceiptDataAccessStrategy {
    Customer findCustomer(String custId);
    Product findProduct(String prodId);
}
