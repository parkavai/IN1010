import java.util.concurrent.locks.Lock;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class MonitorForBokstavTeller {

    ArrayList<String> listeAvOrd;
    Lock las;

    MonitorForBokstavTeller(ArrayList<String> listeAvOrd){
        this.listeAvOrd = listeAvOrd;
        las = new ReentrantLock();
    }

    String hentOrd(){
        las.lock();
        try {
            if(listeAvOrd.size() == 0){
               return null;
            }
            return listeAvOrd.remove(listeAvOrd.size()-1);
        }
        finally {
            las.unlock();
        }
    }



    
}
