import java.util.concurrent.CountDownLatch;

public class Produsent implements Runnable{

    private int leggeTilTall;
    private Monitor monitor;
    private CountDownLatch cdl;

    public Produsent(int leggeTilTall, Monitor monitor, CountDownLatch cdl){
        this.leggeTilTall = leggeTilTall;
        this.monitor = monitor;
        this.cdl = cdl;
    }

    @Override
    public void run(){
        try {
            monitor.settInnTall(leggeTilTall);
            cdl.countDown();
        }
        catch(InterruptedException e){
            System.out.println("Skjedde noe galt produsent-tråden.");
        }

    }
    
}
