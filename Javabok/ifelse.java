import java.util.Scanner;


public class ifelse
{
    public static void main(String[] args)
    {
      Scanner in = new Scanner(System.in);
      System.out.print("Tast inn lengde: ");
      int lengde = in.nextInt();

      if (lengde == 1)
      {
        System.out.print("True");
      }
      else if (lengde > 2) {
        System.out.print("Tallet er stoerre enn 2");
      }
      else
      {
        System.out.print("False");
      }

      String navn = in.next();
      System.out.println("Teste: ");
      if (navn.equals("Parka"))
      {
        System.out.print("Stemmer");
      }
    }

}


/*                            If-setninger
Fungerer likt som python når det gjelder betingelser, hvilke rekkefølge det
foregår osv.

Under ligger det et kodeprogram for å se hvordan det er å programmere flere
if-setninger i et kodeprogram.

public class ifelse
{
    public static void main(String[] args)
    {
      final double RATE1 = 0.10;
      final double RATE2 = 0.25;
      final double RATE1_SINGLE_LIMIT = 32000;
      final double RATE1_MARRIED_LIMIT = 64000;

      double tax1 = 0;
      double tax2 = 0;

      Scanner in = new Scanner(System.in);
      System.out.print("Please enter your income: ");
      double income = in.nextDouble();

      System.out.print("Please enter s for single, m for married: ");
      String maritalStatus = in.next();

      if (maritalStatus.equals("s"))
      {
        if (income <= RATE1_SINGLE_LIMIT)
        {
            tax1 = RATE1 * income;
        }
        else
        {
          tax1 = RATE1 * RATE1_SINGLE_LIMIT;
          tax2 = RATE1 * (income - RATE1_SINGLE_LIMIT);
        }
      }
      else
      {
        if (income <= RATE1_MARRIED_LIMIT)
        {
            tax1 = RATE1 * income;
        }
        else
        {
          tax1 = RATE1 * RATE1_MARRIED_LIMIT;
          tax2 = RATE1 * (income - RATE1_MARRIED_LIMIT);
        }
      }
      double totalTax = tax1 + tax2;

      System.out.println("The tax is $" + totalTax);
    }

}

*/
