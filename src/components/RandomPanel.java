package components;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

public class RandomPanel extends JPanel {
    private JButton button1;
    private JButton button2;

    private JButton button3;
    private Font randomFont;
    private JButton button4;
    public RandomPanel() {
        button1 = new JButton("JTextField");
        button2 = new JButton("Przyciski ");
        button3 = new JButton("Kolor cziocnki");
        button4 = new JButton("FOnt");

        button1.addActionListener(new RandomColorButtonListener());
        button2.addActionListener(new RandomColorButtonListener());
        button3.addActionListener(new RandomFontButtonListener());
        button4.addActionListener(new RandomTextColorButtonListener());
        add(button1);
        add(button2);
        add(button3);
        add(button4);
    }

    public void setBackgroundColor(Color color) {
        setBackground(color);
    }

    private class RandomColorButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Random random = new Random();
            float hue = random.nextFloat();
            float saturation = 0.5f;
            float brightness = 0.9f;
            Color randomColor = Color.getHSBColor(hue, saturation, brightness);
        }
    }
    private class RandomFontButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            randomFont = new Font("Arial", Font.BOLD, 12);

        }
    }

    private class RandomTextColorButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Random random = new Random();
            float hue = random.nextFloat();
            float saturation = 0.5f;
            float brightness = 0.9f;
            Color randomColor = Color.getHSBColor(hue, saturation, brightness);

        }
    }
    public Font getRandomFont() {
        return randomFont;
    }
    public JButton getButton1() {
        return button1;
    }

    public JButton getButton2() {
        return button2;
    }

    public JButton getButton3() {
        return button3;
    }

    public JButton getButton4() {
        return button4;
    }
}
