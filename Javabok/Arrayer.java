import java.util.Scanner;


public class Arrayer
{
  public static void main(String[] args)
  {
    final int lengde = 10;
    int[] liste = new int[lengde];

/*                               Arrayer
      Ulikt fra python hvor skrivemåten er vist over. Man kan angi lengden på
      arrayen for å vise hvor mange verdier listen kan lagre. Det er vikitg at
      man angir hvilken type verdier som arrayen kan bestå av. Skal man ha tall,
      må man skrive int. Er det strings derimot er det String som må angis.
      Du kan også fylle inn verdier på listen slikt:

      int[] liste = {0,1,2,3,4,5};

      Listen kan også inneholde strings, men da må du angi at listen skal kun
      bestå av strings. Se eksempelet vist under:

      String[] venner = {"John", "Jack"};

      For å aksessere en verdi fra listen, brukes følgende metode:

      liste[i]

      Her vil variabelen "i" være hvilket som helst indeks fra 0 til lengden av
      listen. I dette tilfelle ville det vært alt fra 0 til 10.

      For å endre verdien i en liste, må man aksessere indeksen for den verdien
      man vil endre. Se eksempelet vist under:

      liste[1] = 5;

      Her har jeg endra/lagt til indeks "1" sin verdi i arrayen "liste" med 5.

      int teller = 0;
      Scanner in = new Scanner(System.in);
      while (in.nextInt())
      {
        if (teller < liste.length)
        {
          liste[teller] = in.nextInt();
          teller++;
        }
      }
*/

    int teller = 0;
    int[] nyliste = {};
    Scanner in = new Scanner(System.in);
    while (in.hasNextDouble())
    {
      liste[teller] = in.nextInt();
      teller++;
    }

    for (int i = 0; i < teller; i++)
    {
      System.out.println(liste[i]);
    }

  }

}
