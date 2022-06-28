// Oppgave 1 c.)

public class Kjerrevei extends Sti{

    Kjerrevei(Kryss ende1, Kryss ende2, int utsiktsVerdi){
        super(ende1, ende2, utsiktsVerdi);
    }

    @Override
    public boolean harGodUtsikt(){
        return false;
    }
    
}
