public class KvinneligPasient extends Pasient {

    KvinneligPasient(String navn, int prio){
        super(navn, prio);
    }

    @Override
    public void kanHaSykdom(){
        Sykehus.kanHaSykdomKvinne(this);
    }

    @Override 
    public boolean iFaresonen(){
        return Sykehus.iFaresonenKvinne(this);
    }
    
}
