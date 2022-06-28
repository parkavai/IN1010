
public class ExcepTest {

   public static void main(String args[]) {
      try {
         int a[] = new int[2];
         System.out.println("Access element three :" + a[3]);
      } catch (ArrayIndexOutOfBoundsException e) {
         System.out.println("Exception thrown  :" + e);
      }
      System.out.println("Out of the block");
   }
}


/* Exception-håndtering

Exception håndtering handler om å kunne håndtere feil som klassifiseres som error conditions, altså feil 
vi kan håndtere også har vi feil som oppstår på grunn av programmet. Exception håndtering er meget relevant
når vi skal lese inn filer da den såkalte (Scanner objektet) kan finne et forsøk på å lese inn en tom fil,
dette er de feilene vi kan håndtere. Altså når vi leser inn en fil, så må vi ta hensyn til om en klasse 
aldri tar inn en fil og dermed vil vi få en feilmelding som vi kunne ha håndtert hadde vi hatt en 
exception. Det vi gjør når vi vil håndtere slike feil, kan vi benytte oss av følgende: throw, try and catch og throws. 
Disse tre er ulike fra hverandre og begrunnes under.

"Throw"

Throw sørger for at vi bare kaster exception. Den kastes videre til "main" skulle man utføre throw der men 
denne er ikke god nok sammenlignet med de andre når vi jobber med programmer som involverer klasser. Årsaken 
er at throw bare kaster exceptionen, exceptionen blir altså aldri håndtert, og programmet vil slutte der og da.
Dette er ikke bra for komplekse programmer.

"Try and Catch"

Denne sørger for å håndtere exception og er derfor ulik fra throw. I "Try" blocken, vil vi behandle et unntak
som vi har kontroll over. Her skriver vi inn koden som kan feile, hvis vi skal lese inn en fil så kan prosesseringen
skrives her. Mens i "Catch" så behandler vi feilen som oppstår, skulle dette være en fil-feil så vil vi skrive ut 
fileNotfoundexception her. Husk å bruk denne operatoren i komplekse systemer. 

"Throws"

Siste er throws som fungerer slik at vi bare kaster over ansvaret til å håndtere denne feilen til de som 
ser over koden eller til den som faktisk lagde koden. Merk at hensikten med denne er å sørge for at man 
har oversikt over eventuelle exceptions i koden. Det handler bare om å håndtere disse exceptionsene. 




*/