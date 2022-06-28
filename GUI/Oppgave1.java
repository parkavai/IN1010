import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Oppgave1 {
    
    public static void main(String[] args) {
        JFrame vindu = new JFrame("Oppgave 1");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(2,3));
        
        for (int i = 1; i <= 6; i++) {
            Rute nyRute = new Rute(i);
            panel.add(nyRute);
        }
        
        vindu.add(panel);
        vindu.pack();
        vindu.setVisible(true);

    }
}

class Rute extends JButton {

    String tallVerdi;
    String smilefjes = ":)";

    private class Klikk implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (getText().equals(smilefjes)) {
                setText(tallVerdi);
            }
            else {
                setText(smilefjes);
            }
        }
    }

    Rute(int tall) {
        super(String.valueOf(tall));
        tallVerdi = tall+"";
        addActionListener(new Klikk());
        
    }
}