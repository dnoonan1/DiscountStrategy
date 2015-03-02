
package strategy.lineitem.format;

import startup.LineItem;

/**
 *
 * @author Dan
 */
public interface LineItemFormatStrategy {
    String getHeader();
    String getFormattedLineItem(LineItem lineItem);
}
