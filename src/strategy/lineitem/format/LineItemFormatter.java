package strategy.lineitem.format;

import startup.LineItem;

/**
 *
 * @author Dan
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
