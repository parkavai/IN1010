import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JLabelDemo {

    public JLabel labelText;
    public JLabelDemo() {
        JFrame f = new JFrame("JLabel Demo");
        f.setVisible(true);
        f.setSize(500, 500);
        f.setLayout(null);

        labelText = new JLabel("StackOverflow");
        f.add(labelText);

        JButton btn = new JButton("Change Text");
        f.add(btn);


        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                labelText.setText("Google.com");
            }
        });

    }

    public static void main(String[] args) {
        new JLabelDemo();
    }
}