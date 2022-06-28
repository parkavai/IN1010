public class MinDobbeltLenketliste<T> {
    Node foerste = null;
    Node slutt = null;
    int antall = 0;

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
    
    public void settInn(T element){
        antall++;
        Node nyNode = new Node(element);
        if(start == null){
            start = nyNode;
        }

        else{
            Node node = start;
            while (node.neste != null) {
                node = node.neste;
            }
            node.neste = nyNode;
            nyNode.forrige = node;
        }
    }

    public int hentStorrelse(){
        return antall;
    }

    public void skrivUt() {
        Node node = foerste;
        while (node != null) {
          System.out.println(node.hentData());
          node = node.neste;
        }
    }
    
}

/*

class DobbeltLenkeListe <T> {

    Node start;
    class Node{
        Node neste;
        Node forrige;
        T peker;
        Node(T data) {
            this.peker = data;
        }
        public void settNeste(Node n) {
            this.neste = n;
        }
        public void settForrige(Node f){
            this.forrige = f;
        }
        public Node hentNeste(){
            return neste;
        }
        public Node hentForrige(){
            return forrige;
        }
        public T hentData(){
            return peker;
        }
    }

    public void settInn(T element){
        Node nyNode = new Node(element);
        if(start == null){
            start = nyNode;
        }

        else{
            Node node = start;
            while (node.hentNeste() != null) {
                node = node.hentNeste();
            }
            node.settNeste(nyNode);
            nyNode.settForrige(node);
        }
    }

    public void skrivUt() {
        Node node = start;
        while (node != null) {
          System.out.println(node.hentData());
          node = node.hentNeste();
        }
    }
    
}


*/