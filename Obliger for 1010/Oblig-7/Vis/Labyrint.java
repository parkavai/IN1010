import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;

public class Labyrint extends JButton{

    private Rute[][] ruteArray;
    private ArrayList<ArrayList<Tuppel>> utveier;
    private Scanner lesRute;
    private int rad;
    private int kolonne;

    public Labyrint(File filnavn) throws FileNotFoundException{
        lesRute = new Scanner(filnavn);
        lagLabyrint();
    }


    private void lagLabyrint(){
        String[] tall = lesRute.nextLine().split(" ");
        rad = Integer.parseInt(tall[0]);
        kolonne = Integer.parseInt(tall[1]);
        ruteArray = new Rute[rad][kolonne];
        int xKoordinat = 0;
        int yKoordinat = 0;
        while (lesRute.hasNext()){
            String linje = lesRute.nextLine();
            for (int i = 0; i < linje.length(); i++){
                char tegn = linje.charAt(i);
                if(tegn == '#'){
                    SortRute sort = new SortRute(xKoordinat, yKoordinat, this);
                    ruteArray[xKoordinat][yKoordinat] = sort;
                }
                else if (tegn == '.'){
                    if (yKoordinat == 0 || yKoordinat == (kolonne-1) || xKoordinat == 0 || xKoordinat == (rad-1)) {
                        Aapning utvei = new Aapning(xKoordinat, yKoordinat, this);
                        ruteArray[xKoordinat][yKoordinat] = utvei;
                    }
                    else {
                        HvitRute hvit = new HvitRute(xKoordinat, yKoordinat, this);
                        ruteArray[xKoordinat][yKoordinat] = hvit;
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

        for (int x = 0; x < rad; x++) {
            for (int y = 0; y < kolonne; y++) {
                Rute foreloepigRute = ruteArray[x][y];
                Rute nord, soer, oest, vest;
                if (x == 0){
                    nord = null;
                    soer = ruteArray[x+1][y];
                }
                else if(x == (rad-1)) { 
                    nord = ruteArray[x-1][y];
                    soer = null;
                }
                else {
                    nord = ruteArray[x-1][y];
                    soer = ruteArray[x+1][y];
                }

                if (y == 0){
                    oest = ruteArray[x][y+1];
                    vest = null;
                }
                else if (y == (kolonne-1)){
                    oest = null;
                    vest = ruteArray[x][y-1];
                }
                else {
                    oest = ruteArray[x][y+1];
                    vest = ruteArray[x][y-1];
                }
                foreloepigRute.hentNaboer(nord, soer, oest, vest);
            }
        }
    }

    // Legger til stien fra åpningsklassen skulle en sti ha en åpning
    public void leggTilSti(ArrayList<Tuppel> sti){
        utveier.add(sti);
    }

    public ArrayList<ArrayList<Tuppel>> finnUtveiFra(int rad, int kol){
        utveier = new ArrayList<>();
        Rute skalSjekkeUtvei = ruteArray[rad][kol];
        skalSjekkeUtvei.finnUtvei();
        return utveier;
    }

    public int hentAntUtveier() {
        return utveier.size();
    }

    public ArrayList<Tuppel> hentKortesteUtvei(){
        ArrayList<Tuppel> kortesteUtvei = new ArrayList<>();
        kortesteUtvei = utveier.get(0);
        int minst = utveier.get(0).size();
        for (int i = 1; i < utveier.size(); i++) {
            if(utveier.get(i).size() < minst){
                minst = utveier.get(i).size();
                kortesteUtvei = utveier.get(i);
            }
        }
        return kortesteUtvei;
    }
    
    public String toString() {
        String helLinje = "";
        for (Rute[] liste : ruteArray){
            for (Rute rute : liste){
                helLinje += rute.tilTegn();
            }
            helLinje += "\n";
        }
        return helLinje;
    }
        
}
    
    

