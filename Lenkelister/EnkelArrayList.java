import java.util.Iterator;

public class EnkelArrayList implements Iterable<String>{

    String[] liste; 
    int lengde;
    int antall = 0;

    EnkelArrayList(int lengde){
        this.lengde = lengde;
        liste = new String[lengde];
    }

    private class StrengListeIterator implements Iterator<String>{
        int gjeldendeIndeks = 0;

        @Override
        public String next() {
            if(hasNext()){
                return liste[gjeldendeIndeks];
            }
            else {
                return null;
            }
        }

        @Override
        public boolean hasNext() {
            gjeldendeIndeks++;
            return gjeldendeIndeks < hentStoerrelse();
        }
        
        
    }

    void skrivUt(){
        if (iterator().hasNext()){
            String element = iterator().next();
            System.out.println(element);
        }
    }

    public Iterator<String> iterator(){
        return new StrengListeIterator();
    }

    int hentStoerrelse(){
        for (int i = 0; i < liste.length; i++){
            if(liste[i] != null){
                antall++;
            }
        }
        return antall;
    }

    void leggTil(String streng){
        if(liste[0] == null){
            liste[0] = streng;
        }
        liste[antall++] = streng;
    }
    
}
/*
import java.util.Iterator;

public class EnkelArrayListe implements Iterable<String> {
    private String[] arr;
    private int maksStorrelse;
    private int storrelse = 0;

    @SuppressWarnings("unchecked")
    public EnkelArrayListe(int maksStorrelse) {
        this.maksStorrelse = maksStorrelse;
        arr = new String[maksStorrelse];
    }

    public void leggTil(String strengen) {
        if (storrelse >= maksStorrelse) {
            throw new IllegalStateException("Ikke plass til flere");
        }
        arr[storrelse++] = strengen;
    }

    public Iterator<String> iterator() {
        return new ListeIterator();
    }

    private class ListeIterator implements Iterator<String> {
        private int gjeldendeIndeks = 0;

        public String next() {
            return arr[gjeldendeIndeks++];
        }

        public boolean hasNext() {
            return gjeldendeIndeks < storrelse;
        }
    }
}
*/