import java.util.Scanner;

public class Metoder
{

  public static void main(String[] args)
  {
    int areal1 = rektangel(2,5);
    int areal2 = rektangel(5,8);
    System.out.println("Arealet for rektangelen er: " + areal1);
    System.out.println("Arealet for det andre rektangelet er: " + areal2);
  }

  public static int rektangel(int lengde, int bredde)
  {
    int areal = lengde * bredde;
    return areal;
  }

/*                               Metoder
      Samme tankegang som fra python når det gjelder parametre, dets betydning
      for hvordan funksjonen skal fungere. Husk du må alltid angi hvilken type
      parametrene skal ha, om de skal være heltall eller string. Annen ting å
      huske er at metoden skal aldri være inne i main metoden, den skal være separat.
      I tillegg til at man må spesifisere typen til return verdien, i dette
      tilfellet spesifiserte vi at variabel "areal" skulle returnere et heltall.
      Unngå å ha flere returns i en funksjon, det ser finere og mer strukturert
      hvis metoden kun har en return.
*/

}
