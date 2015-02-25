package discountstrategy;

/**
 *
 * @author dnoonan1
 */
public class Customer implements Comparable {
    
    private String custId;
    private String firstName;
    private String lastName;

    public Customer(String custID, String firstName, String lastName) {
        this.custId = custID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custID) {
        this.custId = custID;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Customer) {
            Customer that = (Customer)o;
            return this.custId.compareTo(that.custId);
        } else if (o instanceof String) {
            String that = custId;
            return this.custId.compareTo(that);
        }
        throw new ClassCastException("Object o must be type Customer");
    }

}
