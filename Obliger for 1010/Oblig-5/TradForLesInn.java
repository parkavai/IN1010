import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TradForLesInn implements Runnable{
    static int subSekvensLengde = 3;
    MonitorForHashBeholder monitor;
    String filnavn;
    CountDownLatch latch;
    public TradForLesInn(MonitorForHashBeholder monitor, String filnavn, CountDownLatch latch) {
        this.monitor = monitor;
        this.filnavn = filnavn;
        this.latch = latch;
    }
    
    public void run() {
        try {
            monitor.lasForLeggTil(lesInnFil(filnavn));
            Thread.sleep(10);
            latch.countDown();
        }
        catch (InterruptedException e){
            System.out.println(e);
        }
    }

    HashMap<String,SubSekvens> lesInnFil(String filnavn) {
        File fil = new File("/Users/Fyll inn/Oblig-5/Data/metadata.csv" + filnavn);
        HashMap <String, SubSekvens> virusOrdbok = new HashMap<>();
        try{
            Scanner leser = new Scanner(fil);
            String linje = "";
            String foersteLinje = leser.nextLine();
            while(leser.hasNextLine()) {
                linje = leser.nextLine();
                int lengde = linje.length();
                for (int i = 0; (i+subSekvensLengde) <= lengde; i++){
                    String nySubStreng = linje.substring(i, (i+subSekvensLengde));
                    SubSekvens subSekvens = new SubSekvens(nySubStreng);
                    if (!(virusOrdbok.containsKey(nySubStreng))){
                        virusOrdbok.put(nySubStreng, subSekvens);
                    }
                } 
            }
        leser.close();
        }
        catch(FileNotFoundException exception){
            System.out.println("Fant ikke filen" + filnavn);
        }
        return virusOrdbok;
        
}


}