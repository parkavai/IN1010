import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;

class GUITemplate {
    public static void main(String[] args) {
        JFrame vindu = new JFrame("Tittel");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        vindu.add(panel);

        JLabel text = new JLabel("Example text");
        panel.add(text);

        JButton button = new JButton("Button text");
        panel.add(button);

        vindu.pack();
        vindu.setVisible(true);

        class ButtonAction implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.setText("Pressed");
            }
        }

        button.addActionListener(new ButtonAction());
    }
}