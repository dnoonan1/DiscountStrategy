package strategy.string.format;

/**
 *
 * @author Dan
 */
public class StringFormatter {

    private StringFormatStrategy strategy;
    
    public StringFormatter() {}
    
    public StringFormatter(StringFormatStrategy strategy) {
        setStringFormatStrategy(strategy);
    }
    
    public void setStringFormatStrategy(StringFormatStrategy strategy) {
        this.strategy = strategy;
    }
    
    public String getFormattedString() {
        return strategy.getFormattedString();
    }
    
}
