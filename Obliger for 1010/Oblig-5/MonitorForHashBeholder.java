import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MonitorForHashBeholder {
    final Lock las = new ReentrantLock(); 
    private HashMapBeholder beholder;


    public MonitorForHashBeholder(HashMapBeholder beholder){
        this.beholder = beholder;
    }

    public void lasForLeggTil(HashMap<String,SubSekvens> hashMapFraFil) throws InterruptedException{
        las.lock();
            try {
                beholder.leggeTilHashMap(hashMapFraFil);
            }
            finally {
                las.unlock();
            }
    }

    public void lasForFletting() throws InterruptedException{
        las.lock();
        try {
            if (beholder.hentAntallHashMaps() > 1){
            HashMap<String, SubSekvens> map1 = beholder.taUtHashMap();
            HashMap<String, SubSekvens> map2 = beholder.taUtHashMap();
            beholder.leggeTilHashMap(beholder.fletting(map1, map2));
            }
        }

        finally{
            las.unlock();
        }
    }
}
