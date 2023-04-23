package components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import components.NumericKeypad;
import components.TextFieldComponent;
public class CalculatorPanel extends JPanel {
    private NumericKeypad numericKeypad;
    private TextFieldComponent textFieldComponent;
    private CustomButton colorButton;
    public CalculatorPanel() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        textFieldComponent = new TextFieldComponent("", 10);
        numericKeypad = new NumericKeypad(textFieldComponent.getTextField());
        colorButton = new CustomButton("Change colors");
        OperatorPanel operatorPanel = new OperatorPanel(textFieldComponent.getTextField());

        textFieldComponent.setPreferredSize(new Dimension(200, 50));
        numericKeypad.setPreferredSize(new Dimension(200, 150));
        operatorPanel.setPreferredSize(new Dimension(200, 50));
        colorButton.setPreferredSize(new Dimension(100, 50));

        add(textFieldComponent);
        add(numericKeypad);
        add(operatorPanel);
        add(colorButton);


        // Połączenie komponentów
        for (int i = 0; i < 10; i++) {
            numericKeypad.getButton(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton) e.getSource();
                    String text = textFieldComponent.getTextField().getText();
                    text += button.getText();
                    textFieldComponent.getTextField().setText(text);
                }
            });
        }
        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color randomColor = colorButton.generateRandomColor();
                for (int i = 0; i < 10; i++) {
                    JButton button = numericKeypad.getButton(i);
                    button.setBackground(randomColor);
                }

            }
        });
    }

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
