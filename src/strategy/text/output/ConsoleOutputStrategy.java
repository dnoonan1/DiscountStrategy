package strategy.text.output;

/**
 *
 * @author Dan
 */
public class ConsoleOutputStrategy implements TextOutputStrategy {

    @Override
    public void writeText(String text) {
        System.out.print(text);
    }
    
}
