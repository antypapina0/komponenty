package components;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class OperatorPanel extends JPanel {
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JButton equalsButton;

    private JTextField textField;
    private String operator;
    public OperatorPanel(JTextField textField) {
        super(new GridLayout(2, 3));

        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("x");
        divideButton = new JButton("/");
        equalsButton = new JButton("=");

        addButton.addActionListener(new ArithmeticButtonListener());
        subtractButton.addActionListener(new ArithmeticButtonListener());
        multiplyButton.addActionListener(new ArithmeticButtonListener());
        divideButton.addActionListener(new ArithmeticButtonListener());
        equalsButton.addActionListener(new EqualsButtonListener());

        add(addButton);
        add(subtractButton);
        add(multiplyButton);
        add(divideButton);
        add(equalsButton);

        this.textField = textField;
    }

    private class ArithmeticButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String text = textField.getText();
            text += " " + button.getText() + " ";
            textField.setText(text);
        }
    }

    private class EqualsButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String text = textField.getText();
            String[] parts = text.split(" ");
            double result = Double.parseDouble(parts[0]);
            for (int i = 1; i < parts.length; i += 2) {
                String operator = parts[i];
                double operand = Double.parseDouble(parts[i+1]);
                if (operator.equals("+")) {
                    result += operand;
                } else if (operator.equals("-")) {
                    result -= operand;
                } else if (operator.equals("x")) {
                    result *= operand;
                } else if (operator.equals("/")) {
                    if (operand == 0) {
                        JOptionPane.showMessageDialog(null, "Nie dziel debilu przez 0!", "Błąd", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    result /= operand;
                }
            }
            textField.setText(String.valueOf(result));
        }
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getSubtractButton() {
        return subtractButton;
    }

    public JButton getMultiplyButton() {
        return multiplyButton;
    }

    public JButton getDivideButton() {
        return divideButton;
    }

    public JButton getEqualsButton() {
        return equalsButton;
    }
}
