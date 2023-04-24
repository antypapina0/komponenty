package components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class CalculatorPanel extends JPanel {
    private NumericKeypad numericKeypad;
    private TextFieldComponent textFieldComponent;
    private RandomPanel colorPanel;


    public CalculatorPanel() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        textFieldComponent = new TextFieldComponent("", 10);
        numericKeypad = new NumericKeypad(textFieldComponent.getTextField());
        OperatorPanel operatorPanel = new OperatorPanel(textFieldComponent.getTextField());

        colorPanel = new RandomPanel();



        textFieldComponent.setPreferredSize(new Dimension(200, 50));
        numericKeypad.setPreferredSize(new Dimension(200, 150));
        operatorPanel.setPreferredSize(new Dimension(200, 50));
        colorPanel.setPreferredSize(new Dimension(200, 50));

        add(textFieldComponent);
        add(numericKeypad);
        add(operatorPanel);
        add(colorPanel);




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

        colorPanel.getButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color randomColor = getRandomColor();
                textFieldComponent.setBackgroundColor(randomColor);
            }
        });



        colorPanel.getButton2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color randomColor = getRandomColor();
                for (int i = 0; i < 10; i++) {
                    numericKeypad.getButton(i).setBackground(randomColor);
                }
                for (Component component : operatorPanel.getComponents()) {
                    if (component instanceof JButton) {
                        component.setBackground(randomColor);
                    }
                }
            }
        });

        colorPanel.getButton3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color randomColor = getRandomColor();
                textFieldComponent.getTextField().setForeground(randomColor);
            }
        });

        colorPanel.getButton4().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Font randomFont = colorPanel.getRandomFont();

                    textFieldComponent.getTextField().setFont(randomFont);

            }
        });
    }
    private Color getRandomColor() {
        Random random = new Random();
        float hue = random.nextFloat();
        float saturation = 0.5f;
        float brightness = 0.9f;
        return Color.getHSBColor(hue, saturation, brightness);
    }


    }


