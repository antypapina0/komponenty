package components;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextFieldComponent extends JPanel {
    private JTextField textField;

    public TextFieldComponent(String text, int columns) {
        textField = new JTextField(text, columns);
        this.add(textField);
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }
}

