import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MistenkeligPersoner {

    Prioritetskoe<Passasjer> listeAvEnhverMistenkt;
    Lock las;
    Condition erTom;

    MistenkeligPersoner(){
        listeAvEnhverMistenkt = new Prioritetskoe<>();
        las = new ReentrantLock();
        erTom = las.newCondition();

    }

    public void leggTilMistenkte(Passasjer mistenkt, int prio) throws InterruptedException{
        las.lock();
        try {
            listeAvEnhverMistenkt.settInn(mistenkt, prio);
            erTom.signalAll();
        }
        finally{
            las.unlock();
        }
    }

    public Passasjer hentUtMistenkte() throws InterruptedException{
        las.lock();
        try {
            while(listeAvEnhverMistenkt.antall() < 1){
                erTom.await();
            }
            return listeAvEnhverMistenkt.taUt();
        }
        finally{
            las.unlock();
        }
    }
    
}
