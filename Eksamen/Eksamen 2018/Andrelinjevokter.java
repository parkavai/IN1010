public class Andrelinjevokter implements Runnable {
    MistenkeligPersoner monitor;
    Andrelinjevokter(MistenkeligPersoner monitor){
        this.monitor = monitor;
    }

    @Override
    public void run(){
        try {
            Passasjer mistenkt = monitor.hentUtMistenkte();
            Hovedprogram.mistenkelig(mistenkt);
        }
        catch(InterruptedException e){
            System.out.println("Skjedde feil ved andrelinjevokter");
        }

    }
    
}
