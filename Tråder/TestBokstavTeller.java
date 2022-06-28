import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class TestBokstavTeller {

    public static void main(String[] args) {
        ArrayList<String> listeOrd = new ArrayList<>();
        listeOrd.add("Jimmy");
        listeOrd.add("Hei");
        listeOrd.add("Lamaipyjamas");
        listeOrd.add("SaaaaK");
        listeOrd.add("Raawr");
        listeOrd.add("Loool");
        listeOrd.add("Ommmmmmg");
        CountDownLatch barriere = new CountDownLatch(7);
        int lengde = listeOrd.size();
        MonitorForBokstavTeller monitor = new MonitorForBokstavTeller(listeOrd);
        for(int i = 0; i < lengde; i++){
            BokstavTeller runnabl = new BokstavTeller(monitor, barriere);
            Thread traad = new Thread(runnabl);
            traad.start();
        }
        try {
            barriere.await();
        }
        catch (InterruptedException e){
            System.out.println("Skjedde noe galt ved barrieren.");
        }
        System.out.println("Antallet i listen av ord etter kjøring av tråder: " + listeOrd.size());

    }
    
}
