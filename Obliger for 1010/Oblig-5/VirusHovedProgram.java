import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class VirusHovedProgram {
    public static void main(String[] args) {
        HashMapBeholder sykePersonerBeholder = new HashMapBeholder();
        MonitorForHashBeholder monitorForSyke = new MonitorForHashBeholder(sykePersonerBeholder);
        HashMapBeholder friskePersonerBeholder = new HashMapBeholder();
        MonitorForHashBeholder monitorForFriske = new MonitorForHashBeholder(friskePersonerBeholder);
        ArrayList<String> listeAvFiler = new ArrayList<>();
        Thread Trader = null;
        int sykeTrader = 0;
        int friskeTrader = 0;
        CountDownLatch barriere;
        CountDownLatch barriereSyke;
        CountDownLatch barriereFriske;
        // For aa teste programmet, angi classpathen som vist i terminalen og skriv "metadatafil.csv" for aa teste programmet
        // Dette maa ogsaa gjoeres for TradForLesInn linje 30
        System.out.println(System.getProperty("user.dir"));
        try {
            Scanner leser = new Scanner(new File("/Users/fyll Inn/Oblig-5/Data/metadata.csv"));	
            String foersteLinje = leser.nextLine();
            String linje;		
            System.out.println("");
            System.out.println(" TestProgram for oblig-5 " + "\n");
	    	while(leser.hasNextLine()) {
				linje = leser.nextLine();   
                linje = linje.trim();
                listeAvFiler.add(linje);
                String[] delt = linje.split(",");
                if(delt[1].equals("True")){
                    sykeTrader++;
                }
                if(delt[1].equals("False")){
                    friskeTrader++;
                }
            }
            System.out.println("Syketraader som skal lages er: " + sykeTrader);
            System.out.println("Frisketraader som skal lages er: " + friskeTrader + "\n");
            leser.close();
        }
        catch (FileNotFoundException exception) {
            System.out.println("FEIL i filInnlesningen, husk aa bruke metadatafilen."); 
            System.exit(1);
        }

        int antallTrader = (friskeTrader+sykeTrader);
        barriere = new CountDownLatch(antallTrader);
        for (String filen: listeAvFiler){
            String[] delt = filen.split(",");
            String fil = delt[0];
            if (delt[1].equals("True")){
                TradForLesInn runAblForSyke = new TradForLesInn(monitorForSyke, fil, barriere);
                Trader = new Thread(runAblForSyke);
                Trader.start();
            }
            if (delt[1].equals("False")){
                TradForLesInn runAblForFriske = new TradForLesInn(monitorForFriske, fil, barriere);
                Trader = new Thread(runAblForFriske);
                Trader.start();
            }
        }

        try {
            barriere.await();
        }
        catch (InterruptedException e){
            System.out.println("Skjedde noe galt ved lesinntradene.");
        }

        System.out.println("Oversikt over antall hashMaps i sykebeholder etter filinnlesning: " + sykePersonerBeholder.hentAntallHashMaps() + "\n");	
        System.out.println("Oversikt over antall hashMaps i friskebeholder etter filinnlesning: " + friskePersonerBeholder.hentAntallHashMaps() + "\n");	

        barriereSyke = new CountDownLatch(sykeTrader);
        for(int i = 0; i < sykeTrader; i++){
            TradForFletting runAblFlettingForSyke = new TradForFletting(monitorForSyke, barriereSyke);
            Trader = new Thread(runAblFlettingForSyke);
            Trader.start();
        }

        try {
            barriereSyke.await();
        }
        catch (InterruptedException e){
            System.out.println("Skjedde noe galt ved fletting for sykbeholderen.");
        }

        barriereFriske = new CountDownLatch(friskeTrader);
        for(int i = 0; i < friskeTrader; i++){
            TradForFletting runAblFlettingForFriske = new TradForFletting(monitorForFriske, barriereFriske);
            Trader = new Thread(runAblFlettingForFriske);
            Trader.start();
        }
        
        try {
            barriereFriske.await();
        }
        catch (InterruptedException e){
            System.out.println("Skjedde noe galt ved fletting for friskbeholderen.");
        }

        System.out.println("Oversikt over antall hashMaps i sykebeholder etter fletting: " + sykePersonerBeholder.hentAntallHashMaps() + "\n");	
        System.out.println("Oversikt over antall hashMaps i friskbeholder etter fletting: " + friskePersonerBeholder.hentAntallHashMaps() + "\n");	

        skrivUtResultat(sykePersonerBeholder, friskePersonerBeholder);
    }

    static void skrivUtResultat(HashMapBeholder sykeBeholder, HashMapBeholder friskeBeholder) {
        HashMap<String,SubSekvens> syke = sykeBeholder.taUtHashMap();
        HashMap<String,SubSekvens> friske = friskeBeholder.taUtHashMap();
        int antall = 0;
        for (String dominante: syke.keySet()){
            if(friske.containsKey(dominante)){
                int forskjell = (syke.get(dominante).hentAntallForekomster() - friske.get(dominante).hentAntallForekomster());
                if(forskjell >= 5) {
                    antall ++;
                    System.out.println("Viruset: " + dominante + " sin forskjell mellom syke og friske var " + forskjell);
                    System.out.println("Totalt syke pasienter som har viruset er: " + syke.get(dominante).hentAntallForekomster()); 
                    System.out.println("Totalt friske pasienter som hadde viruset er: " + friske.get(dominante).hentAntallForekomster() + "\n");
                }
            }
        }
        System.out.println("Antall virus som ble skrevet ut: " + antall);
    }

}