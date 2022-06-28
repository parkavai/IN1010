import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CountDownLatch;

class TestProgram {

    public static void main(String[] args) {
        int antallProdusentTrader = 12;
        int antallKonsumentTrader = 6;
        CountDownLatch cdl = new CountDownLatch(antallProdusentTrader + antallKonsumentTrader);
        Monitor monitor = new Monitor(antallKonsumentTrader);
        for(int i = 1; i < antallProdusentTrader + 1; i++){
            Produsent runnableForProdusent = new Produsent(i, monitor, cdl);
            Thread traadProdusent = new Thread(runnableForProdusent);
            traadProdusent.start();
        }   
        for(int i = 0; i < antallKonsumentTrader; i++){
            Konsument runnableForKonsument = new Konsument(monitor, cdl);
            Thread traadKonsument = new Thread(runnableForKonsument);
            traadKonsument.start();
        }   
        try {
            cdl.await();
        }
        catch (InterruptedException e){
            System.out.println("Skjedde noe galt ved main-tråden");
            System.exit(1);
        }
        int total = 0;
        for(int i : monitor.hentSummertListe()){
            total += i;
        }
        System.out.println("Samlet sum er : " + total);
    }

}