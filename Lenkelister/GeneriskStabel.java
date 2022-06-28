public class GeneriskStabel<T> {

    Node foerste = null;

    class Node {
        T data;
        Node neste;
        Node forrige;
        Node(T d) {
            data = d;
            neste = null;
            forrige = null;
        }
        public T hentData(){
            return data;
        }
    }

    void leggPaa(T element){
        Node nyNode = new Node(element);
        if(erTom()){
            foerste = nyNode;
            return;
        }
        Node temp = foerste;
        foerste = nyNode;
        foerste.neste = temp;
    }

    T taAv(){
        T data = null;
        if(erTom()){
            return null;
        }
        data = foerste.hentData();
        foerste = foerste.neste;
        return data;
    }

    boolean erTom(){
        return foerste == null;
    }

    
    
}
