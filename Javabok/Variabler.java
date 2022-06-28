import java.util.Scanner;

public class Variabler
{
    public static void main(String [] args)
    {

      // Integer

      int flaskerPerPakke = 6;
      final double FLASKE_VOLUM = 0.355;
      double totalVolum = flaskerPerPakke * FLASKE_VOLUM;

      System.out.print("En six-pack av 12-masses flasker består av ");
      System.out.print(totalVolum);
      System.out.println(" liters.");

      final double FLASKE_VOLUMET = 2;

      totalVolum = totalVolum + FLASKE_VOLUMET;

      System.out.print("En six-pack og to-liters flasker består av ");
      System.out.print(totalVolum);
      System.out.println(" liters.");

      // String
      Scanner in = new Scanner(System.in);
      System.out.print("Skriv inn ditt fornavn: ");
      String fornavn = in.next();
      System.out.print("Skriv inn ditt etternavn: ");
      String etternavn = in.next();

      String fullnavn = fornavn.substring(0,1)
      + "&" + etternavn.substring(0,1);
      int lengdeForFornavn = fornavn.length();
      System.out.println(fullnavn + "" + lengdeForFornavn);


    }

}

/*                         For å starte programmet
Hvert javaprogram må alltid starte med en klasse som vist over. Det er viktig
at klassenavnet er det sammet som filnavnet, ellers vil ikke programmet kjøre
i terminalen. Deretter har vi en "main" metode som utfører selve kodingen vår.
Denne metoden består av et sett av mange andre programmeringsinstruksjoner
som utfører enhver oppgave. Derfor er det meget viktig å inkludere "main" ellers
vil ikke kodeprogrammet utføres. Det er også viktig at enhver kodeinstruks
ender med semikolon.


                           Static-metoder
Static kan sees på som en funksjon som utføres når vi starter
programmet vårt. Den kan være nødvendig å bruke for å kunne utføre en spesifikk
metode eller algoritme som å plusse stringer med hverandre osv. Det er ikke brukt
mye når det gjelder objekter da static metoder utføres uten å lage objektet.
For når du lager objekter og skal bruke metodene der, så må du først ha lagd
objekter og kaller på metoden du skal bruke. Static metoder er ikke slik hvor
du ikke behøver å lage objekt for å kunne bruke en gitt metode, static metoden
utføres uansett og er den første som utføres av "main".

                           Void-metoder
Void er hva som skiller en metode til å fungere som en funksjon eller prosedyre.
Hensikten med void-metoder er at de kan kategoriseres som prosedyrer, funksjoner
som ikke har en retuverdi. Void-metoder vil altså ikke returnere noen verdier.

                           Klasse-deklarasjon
Den er et mønster som brukes båder når klassen lages(i det programmet starter opp)
og senere når nye objekter lages

                           Klasse-datastrukturen
Dvs, den (statiske) datastrukturen som lages i det programmet startes.

                           Objekt-datastrukturen
(Også kalt klasse-instanser, klasse-objekter eller bare objekter) som lagres
hver gang vi sier new.


                           Instans-Variabler
Variabler som et objekt får når man lager et "New" objekt.

                           Metode-instans
De lokalve variablene og metodene som objektet får ta bruk av i det metoden kalles
på.
                           Metodens-signatur
Refereres til hvilken type metoden er lagd i, skrivemåten dets og syntaksene
som brukes. Er også navne på metoden og navnene til parameterne i metoden.

                           Semantikk
Dette betyr virkemåten til noe, dette "noe" kan være en metode, et objekt osv.
Det er altså hva metodene gjør og hvordan det skal gjøres.

                           Variabler
Variabler og dets regler fungerer akkurat som på python. Når du lager variabler,
kan du ikke ha mellomrom i variabelnavnet, inkludere tall/symboler i navnet osv.
Vær forsiktig med bokstavstørrelse for java er meget pirkete på stor og liten
forbokstav og mellomrom.

                          Integer
For å lage variabler med flyttall, brukes double. Final brukes for at variablen
aldri skal få skiftet verdi.

                          String
For å lage en string må man bruke datatypen "String", deretter angi variabelnavn
og lage stringen. Viktig å nevne at når du konkatenerer/plusser to variabler
hvor den ene er string, så vil den andre automatisk bli string.

String name = "Harry John";
char start = name.charAt(0);
name.substring(0,4)

"charAt", metode for å hente ut en spesifikk bokstav i et ord. Dette tilfellet,
henter ut første bokstaven i navnet "Harry".

"substring" er en metode som brukes for å hente en gitt del av et ord. I dette
tilfellet så vil substring(0,4) gi oss kun "Harry", ikke hele navnet.

E - Element (used extensively by the Java Collections Framework)
K - Key
N - Number
T - Type
V - Value
*/
