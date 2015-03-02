package data.access;

import exception.*;
import startup.Customer;
import startup.Product;

/**
 * ReceiptDataAccessStrategy is an interface for accessing a database in order
 * to obtain data for a receipt. It has two methods: one for finding a customer
 * in the database, the other for finding a product.
 * 
 * @author Dan Noonan
 * @version 1.0
 * @see FakeDataBase
 */
public interface ReceiptDataAccessStrategy {
    Customer findCustomer(String custId) throws CustomerNotFoundException;
    Product findProduct(String prodId) throws ProductNotFoundException;
}
