import java.util.concurrent.CountDownLatch;

public class BokstavTeller implements Runnable{

/*
    String ord;
    char bokstav;
    int antall = 0;

    BokstavTeller(String ord, char bokstav){
        this.ord = ord;
        this.bokstav = bokstav;
    }

    public void run(){
        for(int i = 0; i < ord.length(); i++){
            char sjekk = ord.charAt(i);
            if(sjekk == bokstav){
                antall++;
            }
        }
        System.out.println("Antall forekomster av bokstaven: " + bokstav + " i strengen" + ord + " tilsvarer: " + antall);
    }
*/
    MonitorForBokstavTeller monitor;
    CountDownLatch barriere;
    BokstavTeller(MonitorForBokstavTeller monitor, CountDownLatch barriere){
        this.monitor = monitor;
        this.barriere = barriere;
    }

    @Override
    public void run(){
        sjekkOrd();
        barriere.countDown();
    }

    public void sjekkOrd(){
        String ord = monitor.hentOrd();
        int antall = 0;
        if(ord == null){
            return;
        }
        char bokstav = ord.charAt(1);
        for(int i = 0; i < ord.length(); i++){
            char sjekk = ord.charAt(i);
            if(sjekk == bokstav){
                antall++;
            }
        }
        System.out.println("Antall forekomster av bokstaven: " + bokstav + " i strengen " + ord + " tilsvarer: " + antall);
    }
}
