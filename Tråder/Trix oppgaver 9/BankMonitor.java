import java.util.concurrent.locks.*;

public class BankMonitor {
    int pengebelop = 0;
    Lock laas = new ReentrantLock();

    public void ta(int belop){
        laas.lock();
        try {
            pengebelop -= belop;
        }
        finally {
            laas.unlock();
        }
    }

    public void gi(int belop){
        laas.lock();
        try {
            pengebelop += belop;
        }
        finally {
            laas.unlock();
        }
    }

    public int saldo(){
        return pengebelop;
    }




    
}
