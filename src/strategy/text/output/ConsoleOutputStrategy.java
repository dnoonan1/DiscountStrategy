package strategy.text.output;

/**
 *
 * @author Dan Noonan
 * @version 1.0
 */
public class ConsoleOutputStrategy implements TextOutputStrategy {

    @Override
    public void writeText(String text) {
        System.out.print(text);
    }
    
}
