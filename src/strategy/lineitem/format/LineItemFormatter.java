package strategy.lineitem.format;

import startup.LineItem;

/**
 *
 * @author Dan Noonan
 * @version 1.0
 */
public class LineItemFormatter {
    
    private LineItemFormatStrategy strategy;

    public LineItemFormatter() {}
    
    public LineItemFormatter(LineItemFormatStrategy strategy) {
        setStrategy(strategy);
    }
    
    public void setStrategy(LineItemFormatStrategy strategy) {
        this.strategy = strategy;
    }
    
    public String getHeader() {
        return strategy.getHeader();
    }
    
    public String getFormattedLineItem(LineItem lineItem) {
        return strategy.getFormattedLineItem(lineItem);
    }
    
}
