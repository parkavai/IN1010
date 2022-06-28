import java.util.Scanner;

class TradKlokke2 {
	public static void main (String [] args) {
		Scanner minInn = new Scanner (System.in);
		Runnable minR = new TradRKlokke1();
		Thread traden  = new Thread(minR);
		System.out.println(" Stoppeklokke");
		System.out.println(" Tast CR for å stoppe og starte");
		minInn.nextLine();
		
		traden.start();
		
		minInn.nextLine();
		
		//traden.interrupt();
		((TradRKlokke1)minR).stopp();
		
		System.out.println(" Takk for naa  "   );
	}
}
class TradRKlokke1 implements Runnable {

    public void stopp() { 
        fortsett = false;
    }
	private volatile boolean fortsett = true;
	public void run() {
		int klokka = 0;
		try {
			while (fortsett) {		
				Thread.sleep(1000);
				System.out.println(klokka);
				klokka ++;
			}
		}
		catch (InterruptedException i) {
			System.out.println(" Klokka er ferdig");	
		}
	}
}
