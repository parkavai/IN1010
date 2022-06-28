
class subKlasse
{

/*                      Subklasse

En subklasse er en klasse som bygger på en allerede spesifisert klasse og dermed
arver dennes egenskaper i tillegg til å utvide med egne egenskaper (metoder/variabler
/konstanter). En subklasse er altså en mer spesialisert utgave av klassen den
bygger på. Klassen vi bygger på kalles en superklasse.

class Person
{
    String navn;
    int tlfnr;

    boolean gyldigTlfnr()
    {

    }

}

class Student
{
    String navn;
    int tlf;
    String program;

    void byttProgram(String nytt)
    {

    }

    boolean gyldigTlfnr()
    {

    }

}

class Ansatt
{
    String navn;
    int tlfnr;
    int lønnstrinn;
    int antallTimer;

    void lønnstillegg(int tillegg) 
    {

    }

    boolean gyldigTlfnr()
    {

    }

}

Vi ser at Person-klassen har instansmetoder og variabler som benyttes av
begge sub-klassene. Blant annet gyldigTlfnr() og instansvariablene navn og tlfnr.
Istedenfor å implementere disse metodene og variablene som er felles for alle
klasser, kan vi gjøre om Ansatt og Student som sub-klasser.

class Person
{
    String navn;
    int tlfnr;

    boolean gyldigTlfnr()
    {

    }

}

class Student extends Person
{

    String program;

    void byttProgram(String nytt)
    {

    }


}

class Ansatt extends Person
{
    int lønnstrinn;
    int antallTimer;

    void lønnstillegg(int tillegg) 
    {

    }

}

Override

Override er det som skjer når vi endrer metoder i subklassen som ble deklarert i superklassen. I dette tilfellet
vil å "endre" metodene bety at vi implementerer ny kode rundt den metoden uten å endre metodens signatur. Derfor 
kan det være lurt å skrive "@Override" for de metodene subklassene arver fra superklassen. 

Overload

Å endre på metodens signatur altså parameterverdiene, kalles for "overloading". Disse metodene er helt annerledes 
selv om de har samme navn siden signaturen til metoden har blitt endret. 

Polymorfi

Polymorfi også kalt virituell metode, er metoder i subklasser som har samme metodesignatur som superklassen. 
Når vi ser på et objekt via en superklasse-peker, mister vi tilgang til dets metoder og variable. Men 
gjennom polymorfi har vi likevel tilgang til superklasse-pekeren, fordi objektets "dypeste" metode brukes. 
Og dette er hensikten med polymorfi da om vi lager et objekt og kaller på disse virituelle metodene, så er 
det objektets verdier som blir printet ut og ikke superklassens sin. Derfor så må en utvikler se om metoden 
har samme signatur eller ikke får å bestemme at metoden skal være virituell. Override er meget relevant for 
polymorfi da den deklarerer at metoden er en virituell metode. 

Interface 

En samling av egenskaper (en rolle) som ikke naturlig hører hjemme i et arvehierarki. Et interface kan 
kun ha metodesignaturer, den skal ikke ha noe implementasjon av metodesignaturer eller en instansvariabler.



*/


}
