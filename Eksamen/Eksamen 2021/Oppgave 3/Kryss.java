// Oppgave 3
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Kryss {

    private Sti[] listeAvStier;
    static int ANTALL_SETER = 4;
    // Setter ledigeplasser til å tilsvare 0
    private int ledigeplasser = 0;
    final Lock laas = new ReentrantLock(); 
    Condition ikkeLedigPlasser = laas.newCondition();

    Kryss(Sti[] listeAvStier){
        this.listeAvStier = listeAvStier;
    }

    public Sti hentTilfeldigSti(){
        int tilfeldig = Trekk.trekkInt(0, listeAvStier.length);
        return listeAvStier[tilfeldig];
    }

    public Boolean erIsolert(){
        for(Sti s: listeAvStier){
            if(s != null){
                return false;
            }
        }
        return true;
    }

    public void turgaaerKommer() throws InterruptedException{
        laas.lock();
        try {
            while (ledigeplasser > ANTALL_SETER){
                ikkeLedigPlasser.await();
            }
            ledigeplasser++;
            return;
        }
        finally{
            laas.unlock();
        }
        
    }



    
}
