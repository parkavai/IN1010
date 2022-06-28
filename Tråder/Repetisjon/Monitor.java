import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor {
    
    private LinkedList<Integer> tall = new LinkedList<>();
    private Lock laas = new ReentrantLock();
    private Condition tomListe = laas.newCondition();
    private int antallTrader, underAddering = 0;


    public Monitor(int antallTrader){
        this.antallTrader = antallTrader;
    }

    public void settInn(int nyttTall, boolean addertTall){
        laas.lock();
        try{
            tall.add(nyttTall);
            if(addertTall){
                underAddering--;
            }
            tomListe.signalAll();
        }finally{
            laas.unlock();
        }
    }

    public LinkedList<Integer> taUtTo(){
        laas.lock();
        try{
            while(tall.size() < 2){
                if(antallTrader == 0 && underAddering < 2) return null;
                tomListe.await();
            }
            LinkedList<Integer> returTall = new LinkedList<>();
            returTall.add(tall.remove(0));
            returTall.add(tall.remove(0));
            underAddering++;
            return returTall;
        }catch(InterruptedException e){
            return null;
        }finally{
            laas.unlock();
        }
    }

    public void ferdig(){
        laas.lock();
        try{
            antallTrader--;
        }finally{
            laas.unlock();
        }
    }

    public int hentSisteTall(){
        return tall.get(0);
    }
}