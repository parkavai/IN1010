import java.util.Scanner;

public class Input
{
    public static void main(String [] args)
    {
      Scanner in = new Scanner(System.in);
      int cansPerPack = in.nextInt();
      System.out.print(cansPerPack);
    }


}

/*                               Brukerinput
For å la bruker skrive inn en input så må man importere Scanner fra Java
pakken som vist helt øverst. Deretter benyttes Scanner i Main metoden.
Variabelen cansPerPack vil hente verdien fra hva bruker tastet inn.
*/
