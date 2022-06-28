// Oppgave 1 c.)

public class UtenforUtsiktsVerdi extends RuntimeException{
    UtenforUtsiktsVerdi(int indeks){
        super("Ugyldig indeks: " + indeks);
    }
    
}
