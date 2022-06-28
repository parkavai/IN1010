import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Random;

public class FredagsLunsj {
    public static void main(String[] args) {
        Pannekaker p = new Pannekaker();
        Groet g = new Groet();
        CountDownLatch barriere = new CountDownLatch(435);
        int antall = 0;
        for (int i = 0; i < 435; i++){
            Random rd = new Random(); 
            SjekkLunsj runnabl = new SjekkLunsj(rd.nextBoolean(), p, g, barriere);
            Thread traad = new Thread(runnabl);
            traad.start();
            antall ++;
        }
        try {
            barriere.await();
        }
        catch (InterruptedException e){
            System.out.println("Skjedde feil");
        }
        if (p.hentAntallPannekaker() > g.hentAntallGroet()){
            System.out.println("Det blir pannekaker på fredag.");
        }
        else if (p.hentAntallPannekaker() == g.hentAntallGroet()){
            System.out.println("Blir både pannekaker og grøt på fredag.");
        }
        else {
            System.out.println("Det blir grøt på fredag.");
        }
    }
    
}

class SjekkLunsj implements Runnable {
    boolean lunsj;
    CountDownLatch barriere;
    Pannekaker p;
    Groet g;

    SjekkLunsj(boolean lunsj, Pannekaker p, Groet g, CountDownLatch barriere){
        this.lunsj = lunsj;
        this.barriere = barriere;
        this.p = p;
        this.g = g;
    }

    public void run(){
       try {
           sjekker();
           Thread.sleep(100);
           barriere.countDown();
       }
       catch (InterruptedException e){
           System.out.println("Jimmy");
       }
    }

    void sjekker(){
        if (lunsj == true){
            g.oekAntallGroet();
        }
        else {
            p.oekAntallPannekaker();
        }
    }
}

class Pannekaker{
    int antall;

    void oekAntallPannekaker(){
        antall++;
    }

    int hentAntallPannekaker(){
        return antall;
    }
}

class Groet{
    int antall;

    void oekAntallGroet(){
        antall++;
    }

    int hentAntallGroet(){
        return antall;
    }
}
