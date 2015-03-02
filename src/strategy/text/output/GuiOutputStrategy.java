package strategy.text.output;

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
        String[] lines = text.split("\n");
        JLabel[] labels = new JLabel[lines.length];
        for (int i = 0; i < lines.length; i++) {
            labels[i] = new JLabel(lines[i]);
            labels[i].setFont(new Font("Monospaced", Font.PLAIN, 20));
        }
        JOptionPane.showMessageDialog(null, labels);
    }
    
}
