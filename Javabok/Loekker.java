public class Loekker
{
    public static void main(String [] args)
    {
      int i = 0;
      while (i < 10)
      {
        i++;
        System.out.println(i);
      }

/*                               While-løkker
      Samme tankegang som fra python med unntak av dette eksempelet hvor tallet 10 blir
      inkludert. Ellers gjelder de samme reglene som f.eks, løkken fungerer så lenge
      betingelsen gjelder.
*/

      for (int tall = 10; tall <= 20; tall++)
      {
        System.out.println(tall);
      }
    }

/*                               for-løkker
      Samme tankegang som fra python, bruker denne løkken kun når du vet
      at løkken skal foregå i den gitte betingelsen. I dette tilfellet
      så vet jeg at løkken skal kjøre inntil variabel "tall" har nådd 20.
*/

}
