package components;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;

public class CustomButton extends JButton implements ActionListener {
    public CustomButton(String label) {
        super(label);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Random rand = new Random();
        setBackground(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
    }


    public Color generateRandomColor() {
        Random rand = new Random();
        return new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }

}
