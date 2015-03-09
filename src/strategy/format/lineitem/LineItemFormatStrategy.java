
package strategy.format.lineitem;

import startup.LineItem;

/**
 *
 * @author Dan Noonan
 * @version 1.0
 */
public interface LineItemFormatStrategy {
    String getHeader();
    String getFormattedLineItem(LineItem lineItem);
}
