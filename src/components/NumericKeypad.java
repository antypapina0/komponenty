package components;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFrame;
public class NumericKeypad extends JPanel {
    private JButton[] buttons;
    private JTextField textField;


    public NumericKeypad(JTextField textField) {
        super(new GridLayout(4, 3));
        this.textField = textField;
        buttons = new JButton[12];

        for (int i = 0; i < 10; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(new NumberButtonListener());
            buttons[i] = button;
            add(button);
        }

        JButton clearButton = new JButton("C");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
            }
        });

        buttons[10] = clearButton;
        add(clearButton);

        JButton dotButton = new JButton(".");
        dotButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String textFieldValue = textField.getText();
                if (!textFieldValue.contains(".")) {
                    textField.setText(textFieldValue + ".");
                }
            }
        });
        buttons[11] = dotButton;
        add(dotButton);
    }

    public JButton getButton(int i) {
        return buttons[i];
    }

    public void setButton(int i, JButton button) {
        buttons[i] = button;
    }

    private class NumberButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String buttonValue = e.getActionCommand();
            String textFieldValue = textField.getText();
        }
    }





}



