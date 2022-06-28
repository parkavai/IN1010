import java.util.Scanner;

class TradKlokke {
	public static void main (String [] args) {
		Scanner minInn = new Scanner (System.in);
		Runnable minR = new TradRKlokke();
		Thread traden  = new Thread(minR);
		System.out.println(" Stoppeklokke");
		System.out.println(" Tast CR for aa stoppe og starte");
		minInn.nextLine();
		
		traden.start();
		
		minInn.nextLine();

		traden.interrupt();
		
		System.out.println(" Takk for naa  "   );
	}
}

class TradRKlokke implements Runnable {
	public void run() {
		int klokka = 0;
		try {
			while (true) {		
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