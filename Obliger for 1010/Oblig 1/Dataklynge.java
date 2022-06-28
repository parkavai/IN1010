import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Dataklynge {

    private ArrayList<Rack> listeAvRack;
    private int antNoderPerRack;

    /*
    Dataklynge(int antNoderPerRack){
        listeAvRack = new ArrayList<>();
        this.antNoderPerRack = antNoderPerRack;
    }
    */
    
    Dataklynge(File fil){
        listeAvRack = new ArrayList<>();
        lesInnFil(fil);
    }

    public void lesInnFil(File fil) {
        Scanner lesFil = null;
        try {
            lesFil= new Scanner(fil);
        }
        catch(FileNotFoundException e){
            System.out.println("Fant ikke filen ");
            System.exit(1);
        }
        antNoderPerRack = Integer.parseInt(lesFil.nextLine());
        String linje;
        while (lesFil.hasNextLine()){
            linje = lesFil.nextLine();
            String[] data = linje.split(" ");
            int antNoder = Integer.parseInt(data[0]);
            int antMinne = Integer.parseInt(data[1]);
            int antProsessor = Integer.parseInt(data[2]);
            for(int i = 0; i < antNoder; i++){
                leggTilNodeIRack(new Node(antMinne, antProsessor));
            }
        }
        lesFil.close();

    }

    public void leggTilRack(Rack r){
        listeAvRack.add(r);
    }

    public void leggTilNodeIRack(Node n){
        int teller = 0;
        for(Rack r: listeAvRack){
            if(r.hentAntallNoder() < antNoderPerRack){
                r.leggTilNode(n);
            }
            else {
                teller++;
            }
        }
        if(teller == listeAvRack.size()){
            Rack nyRack = new Rack();
            nyRack.leggTilNode(n);
            leggTilRack(nyRack);
        }
    }

    public int antallProsessorer(){
        int antProsessorer = 0;
        for(Rack r: listeAvRack){
            antProsessorer += r.antallProsessorer();
        }
        return antProsessorer;
    }
    
    public int hentAntRacks(){
        return listeAvRack.size();
    }

    public int noderMedNokMinne(int paakrevdMinne){
        int antallNoder = 0;
        for(Rack r: listeAvRack){
            antallNoder += r.noderMedNokMinne(paakrevdMinne);
        }
        return antallNoder;
    }

    public String toString(){
        String helLinje = "";
        helLinje += "Noder med minst 32 GB: " + noderMedNokMinne(32) + "\n";
        helLinje += "Noder med minst 64 GB: " + noderMedNokMinne(64) + "\n";
        helLinje += "Noder med minst 128 GB: " + noderMedNokMinne(128) + "\n" + "\n";
        helLinje += "Antall prosessorer: " + antallProsessorer() + "\n";
        helLinje += "Antall racks: " + hentAntRacks();
        return helLinje;
    }
}
