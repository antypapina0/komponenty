package components;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;

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

    public void setBackgroundColor(Color color) {
        textField.setBackground(color);
    }


}

