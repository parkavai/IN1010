import java.util.Iterator;

public class KullListe extends Kull{

    Hund forste = null; 

    KullListe(Hund mor, Hund far){
        super(mor, far);
    }

    private class HundeListe implements Iterator<Hund>{

        @Override
        public Hund next(){
            Hund tmp = forste;
            forste = forste.neste;
            return tmp;
        }

        @Override
        public boolean hasNext(){
            return forste != null;
        }

    }

    @Override 
    public Iterator<Hund> iterator(){
        return new HundeListe();
    }

    @Override 
    public void settInnHund(Hund h){
        if(forste == null){
            forste = h;
            return;
        }
        if(h.compareTo(forste) > 0){
            h = forste.neste;
            forste = h;
            return;
        }
        Hund tmp = forste;
        Hund forrige = null;
        // Kjører så lenge vi ikke er mot slutten av listen eller om den nye hunden er eldre enn de andre hundene i listen
        while (tmp != null && h.compareTo(tmp) < 0){
            forrige = tmp;
            tmp = tmp.neste;
        }
        if(tmp == null){
            tmp = h;
            return;
        }
        // Betyr at den nye hunden er yngre 
        if(h.compareTo(tmp) > 0){
            forrige.neste = h;
            h.neste = tmp;
        }
    }
    
}
