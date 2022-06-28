public class SortertLenkeliste<T extends Comparable<T>> extends Lenkeliste<T> {

    // Kaller på superklassen som er lenkelisten vår
    public SortertLenkeliste(){
        super();
    }

    // En metode hvor vi legger til elementer i sortert rekkefølge
    @Override
    public void leggTil( T x){
        // Dataen vi skal legge til i lenkelisten
        T leggTilData = x;
        // Dataen til elementene i lenkelisten
        T sjekkData = null;
        // Sjekker tilfelle hvor lenkelisten er tom, da må vi legge til et element
        if(super.stoerrelse() == 0){
            super.leggTil(x);
            return;
        }

        // Hvis lenkelisten ikke er tom, skal vi da legge til et nytt element i lenkelisten
        else {
            // En for-løkke som iterer gjennom hvert element i lenkelisten
            for(int i = 0; i < super.stoerrelse(); i++){
                // Henter dataen til elementene i lenkelisten
                sjekkData = super.hent(i);
                //Sjekker hvis tidligere elementer i lenkelisten har større verdi enn den nye
                if(sjekkData.compareTo(leggTilData) > 0){
                    // Da skal vi legge til elementet i den angitte posisjonen
                    super.leggTil(i, leggTilData);
                    // Går ut av selve metoden
                    return;
                }
            }
            /* 
                Hvis det nye elementet hadde størst data, skal vi legge til dette elementet
                på slutten av vår lenkede liste
            */
            super.leggTil(leggTilData);
        }
        
    }

    @Override
    public T fjern(){
        // Siste elementet i listen som er da det største elementet
        T stoerstData = null;

        // Sjekker tilfelle hvis lenkelisten er tom, da går det ikke ann å fjerne et element
        if(super.stoerrelse() == 0){
            throw new UgyldigListeIndeks(-1);
        }

        // Hvis lenkelisten ikke er tom, skal vi da fjerne det største elementet fra listen
        else if(super.stoerrelse() != 0){
            // En for-løkke som iterer gjennom hvert element i lenkelisten
            for(int i = 0; i < super.stoerrelse(); i++){
                // Henter dataen til elementene i lenkelisten
                T sjekkData = super.hent(i);
                // Siste elementet i listen som muligens er det største elementet
                stoerstData = super.hent(super.stoerrelse()-1);
                /* 
                    Må ta hensyn til om det siste elementet nødvendigvis ikke er det største elementet.
                    Da må vi fjerne noden til "sjekkData" siden den er det største elementet
                */
                if(sjekkData.compareTo(stoerstData) > 0){
                    super.fjern(i);
                    return sjekkData;
                }
            }
        }
        
        // Hvis det nye elementet hadde størst data, skal vi fjerne dette elementet
        super.fjern(super.stoerrelse()-1);
        return stoerstData;
    }

    // En metode som hindrer muligheten til å legge til et element i en vilkårlig valgt posisjon
    @Override
    public void leggTil(int pos, T x){
        throw new UnsupportedOperationException();
        
    }

    // En metode som hindrer muligheten til å overskrive dataen til et element i en vilkårlig valgt posisjon
    @Override
    public void sett(int pos, T x){
        throw new UnsupportedOperationException();
        
    }
}
