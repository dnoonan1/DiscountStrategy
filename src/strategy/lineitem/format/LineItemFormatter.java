package strategy.lineitem.format;

import mainclasses.LineItem;

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
    
    public String getFormattedReceipt(LineItem lineItem) {
        return strategy.getFormattedLineItem(lineItem);
    }
    
}
