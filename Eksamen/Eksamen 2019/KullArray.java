import java.util.Iterator;

public class KullArray extends Kull{
    Hund[] hundeListe;

    KullArray(Hund mor, Hund far){
        super(mor, far);
        hundeListe = new Hund[60];
    }

    public void settInn(Hund h){
        int sekund = h.minFodselstid.sek;
        Hund forsteIListen = hundeListe[sekund];
        Hund tmp = forsteIListen;
        h.neste = tmp;
        forsteIListen = h;
    }

    @Override
    public void settInnHund(Hund h){
        
    }

    @Override 
    public Iterator<Hund> iterator(){
        return null;
    }



    
}
