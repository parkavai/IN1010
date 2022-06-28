import java.util.concurrent.CountDownLatch;

class TelleTraad implements Runnable{

    private int id, antallGanger;
    private Monitor monitor;
    private CountDownLatch cdl;

    public TelleTraad(int id, int antallGanger, Monitor monitor, CountDownLatch cdl){
        this.id = id;
        this.antallGanger = antallGanger;
        this.monitor = monitor;
        this.cdl = cdl;
    }

    @Override
    public void run(){
        for(int i = 0; i < antallGanger; i++){
            monitor.settInn(id, false);
        }
        monitor.ferdig();
        cdl.countDown();
    }
    
}