import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;

import java.util.ArrayList;
import java.util.Random;

class Beger {
    public static void main(String[] args) {
        JFrame vindu = new JFrame("Beger");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LagSpill lagSpill = new LagSpill();
        lagSpill.initGUI();
        vindu.add(lagSpill);
        vindu.pack();
        vindu.setVisible(true);
    }

}

class LagSpill extends JPanel {
    JButton sluttknapp;
    JLabel statustekst;
    Spillet spill;

    LagSpill(){
        spill = new Spillet(this);
    }

    void initGUI(){
        spill.initGUI();
        statustekst = new JLabel("Hvor er ballen?");
        this.setLayout(new BorderLayout());
        add(statustekst, BorderLayout.EAST);
        add(spill, BorderLayout.CENTER);
    }
}

class Spillet extends JPanel {

    LagSpill lagspill;
    ArrayList<KnappBeger> listeAvKnapp; 

    Spillet(LagSpill lagspill){
        this.lagspill = lagspill;
        listeAvKnapp = new ArrayList<>();
    }

    void initGUI(){
        int teller = 0;
        for(int i = 1; i < 4; i++){
            Random random = new Random();
            int tall = random.nextInt(12);
            if(tall < 4){
                teller++;
            }
            if(teller == 2){
                tall = 8;
            }
            KnappBeger knapp = new KnappBeger(i, tall, this);
            knapp.initGUI();
            add(knapp);
        }
    }
}

class KnappBeger extends JButton {
    int ball = 0;
    Spillet spill; 
    int id;
    KnappBeger(int id, int tall, Spillet spill){
        super("Beger nr: " + id);
        this.id = id;
        this.spill = spill;
        this.ball = tall;
    }

    int hentBall(){
        return ball;
    }

    int hentId(){
        return id;
    }

    void initGUI(){
        class VisBallen implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent E) {
                if(hentBall() < 8){
                    setText("Fant ballen");
                    spill.lagspill.statustekst.setText("Ballen ble funnet i beger nr: " + hentId());
                }
                else if(spill.lagspill.statustekst.getText().equals("Feil, prøv igjen")){
                    if(hentBall() < 8){
                        setText("Fant ballen");
                        spill.lagspill.statustekst.setText("Fant ballen");
                    }
                }
                else {
                    spill.lagspill.statustekst.setText("Feil, prøv igjen");
                }
            }
        }
        addActionListener(new VisBallen());
    }
}