import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class TestCD {
    public static void main(String[] args) throws FileNotFoundException{
        File fil = new File("cdliste.txt");
        CDSamling samling = new CDSamling();
        for(CDAlbum cd: samling.lesOgSorter(fil)){
            System.out.println(cd.toString());
        }
        
    }


}

class CDAlbum implements Comparable<CDAlbum>{

    String artistnavn, albumnavn, utgivelsesaar;

    CDAlbum(String artistnavn, String albumnavn, String utgivelsesaar){
        this.artistnavn = artistnavn;
        this.albumnavn = albumnavn;
        this.utgivelsesaar = utgivelsesaar;
    }

    public String hentArtistNavn(){
        return this.artistnavn;
    }

    public int compareTo(CDAlbum annenCdAlbum){
        return this.albumnavn.length()-annenCdAlbum.albumnavn.length();
    }

    public String toString(){
        String helLinje = "Artistnavn: " + artistnavn + "\n";
        helLinje += "Albumnavn: " + albumnavn + "\n";
        helLinje += "Utgivelsesår: " + utgivelsesaar + "\n";
        return helLinje; 
    }

}

class CDSamling {

    public static ArrayList<CDAlbum> lesOgSorter(File filnavn) {

        Scanner fscan = null;
        try {
            fscan = new Scanner(filnavn);
        }
        catch (FileNotFoundException e) {
            System.out.println("Fant ikke filen!");
            return null;
        }

        ArrayList<CDAlbum> liste = new ArrayList<CDAlbum>();

        while (fscan.hasNextLine()) {
            String[] linje = fscan.nextLine().split(",");
            CDAlbum nytt = new CDAlbum(linje[0], linje[1], linje[2]);

            boolean sattInn = false;
            int teller = 0;

            while (teller < liste.size() && !sattInn) {
                if (nytt.compareTo(liste.get(teller)) < 0) {
                    liste.add(teller, nytt);
                    sattInn = true;
                }
                teller++;
            }

            if (!sattInn) {
                liste.add(nytt);
            }
        }
        return liste;
    }

}