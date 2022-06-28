// Oppgave 1 c.)

public class Natursti extends Sti{

    Natursti(Kryss ende1, Kryss ende2, int utsiktsVerdi){
        super(ende1, ende2, utsiktsVerdi);
    }
    
    @Override
    public boolean harGodUtsikt(){
        return false;
    }
}
