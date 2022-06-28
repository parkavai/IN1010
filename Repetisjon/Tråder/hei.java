import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class hei {

    public static void main(String[] args) {
        int antallTraader = 8;
        CyclicBarrier barrier = new CyclicBarrier(antallTraader);
        for(int i = 0; i < antallTraader; i++){
            Runnable runnable = new TraadHei(barrier, i);
            Thread t = new Thread(runnable);
            t.start();
        }
    }
    
}

class TraadHei implements Runnable {
    private CyclicBarrier barrier;
    private int id;

    public TraadHei(CyclicBarrier barrier, int id){
        this.barrier = barrier;
        this.id = id;
    }


  @Override
  public void run(){
    System.out.println(id + "sier hei den første gangen");
    try{
      barrier.await();
    }
    catch(Exception e){
      System.out.println(e);
    }

    System.out.println(id + "sier hei den andre gangen");

    try{
        barrier.await();
    }
    catch(Exception e){
        System.out.println(e);
    }

    System.out.println(id + "sier hei den tredje gangen");
  }

}
