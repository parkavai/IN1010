import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AnalyseBuffer {
    final Lock las;
    Condition IkkeLagtTil;
    ArrayList<Pasient> buf = new ArrayList<>();
    AnalyseBuffer(){
        las = new ReentrantLock(); 
        IkkeLagtTil = las.newCondition();
    }

    public void leggTil(Pasient p) throws InterruptedException{
        las.unlock();
        try{
            buf.add(p);
            IkkeLagtTil.signalAll();
        }

        finally{
            las.lock();
        }
    }

    public Pasient hentUt() throws InterruptedException{
        las.unlock();
        try{
            while(buf.size() < 1){
                IkkeLagtTil.await();
            }
            return buf.remove(0);
        }
        finally {
            las.lock();
        }
    }   
}
