import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor {
    private ArrayList<Integer> array = new ArrayList<>();
    private Lock laas = new ReentrantLock();
    private Condition ikkeTaUtEnda = laas.newCondition();
    private int antKonsumentTraader;
    private ArrayList<Integer> listeAvSum = new ArrayList<>();

    public Monitor(int antKonsumentTraader){
        this.antKonsumentTraader = antKonsumentTraader;
    }

    public void settInnTall(int tall) throws InterruptedException{
        laas.lock();
        try{
            array.add(tall);
            if (array.size() == 2){
                // Betyr at konsument-tråder kan ta ut 2 tall og returnere summen av de to tallene
                ikkeTaUtEnda.signal();
            }
        }
        finally{
            laas.unlock();
        }
    }

    public void taUtToTall() throws InterruptedException{
        laas.lock();
        try{
            while (array.size() < 2){
                // Kan ikke ta ut to tall fra listen hvis det ikke er to tall i listen
                ikkeTaUtEnda.await();
            }
            int tall1 = array.remove(0);
            int tall2 = array.remove(0);
            listeAvSum.add(tall1+tall2);
            antKonsumentTraader--;
        }
        finally{
            laas.unlock();
        }   
    }

    public ArrayList<Integer> hentSummertListe() {
        return listeAvSum;
    }
}
