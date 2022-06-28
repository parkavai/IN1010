import java.util.concurrent.CountDownLatch;

public class Konsument implements Runnable{

    private Monitor monitor;
    private CountDownLatch cdl;

    public Konsument (Monitor monitor, CountDownLatch cdl){
        this.monitor = monitor;
        this.cdl = cdl;
    }

    @Override
    public void run(){
        try {
            monitor.taUtToTall();
            cdl.countDown();
        }
        catch (InterruptedException e){
            System.out.println("Skjedde noe galt ved konsument tråden");
        }
    }
    
}
