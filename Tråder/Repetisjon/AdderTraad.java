import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;

class AdderTraad implements Runnable{

    private Monitor monitor;
    private CountDownLatch cdl;

    public AdderTraad(Monitor monitor, CountDownLatch cdl){
        this.monitor = monitor;
        this.cdl = cdl;
    }

    @Override
    public void run(){
        LinkedList<Integer> tall = monitor.taUtTo();
        while(tall != null){
            int sum = tall.get(0) + tall.get(1);
            monitor.settInn(sum, true);
            tall = monitor.taUtTo();
        }

        cdl.countDown();
    }
    
}