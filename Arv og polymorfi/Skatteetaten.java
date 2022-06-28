// For lange innrykk fordi TAB på IN1010-siden er større enn TAB i min tekstbehandler
import java.util.Scanner;
public class Skatteetaten {
        public static void main (String [ ] args) {
		Scanner minInn = new Scanner (System.in);
		String linje;
		char type;
		Bil nyBil = null;
		double pris;
		String bilnr;
		
		System.out.println(" Velkommen til Skatteetaten ");
		System.out.print(" Hvor mange kjøretøy vil du registrere ");	 
		linje = minInn.nextLine();
		int antall = Integer.parseInt(linje.trim());
		
		Bil [ ] alleBiler = new Bil [antall];
		
		for (int index = 0; index < antall; index ++ )  {
		     System.out.println(" Registrer bil nr " + (index + 1));
		     System.out.print("Bilnummer : ");	
		     linje = minInn.nextLine();
		     bilnr = linje.trim();
		     System.out.print("L (lastebil), P (personbil) eller T (taxi): ");
		     linje = minInn.nextLine();
		     type = linje.charAt(0);
		     // System.out.println(type);		      
		     System.out.print("Bilens pris: ");
		     linje = minInn.nextLine();
		     pris = Double.parseDouble(linje.trim());
		     System.out.println();  
		     if (type == 'p' || type == 'P') nyBil = new Personbil(bilnr, pris);
		     else  if (type == 'l' || type == 'L') nyBil = new Lastebil(bilnr, pris);      
		     else  if (type == 't' || type == 'T') nyBil = new Taxi(bilnr, pris);   
		     alleBiler[index] = nyBil;		     		
		}
		double sumSkatt = 0;
		for (Bil nesteBil: alleBiler) {
		     sumSkatt = sumSkatt + nesteBil.skatt();
		     System.out.println(" Bilen med regnr " + nesteBil.nummer() + 
		                                 " skatter kr. " + nesteBil.skatt() );
		}
		System.out.println();
		System.out.println(" Skatteetatens totale inntekter er "+sumSkatt+" kroner.");
		System.out.println();
	}
}
