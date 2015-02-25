package discountstrategy;

/**
 *
 * @author dnoonan1
 */
public class Receipt {

    private static final int INITIAL_CAPACITY = 20;
    
    private final Customer customer;
    private LineItem[] lineItems = new LineItem[INITIAL_CAPACITY];
    private int count;
    
    public Receipt(Customer customer) {
        this.customer = customer;
    }
    
    public void addLineItem(LineItem li) {
        if (count < lineItems.length) {
            lineItems[count++] = li;
        } else {
            resizeLineItems();
            addLineItem(li);
        }
    }
    
    private void resizeLineItems() {
        int initialCapacity = lineItems.length;
        int newCapacity = 2 * initialCapacity; // double the capacity
        LineItem[] resized = new LineItem[newCapacity];
        for (int i = 0; i < lineItems.length; i++) {
            resized[i] = lineItems[i];
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        LineItem li;
        double total = 0.0, totalDiscount = 0.0;
        sb.append("Customer: " + customer.getFullName() + "\n\n");
        for (int i = 0; i < count; i++) {
            li = lineItems[i];
            total += li.getSubtotal();
            totalDiscount += li.getDiscount();
            sb.append(li);
        }
        sb.append(String.format("\nSubtotal: $%7.2f\nDiscount: $%7.2f\n",
                total, totalDiscount));
        sb.append(String.format("------------------\nTotal:    $%7.2f\n",
                total - totalDiscount));
        sb.append("\nThank you for shopping at Kohl's!");
        return sb.toString();
    }
    
}
