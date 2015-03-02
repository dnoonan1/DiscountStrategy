
package strategy.lineitem.format;

import mainclasses.LineItem;

/**
 *
 * @author Dan
 */
public interface LineItemFormatStrategy {
    String getHeader();
    String getFormattedLineItem(LineItem lineItem);
}
