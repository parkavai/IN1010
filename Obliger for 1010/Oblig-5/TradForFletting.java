import java.util.concurrent.CountDownLatch;

public class TradForFletting implements Runnable{
    MonitorForHashBeholder monitor;
    CountDownLatch fletteLatch;

    public TradForFletting(MonitorForHashBeholder monitor, CountDownLatch fletteLatch){
        this.monitor = monitor;
        this.fletteLatch = fletteLatch;
    }

    public void run(){
        try {
            monitor.lasForFletting();
            fletteLatch.countDown();
        }

        catch(InterruptedException e){
            System.out.println("Skjedde feil ved fletting-run");
        }
    }

    
}
