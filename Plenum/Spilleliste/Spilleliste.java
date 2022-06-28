import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Spilleliste{
    private String navn;
    private ArrayList<Sang> sanger;

    public Spilleliste(String listenavn){
        navn = listenavn;
        sanger = new ArrayList<Sang>();
    }
    public void lesFraFil(String filnavn){
        File fil = new File(filnavn);
        Scanner in;
        try{
            in = new Scanner(fil);
        }catch(FileNotFoundException exception){
            System.out.println("Fant ikke filen");
            in = new Scanner("");
        }
        while(in.hasNextLine()){
            String linje = in.nextLine();
            String[] alleData = linje.split(";");
            // tittel;Elton John, Kiki Dee
            String[] artistene = alleData[1].split(",");
            Sang nySang = new Sang(alleData[0],artistene);
            sanger.add(nySang);

        }
        in.close();

    }

    public void leggTilSang(Sang sang){
        sanger.add(sang);
    }
    public void fjernSang(Sang sang){
        sanger.remove(sang);
    }
    public void spillSang(Sang sang){
        sang.spill();
    }
    public void spillAlle(){
        for(int i = 0; i < sanger.size(); i ++){
            sanger.get(i).spill();
        }
    }
    public ArrayList<Sang> hentArtistUtvalg(String artist){
        //Denne fikk vi ikke tid til, da blir det hjemmelekse!
        return new ArrayList<Sang>();
        //return null; <- mulig men det blir trøbbel! Hva er forskjellen?
    }


}
