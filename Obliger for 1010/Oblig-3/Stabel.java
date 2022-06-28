class Stabel<T> extends Lenkeliste<T>{

    // Kaller på superklassen som er lenkelisten vår
    public Stabel (){
        super();
    }

    // Trenger kun å angi kallet for metoden leggTil i superklassen sin den legger til elementet på slutten av listen
    public void leggPaa(T x) {
        super.leggTil(x);
    }

    public T taAv(){
        // En lokal variabel som brukes for å hente det siste elementet
        int posisjon = (super.stoerrelse()-1);
        // Henter det siste elementet vi skal fjerne 
        T fjernet = super.fjern(posisjon);
        // Returnerer det fjernede elementet
        return fjernet;
        
    }
    
}
