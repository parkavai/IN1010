public class ManneligPasient extends Pasient {

    ManneligPasient(String navn, int prio){
        super(navn, prio);
    }

    @Override
    public void kanHaSykdom(){
        Sykehus.kanHaSykdomMann(this);
    }

    @Override 
    public boolean iFaresonen(){
        return Sykehus.iFaresonenMann(this);
    }
    
}
