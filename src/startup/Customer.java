package startup;

/**
 *
 * @author Dan Noonan
 * @version 1.0
 */
public class Customer implements Comparable {
    
    private String custId;
    private String firstName;
    private String lastName;

    public Customer(String custId) {
        setCustId(custId);
    }
    
    public Customer(String custId, String firstName, String lastName) {
        this(custId);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public final String getCustId() {
        return custId;
    }

    public final void setCustId(String custID) {
        this.custId = custID;
    }
    
    public final String getFirstName() {
        return firstName;
    }

    public final void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public final String getLastName() {
        return lastName;
    }

    public final void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public final String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Customer) {
            Customer that = (Customer)o;
            return this.custId.compareTo(that.custId);
        } /*else if (o instanceof String) {
            String that = (String)o;
            return this.custId.compareTo(that);
        }*/
        throw new ClassCastException("Object o must be type Customer");
    }

}
