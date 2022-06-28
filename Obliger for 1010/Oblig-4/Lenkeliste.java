import java.util.Iterator;

class Lenkeliste<T> implements Liste<T>{

    protected class Node {
        protected T data;
        protected Node neste;
        public Node(T d) {
            data = d;
            neste = null;
        }
        public void settNeste(Node n) {
            neste = n;
        }
        public T hentData(){
            return data;
        }
    }

    public Iterator<T> iterator() {
        return new LenkeListeIterator();
    }

    private class LenkeListeIterator implements Iterator<T> {
        Node iStart = start;

        @Override
        public T next() {
            if (hasNext()) {
                T idata = iStart.data;
                iStart = iStart.neste;
                return idata;
            }
            return null;
        }

        @Override
        public boolean hasNext() {
            return (iStart != null);
        }

    }

    protected Node start = null;
    protected Node slutt = null;

    @Override
    public int stoerrelse() {
        int teller = 0;
        if(start == null) {
            return 0;
        }
        Node peker = start;
        while (peker != slutt){
            peker = peker.neste;
            teller ++;
        }
        return teller;
    }

    @Override
    public void leggTil(T x) {
        Node nyNode = new Node(x);
        if (start == null) {
            start = nyNode;
            return;
        }
        Node iterNode = start;
        while (iterNode.neste != null) {
            iterNode = iterNode.neste;
        }
        iterNode.neste = nyNode;
    }
    
    @Override
    public void leggTil(int pos, T x){
        Node lagtTilNode = new Node(x);
        Node forrige = null;
        Node peker = start;
        int counter = 0;
        if(pos < 0 || pos > stoerrelse()){
            throw new UgyldigListeIndeks(pos);
        }
        else if(pos == 0){
            if (start == null) {
                start = lagtTilNode;
                return;
            }
            else {
                Node temp = start;
                lagtTilNode.neste = temp;
                start = lagtTilNode;
                start.settNeste(temp);
                return;
            }
        } 
        else{
            while(peker != slutt && counter != pos){
                forrige = peker;
                peker = peker.neste;
                counter++;
            }
            if(peker == slutt){
                leggTil(x);
            }
            lagtTilNode.neste = peker;
            forrige.settNeste(lagtTilNode);
        }        
    }
    
    @Override
    public void sett(int pos, T x){
        Node peker = start;
        T data = x;
        if (start == null) {
            throw new UgyldigListeIndeks(-1);
        }
        else if(pos < 0 || pos >= stoerrelse()){
            throw new UgyldigListeIndeks(pos);
        }
        else if (peker != slutt) {
            for(int i = 0; i < pos; i++) {
                peker = peker.neste;
            }
            peker.data = data;
        }

    }
    
    
    @Override
    public T hent(int pos){
        Node peker = start;
        T angittData = null;
        if (start == null){
            throw new UgyldigListeIndeks(-1);
        }
        else if(pos < 0 || pos >= stoerrelse()){
            throw new UgyldigListeIndeks(pos);
        }
        else {
            for(int i = 0; i < pos; i++) {
                peker = peker.neste;
            }   
            angittData = peker.hentData();
        }
        return angittData;
    }

    
    @Override
    public T fjern(int pos){
        Node peker = start;
        Node forrige = null;
        T fjernet = null;
        int counter = 0;
         
        if (start == null){
            throw new UgyldigListeIndeks(-1);
        }
       
        else if(pos < 0 || pos+1 > stoerrelse()){
            throw new UgyldigListeIndeks(pos);
        }
       
        else if(pos == 0){
            start = peker.neste;
            fjernet = peker.hentData();
            return fjernet;
        }
            
        else {
            while(peker != slutt && counter != pos){
                forrige = peker;
                peker = peker.neste;   
                counter++;
            }
            if(peker == slutt){
                return null;
            }
            forrige.settNeste(peker.neste); 
            fjernet = peker.hentData();
            return fjernet;
        }
    }

    
    @Override
    public T fjern(){
        T foerste = null;
        if (start == null){
            throw new UgyldigListeIndeks(-1);
        }
        foerste = start.hentData();
        start = start.neste;
        return foerste;  
    }

    @Override
    public String toString() { 
        String strenge = "";
        Node tmp = start;
        for (int i = 0; i < stoerrelse(); i++) {
            strenge += tmp.data + "\n";
            tmp = tmp.neste;
            strenge += "\n";
        }
        return strenge;
    }
}