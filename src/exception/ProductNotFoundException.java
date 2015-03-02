package exception;

/**
 * ProductNotFoundException should be thrown if a product is not found in the
 * database. The method findProduct() in ReceiptDataAccessStrategy throws it.
 * 
 * @author Dan Noonan
 * @version 1.0
 * @see data.access.ReceiptDataAccessStrategy
 */
public class ProductNotFoundException extends Exception {

    /**
     * Creates a new instance of <code>ProductNotFoundException</code> without
     * detail message.
     */
    public ProductNotFoundException() {
    }

    /**
     * Constructs an instance of <code>ProductNotFoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ProductNotFoundException(String msg) {
        super(msg);
    }
}
