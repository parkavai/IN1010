import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Labyrint {

    private Rute[][] ruteArray;
    private ArrayList<ArrayList<Tuppel>> utveier;
    private File filnavn;
    private Scanner lesRute;
    private int rad;
    private int kolonne;

    public Labyrint(File filnavn) throws FileNotFoundException{
        utveier = new ArrayList<>();
        lesRute = new Scanner(filnavn);
        this.filnavn = filnavn;
        lagLabyrint();
        System.out.println(this.toString());
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

    public ArrayList<Tuppel> hentKortesteUtvei(){
        int minst = 0;
        int[] lengdePaaUtveier = new int[utveier.size()];
        ArrayList<Tuppel> kortesteUtvei = null;
        for (int i = 0; i < utveier.size(); i++) {
            lengdePaaUtveier[i] = utveier.get(i).size();
        }
        minst = lengdePaaUtveier[0];
        kortesteUtvei = utveier.get(0);
        System.out.println(kortesteUtvei);
        for(int teller = 0; teller < lengdePaaUtveier.length; teller++){
            if(lengdePaaUtveier[teller] < minst){
                minst = lengdePaaUtveier[teller];
                kortesteUtvei = utveier.get(teller);
                System.out.println(kortesteUtvei);
            }
        }
        return kortesteUtvei;
    }

    // Legger til stien fra åpningsklassen skulle en sti ha en åpning
    public void leggTilSti(ArrayList<Tuppel> sti){
        utveier.add(sti);
    }

    public ArrayList<ArrayList<Tuppel>> finnUtveiFra(int rad, int kol){
        Rute skalSjekkeUtvei = ruteArray[rad][kol];
        skalSjekkeUtvei.finnUtvei();
        return utveier;
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
    
    

