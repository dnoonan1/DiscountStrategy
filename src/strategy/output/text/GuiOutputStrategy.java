package strategy.output.text;

import java.awt.Font;
import javax.swing.*;

/**
 *
 * @author Dan Noonan
 * @version 1.0
 */
public class GuiOutputStrategy implements TextOutputStrategy {

    @Override
    public void writeText(String text) {
        // Some complicated stuff to change the font of a JOptionPane and make
        // sure output ends up on separate lines. However, blank lines don't
        // display properly. Using a StringTokenizer might allow the problem to
        // be fixed.
        String[] lines = text.split("\n");
        JLabel[] labels = new JLabel[lines.length];
        for (int i = 0; i < lines.length; i++) {
            labels[i] = new JLabel(lines[i]);
            labels[i].setFont(new Font("Monospaced", Font.PLAIN, 20));
        }
        JOptionPane.showMessageDialog(null, labels);
    }
    
}
