package exception;

/**
 * CustomerNotFoundException should be thrown if a customer is not found in
 * the database. The method findCustome() in ReceiptDataAccessStrategy throws
 * this exception.
 * 
 * @author Dan Noonan
 * @version 1.0
 * @see data.access.ReceiptDataAccessStrategy
 */
public class CustomerNotFoundException extends Exception {

    /**
     * Creates a new instance of <code>CustomerNotFoundException</code> without
     * detail message.
     */
    public CustomerNotFoundException() {
    }

    /**
     * Constructs an instance of <code>CustomerNotFoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CustomerNotFoundException(String msg) {
        super(msg);
    }
}
