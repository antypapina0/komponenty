
import components.CalculatorPanel;
import components.NumericKeypad;
import components.TextFieldComponent;

import javax.swing.*;

public class CalculatorApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CalculatorPanel panel = new CalculatorPanel();
        frame.getContentPane().add(panel);

        frame.setSize(300,350);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}



