import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Conditon;

public class Monitor {
    final Lock las;
    final Condition betingelse;

    Monitor(){
        las = new ReentrantLock();
        betingelse = las.newCondition();
        // las.lock() før try så las.unlock() i finally
    }
}
