import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class LoesningLabyrint {
    public static void main(String[] args) throws FileNotFoundException{
        JFrame vindu = new JFrame("Labyrint");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFileChooser velger = new JFileChooser();
        int resultat = velger.showOpenDialog(null);
        if(resultat != JFileChooser.APPROVE_OPTION){
            System.exit(1);
        }
        File file = velger.getSelectedFile();
        Labyrint lab = new Labyrint(file);
        LagLabyrint lagLabyrinten = new LagLabyrint(file, lab);
        lagLabyrinten.initGUI();
        vindu.add(lagLabyrinten);
        vindu.pack();
        vindu.setVisible(true);
    }
    
}

class LagLabyrint extends JPanel{
    JButton sluttknapp;
    JLabel statustekst;
    RuteBrett brettet;
    File filnavn;
    Labyrint lab;

    LagLabyrint(File filnavn, Labyrint lab) throws FileNotFoundException{
        this.filnavn = filnavn;
        this.lab = lab;
        brettet = new RuteBrett(this);
    }

    File hentFil(){
        return filnavn;
    }

    Labyrint hentLabyrint(){
        return lab;
    }

    // Legger brettet på panelet sammen med knappene og setter dem opp gjennom Borderlaoyout
    void initGUI () {
        brettet.initGUI();
        this.setLayout(new BorderLayout());
        add(brettet, BorderLayout.CENTER);

        statustekst = new JLabel("Velg rute med tegn: '.'");
        add(statustekst, BorderLayout.NORTH);
    
        sluttknapp = new JButton("Exit");
        class Stoppbehandler implements ActionListener {
            @Override
            public void actionPerformed (ActionEvent e) {
                System.exit(0);
            }
        }
        sluttknapp.addActionListener(new Stoppbehandler());
        add(sluttknapp, BorderLayout.SOUTH);
    }

}

class RuteBrett extends JPanel{
    LagLabyrint lagLabyrinten;
    Labyrint lab;
    RuteKnapp[][] listeAvKnapper;
    File fil;
    Scanner lesRute;
    int rad, kolonne;

    RuteBrett(LagLabyrint lagLabyrinten) throws FileNotFoundException{
        this.lagLabyrinten = lagLabyrinten;
        this.fil = lagLabyrinten.hentFil();
        this.lab = lagLabyrinten.hentLabyrint();
        lesRute = new Scanner(fil);
        opprettBrett();
    }

    void opprettBrett(){
        String[] tall = lesRute.nextLine().split(" ");
        rad = Integer.parseInt(tall[0]);
        kolonne = Integer.parseInt(tall[1]);
        listeAvKnapper = new RuteKnapp[rad][kolonne];
        int xKoordinat = 0;
        int yKoordinat = 0;
        while (lesRute.hasNext()){
            String linje = lesRute.nextLine();
            for (int i = 0; i < linje.length(); i++){
                char tegnet = linje.charAt(i);
                String tegn = String.valueOf(tegnet);
                if(tegn.equals("#")){
                    RuteKnapp sort = new RuteKnapp(xKoordinat, yKoordinat, tegn, this, lab);
                    listeAvKnapper[xKoordinat][yKoordinat] = sort;
                }
                else if (tegn.equals(".")){
                    if (yKoordinat == 0 || yKoordinat == (kolonne-1) || xKoordinat == 0 || xKoordinat == (rad-1)) {
                        tegn = "X";
                        RuteKnapp utvei = new RuteKnapp(xKoordinat, yKoordinat, tegn, this, lab);
                        listeAvKnapper[xKoordinat][yKoordinat] = utvei;
                    }
                    else {
                        RuteKnapp hvit = new RuteKnapp(xKoordinat, yKoordinat, tegn, this, lab);
                        listeAvKnapper[xKoordinat][yKoordinat] = hvit;
                    }
                    
                }
                // Sørge for å gå videre over til neste kolonne
                yKoordinat++;
            }
            // Sørge for å nullstille verdien slik at vi starter fra første kolonne igjen
            yKoordinat = 0;
            // Sørge for at vi går over til neste rad
            xKoordinat++;
        }
        lesRute.close();
    }

    // Returnerer en boolean "true" hvis en sti er blitt vist i vinduet ellers "false"
    boolean nullstill() {
        boolean funnet = true;
        for(RuteKnapp[] liste: listeAvKnapper){
            for(RuteKnapp k: liste){
                if(k.getText().equals(k.skrivUt())){
                    lagLabyrinten.statustekst.setText("Brettet er nullstilt"); 
                    return funnet; 
                }
            }
        }
        funnet = false;
        return funnet;
    }

    RuteKnapp hentRute(int x, int y){
        return listeAvKnapper[x][y];
    }

    RuteKnapp[][] hentBrett(){
        return listeAvKnapper;
    }

    void initGUI() {
        setLayout(new GridLayout(rad, kolonne));
        for(RuteKnapp[] ruteliste: listeAvKnapper){
            for(RuteKnapp r: ruteliste){
                r.initGUI();
                add(r);
            }
        }
    }
}

class RuteKnapp extends JButton{
    RuteBrett brett;
    String tegn;
    ArrayList<RuteKnapp> utveiFraKnapp;
    Labyrint lab;
    int x, y, sjekk, teller;
    RuteKnapp(int x, int y, String tegn, RuteBrett brett, Labyrint lab){
        super(tegn);
        this.tegn = tegn;
        this.x = x;
        this.y = y;
        this.brett = brett;
        this.lab = lab;
    }

    // Returnerer stien til en gitt ruteKnapp, vil da hente ut den korteste stien
    ArrayList<RuteKnapp> hentStien(){
        utveiFraKnapp = new ArrayList<>();
        lab.finnUtveiFra(this.hentX(), this.hentY());
        brett.lagLabyrinten.statustekst.setText("Antall utveier fra ruten er: " + lab.hentAntUtveier());
        ArrayList<Tuppel> kortestSti = lab.hentKortesteUtvei();
        for (Tuppel t: kortestSti) {
            utveiFraKnapp.add(brett.hentRute(t.hentXKoordinat(), t.hentYKoordinat()));
        }
        return utveiFraKnapp;
    }

    int hentX(){
        return x;
    }

    int hentY(){
        return y;
    }

    String hentTegn(){
        return tegn;
    }

    String skrivUt(){
        String koordinater = "( " + x + ", " + y + ")";
        return koordinater;
    }

    void initGUI(){
        class VisUtvei implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent E) {
                // Hvis en sti er blitt visualisert, skal man kunne nullstille programmet like etter
                if(brett.nullstill() == true){
                    for(RuteKnapp[] lister: brett.hentBrett()){
                        for(RuteKnapp knapp: lister){
                            knapp.setText(knapp.hentTegn());
                            knapp.setForeground(Color.black);
                        }
                    }
                }
                else {
                    // Kun hviteRuteKnapper som kan initalisere stien, sørger for å endre teksten til knappene i stien
                    if(getText().equals(".")) {
                        setText("Start");
                        for (RuteKnapp nabo: hentStien()) {
                            if(nabo.getText().equals("X")) {
                                nabo.setText("Slutt");
                            }
                            else {
                                nabo.setText(nabo.skrivUt());
                                nabo.setForeground(Color.blue);
                            }
                        }
                    }
                    else {
                        brett.lagLabyrinten.statustekst.setText("Kan kun finne utveier fra '.' ruter, prøv igjen");
                    }
                }
            }
        }
    addActionListener(new VisUtvei());
    }
}
