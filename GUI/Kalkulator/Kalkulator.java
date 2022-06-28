import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Kalkulator {

    private static JLabel tekst = new JLabel("0"); // Teksten der resultatet skrives
    private static String forrigeTall = "";        
    private static int knappStorrelse = 140;
    private static String operasjon = "+";         // Operasjonen som kom før '='

    public static void main(String[] args) {
        JFrame vindu = new JFrame("Kalkulator");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        // Bruker box layout for å dele opp panelet i to bokser, en for teksten og en for 
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));  
        vindu.add(panel);

        lagTekstStil();
        panel.add(tekst);

        JPanel knapper = new JPanel();
        panel.add(knapper);

        knapper.setLayout(new GridLayout(4,4)); // 4x4 knapper, 10 tall, 5 operasjoner og '.'
        knapper.setBackground(Color.BLACK);
        leggTilTallKnapper(knapper);
        LeggTilOperasjonsKnapper(knapper);

        panel.setBackground(Color.BLACK);
        vindu.pack();
        vindu.setVisible(true);
    }

    private static void lagTekstStil(){
        tekst.setBackground(Color.BLACK);
        tekst.setForeground(Color.WHITE);
        tekst.setOpaque(true);
        tekst.setFont(new Font("times new roman" ,Font.ITALIC, 40));
        tekst.setAlignmentX(Component.CENTER_ALIGNMENT);    // Setter teksten midtstilt

        tekst.setPreferredSize(new Dimension(knappStorrelse * 4, knappStorrelse));

    }
    

    private static void leggTilTallKnapper(JPanel panel) {
        
        class TallKnapp extends JButton {

            public TallKnapp(String tall){
                super(tall);
                setPreferredSize(new Dimension(knappStorrelse, knappStorrelse));
                setFont(new Font("times new roman", Font.CENTER_BASELINE, 40));
                addActionListener(new TallAction());
            }

            class TallAction implements ActionListener{
                @Override
                public void actionPerformed(ActionEvent e){
                    String nyTekst = tekst.getText();   // Henter ut naavaerende tekst
                    if(!getText().equals(".")){         // Hvis knappen ikke er '.'
                        if(nyTekst.equals("0")){        // Hvis man trykker 0 som foerste tall ...
                            nyTekst = "";               // ... saa legges ingenting til
                        }
                    }else{
                        if(nyTekst.contains(".")) return; // Hvis man trykker '.' to ganger skal man ikke gjøre noe
                    }
                    nyTekst += getText();
                    tekst.setText(nyTekst);
                }
            }
    
        }
        // Skal sette inn tallene slik at 7, 8, 9 er oeverst
        int teller = 9;
        for(int i = 0; i < 3; i++){         // Gaar gjennom hver rad
            for(int j = 2; j >= 0; j--){    // For aa finne riktig verdi maa man ta ifra 2 foerst
                String tall = Integer.toString(teller - j);
                TallKnapp knapp = new TallKnapp(tall);
                panel.add(knapp);
            }
            teller -= 3;    // 3 knapper per rad
        }
        panel.add(new TallKnapp("0"));
        panel.add(new TallKnapp("."));
        // Kunne lagt til alle tallene slik som '0' og '.'
    }

    private static void LeggTilOperasjonsKnapper(JPanel panel) {

        class OperasjonsKnapp extends JButton {

            public OperasjonsKnapp(String operasjon){
                super(operasjon);
                setBackground(Color.ORANGE);  // Funker ikke paa mac
                setForeground(Color.BLACK);
                setPreferredSize(new Dimension(knappStorrelse, knappStorrelse));
                setFont(new Font("times new roman" ,Font.BOLD, 40));
                addActionListener(new OperasjonAction());
            }

            class OperasjonAction implements ActionListener{
                @Override
                public void actionPerformed(ActionEvent e){
                    if(getText().equals("=")){
                        if(forrigeTall.equals("")) return;

                        Double tall1 = 0.0, tall2 = 0.0;

                        try{
                            tall1 = Double.parseDouble(forrigeTall);    // Konverterer tallene til Double
                            tall2 = Double.parseDouble(tekst.getText());
                        }catch(Exception exception){
                            return;
                        }

                        Double resultat = 0.0;
                        if(operasjon.equals("+")){
                            resultat = tall1 + tall2;
                        }else if(operasjon.equals("-")){
                            resultat = tall1 - tall2;
                        }else if(operasjon.equals("/")){
                            resultat = tall1 / tall2;
                        }else if(operasjon.equals("*")){
                            resultat = tall1 * tall2;
                        }
                        forrigeTall = "";
                        tekst.setText(Double.toString(resultat));
                    }else{ // Hvis man trykker en annen operator enn '=' sa lagres tallet som sto fra foer
                        operasjon = getText();
                        forrigeTall = tekst.getText();
                        tekst.setText("0");
                    }
                }
            }
        }

        panel.add(new OperasjonsKnapp("+"), 3);     // Legger til operatorene paa siden
        panel.add(new OperasjonsKnapp("-"), 7);
        panel.add(new OperasjonsKnapp("*"), 11);
        panel.add(new OperasjonsKnapp("="), 12);
        panel.add(new OperasjonsKnapp("/"), 15);
    }

}