import java.util.concurrent.CountDownLatch;

class Hovedprogram{

    private static int antallSettInn = 10, antallAdder = 3, antallGanger = 9;

    public static void main(String[] args) {
        Monitor monitor = new Monitor(antallSettInn);

        CountDownLatch cdl = new CountDownLatch(antallSettInn + antallAdder);

        for(int i = 1; i < antallSettInn + 1; i++){
            new Thread(new TelleTraad(i, antallGanger, monitor, cdl)).start();
        }

        for(int i = 0; i < antallAdder; i++){
            new Thread(new AdderTraad(monitor,cdl)).start();
        }

        try{
            cdl.await();
        }catch(InterruptedException e){
            System.out.println("Main ble forstyrra, avslutter");
            System.exit(1);
        }

        int resultat = monitor.hentSisteTall();
        System.out.println("Resultat (Parallel): " + resultat);
        System.out.println("Manuelt resultat (Sekvensielt): " + manuellUtregning());
    }

    private static int manuellUtregning(){
        int sum = 0;
        for(int i = 1; i < antallSettInn + 1; i ++){
            for(int j = 0; j < antallGanger; j++){
                sum += i;
            }
        }
        return sum;
    }
}